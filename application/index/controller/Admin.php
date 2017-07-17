<?php
/**
 * Created by PhpStorm.
 * User: HXL
 * Date: 2017/5/8
 * Time: 15:36
 */
namespace app\index\controller;

use app\index\controller\Base;
use app\index\crypt\AesCrypt;
use app\index\model\Admins;
use app\index\common\Common;

class Admin extends Base{
    protected $tableAdmin = 'admin';

    /*
        * 公共类（Common）
        * */
    public function com(){
        $com = new Common();
        return $com;
    }

    /*
	*查询修改的信息
	*/
    public function one(){
        $adId = input('param.adId');
        $where = array('adId'=>$adId);
        $data = $this->com()->select($this->tableAdmin, $where);
        echo json_encode($data);
    }

    /*
     * 用户列表search($tableName1, $tableName2 = '', $param, $html, $field, $where, $destination)
     * */
    public function listAdmin(){
        $admin = new Admins();
        $listAdmin = $admin->listAdmin();
        return $listAdmin;
    }

    /*
     * 增加用户
     * */
    public function addAdmin(){
        $admin = new Admins();
        $add = $admin->add();
        if (!$add){
            return $this->error('添加失败');
        }
        return $this->success('添加成功', 'admin/listAdmin');
    }
    /*
     * 删除用户
     * */
    public function deleteAdmin(){
        $admin = new Admins();
        $delete = $admin->delete();
        if (!$delete){
            return $this->error('删除失败');
        }
        //弹出确认窗口
        return $this->success('删除成功', 'admin/listAdmin');
    }

    /*
     * 用户信息编辑
     * */
    public function editAdmin(){
        $admin = new Admins();
        $result = $admin->edit();
        if (!$result){
            return $this->error('修改失败');
        }
        return $this->success('修改成功', 'admin/listAdmin');
    }
    


}