<?php
/**
 * Created by PhpStorm.
 * User: HXL
 * Date: 2017/10/19
 * Time: 11:20
 */
namespace app\index\controller;

use app\index\controller\Base;
use app\index\getcode\GetCode;
use app\index\model\States;
use app\index\common\Common;

class State extends Base{

    /*
     * 添加国家
     * */
    public function addStates(){
        $st = $this->state();
        $states = $this->getStates($st);
        if (empty($states['stId']) || empty($states['state'])){
            return $this->error('信息不能为空');
        }
        /*$validate = $this->validate($states, 'States');
        //var_dump($validate);exit();
        if (true !== $validate){
            return $this->error(" $validate ");
        }*/
        $stId = $this->state()->findById(array('stId'=>$states['stId']));
        $state = $this->state()->findById(array('state'=>$states['state']));
        if ($stId || $state){
            return $this->error('该国家信息已存在');
        }
        $result = $st->add($states, '');
        //var_dump($result);exit();
        if (!$result){
            return $this->error('添加失败');
        }
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
        $tableStates = 'states';
        $search = $this->base()->search($tableStates, '', $param, $html, $field, $where, $destination);
        return $search;
    }
    /*
     *查询修改国家的信息
     */
    public function states(){
        $stId = input('stId/s');
        $field = 'stId,state';
        $where = array('stId'=>$stId);
        $data = $this->state()->select($field, $where);
        echo json_encode($data);
    }
    /*
     * 国家信息修改
     * */
    public function editStates(){
        $stId = input('stId/s');
        //var_dump($stId);exit();
        $where = array('stId'=>$stId);
        $find = $this->state()->findById($where);
        if (!$find){
            return $this->error('未找到该国家信息');
        }
        $state = input('param.state');
        $states = array(
            'stId'=> $stId,
            'state'=> $state
        );
        //var_dump($states);exit();
        $result = $this->state()->update($states, $where);
        //var_dump($result);exit();
        if (!$result){
            return $this->error('修改失败');
        }
        return $this->success('修改成功', 'user/listStates');
    }
    /*
     * 删除国家
     * */
    public function deleteStates(){
        $stId = input('stId');
        //特殊符号处理
        if ($stId{0} == ' '){
            $stId = str_replace(' ', '+', $stId);
            //var_dump($stId);exit();
            $result = $this->delSta($stId);
            return $result;
        }
        //$stId=rawurldecode($stId);
        //var_dump($stId);exit();
        $result = $this->delSta($stId);
        return $result;
    }
    public function delSta($stId){
        $where = array('stId'=>$stId);
        $find = $this->state()->findById($where);
        if (!$find){
            return $this->error('未找到该国家');
        }
        $delete = $this->state()->del($where);
        if (!$delete){
            return $this->error('删除失败');
        }
        return $this->success('删除成功', 'user/listStates');
    }

    public function getStates($st){
        //$st = $this->state();
        $stId = input('param.stId');
        $state = input('param.state');
        $st->setStId($stId);
        $st->setState($state);
        $states = array(
            'stId'=> $st->getStId(),
            'state'=> $st->getState()
        );
        return $states;
    }
    /**
     * 使用类
     * */
    public function base(){
        $base = new Base();
        return $base;
    }
    public function codes(){
        $co = new Code();
        return $co;
    }
    public function state(){
        $st = new States();
        return $st;
    }
}