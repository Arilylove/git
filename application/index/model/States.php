<?php
/**
 * Created by PhpStorm.
 * User: HXL
 * Date: 2017/6/1
 * Time: 15:44
 */
namespace app\index\model;

use app\index\controller\Base;
use think\Controller;
use think\Db;
use app\index\common\Common;

class States extends Controller{
    protected $tableStates = 'states';

    /*
    * 公共类（Common）
    * */
    public function com(){
        $com = new Common();
        return $com;
    }
    /*
     * base类（Base）
     * */
    public function base(){
        $base = new Base();
        return $base;
    }
    
    /*
   * 添加国家
   * */
    public function add(){
        $stId = input('param.stId');
        $state = input('param.state');
        $states = array(
            'stId'=> $stId,
            'state'=> $state
        );

        if (empty($stId) || empty($state)){
            return $this->error('信息不能为空');
        }
        $stId = $this->com()->find('stId', array('stId'=>$stId), $this->tableStates);
        $state = $this->com()->find('state', array('state'=>$state), $this->tableStates);
        if (!$stId){
            return $this->error('国家代码已存在');
        }
        if (!$state){
            return $this->error('国家名称已存在');
        }
        Base::startTrans();
        $result = Db::table($this->tableStates)->insert($states);
        //var_dump($result);exit();
        if (!$result){
            Base::rollback();
            return $this->error('添加失败');
        }
        Base::commit();
        return $this->success('添加成功', 'user/listStates');
    }
    /*
     * 国家列表
     * */
    public function listStates(){
        $param = null;
        $where = '';
        $html = 'states';
        $field = 'stId,state';
        $destination = 'user/listStates';
        $search = $this->base()->search($this->tableStates, '', $param, $html, $field, $where, $destination);
        return $search;
    }
    /*
     *查询修改国家的信息
     */
    public function state(){
        $stId=input('param.stId');
        $d=Db::table($this->tableStates)->where('stId',$stId)->select();
        echo json_encode($d);
    }
    /*
     * 国家信息修改
     * */
    public function edit(){
        $stId = input('param.stId');
        $find = $this->com()->find('stId', array('stId'=>$stId), $this->tableStates);
        if ($find){
            return $this->error('未找到该国家信息');
        }
        $state = input('param.state');
        $states = array(
            'stId'=> $stId,
            'state'=> $state
        );
        //var_dump($states);exit();
        $result = Db::table($this->tableStates)->where('stId', $stId)->update($states);
        //var_dump($result);exit();
        if (!$result){
            return $this->error('修改失败');
        }
        return $this->success('修改成功', 'user/listStates');
    }
    /*
     * 删除国家
     * */
    public function delete(){

        $stId = input('param.stId');
        //var_dump($cliId);exit();
        $find = $this->com()->find('stId', array('stId'=>$stId), $this->tableStates);
        if ($find){
            return $this->error('未找到该国家');
        }
        $delete = $this->com()->delete($this->tableStates, array('stId'=>$stId));
        if (!$delete){
            return $this->error('删除失败');
        }
        return $this->success('删除成功', 'user/listStates');
    }


}