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

    /*
    * 控制器判断
    * */
    public function isAdmin(){
        $controll = lcfirst( request()->controller() );//控制器名
        if ($controll != 'Admin'){
            return false;
        }
        return true;
    }
    /**
     * 引用其他类
     **/
    public function com(){
        $com = new Common();
        return $com;
    }
    public function base(){
        $b= new Base();
        return $b;
    }
    public function admin(){
        $ad = new Admins();
        return $ad;
    }
    public function hex(){
        $hex = new AesCrypt();
        return $hex;
    }

    /**
	*查询修改的信息
	*/
    public function one(){
        $adId = input('param.adId');
        $where = array('adId'=>$adId);
        $field = 'adId,username,surname,password,status,createTime';
        $data = $this->admin()->select($field, $where);
        echo json_encode($data);
    }

    /**
     * 用户列表search($tableName1, $tableName2 = '', $param, $html, $field, $where, $destination)
     * */
    public function listAdmin(){
        $tableName2 = '';
        $param = '';
        $html = 'admin';
        $field = 'username,surname,password,adId,status,createTime,updateTime';
        $where = '';
        $destination = 'admin/listAdmin';
        $tableAdmin = 'admin';
        $listAd = $this->base()->search($tableAdmin, $tableName2, $param, $html, $field, $where, $destination);
        return $listAd;
    }
    

    /**
     * 增加用户
     * */
    public function addAdmin(){
        $ad = $this->admin();
        $hex = $this->hex();
        $postPassword = input('param.password');    //获取的默认密码值：123456；
        $password = $hex->encrypt($postPassword);   //密码用AES加密；
        $time = $_SERVER['REQUEST_TIME'];         //客户端向服务端发送请求的时间
        $username = input('param.username');
        $surname = input('param.surname');
        $createTime = date('Y-m-d H:i:s', $time);
        $status = input('param.status');
        $ad->setUsername($username);
        $ad->setSurname($surname);
        $ad->setCtreateTime($createTime);
        $ad->setStatus($status);
        $ad->setPassword($password);
        $admin = array(
            'username'=> $ad->getUsername(),
            'surname'=> $ad->getSurname(),
            'password'=> $ad->getPassword(),
            'createTime'=> $ad->getCtreateTime(),
            'status'=> $ad->getStatus()
        );
        //var_dump($admin);exit();
        //$admin = $this->getAdminParamsForAdd($hex, $ad);
        $where = array();
        //判断
        $username = $admin['username'];
        $find = $ad->findById(array('username'=>$username));
        if($find){
            return $this->error('用户已存在');
        }
        $add = $ad->add($admin, $where);
        if (!$add){
            return $this->error('添加失败');
        }
        return $this->success('添加成功', 'admin/listAdmin');
    }
    /**
     * 删除用户
     * */
    public function deleteAdmin(){
        $adId = input('param.adId');
        var_dump($adId);exit();
        $admin = $this->admin();
        $where = array('adId'=>$adId);
        $delete = $admin->del($where);
        if (!$delete){
            return $this->error('删除失败');
        }
        //弹出确认窗口
        return $this->success('删除成功', 'admin/listAdmin');
    }

    /**
     * 用户信息编辑
     * */
    public function editAdmin(){
        $ad = $this->admin();
        $time = $_SERVER['REQUEST_TIME'];         //客户端向服务端发送请求的时间
        $username = input('param.username');
        $surname = input('param.surname');
        $updateTime = date('Y-m-d H:i:s', $time);
        $status = input('param.status');
        //$createTime = input('get.createTime');
        $ad->setUsername($username);
        $ad->setSurname($surname);
        $ad->setUpdateTime($updateTime);
        $ad->setStatus($status);
        //$ad->setCtreateTime($createTime);
        $admin = array(
           // 'createTime'=>$ad->getCtreateTime(),
            'username'=> $ad->getUsername(),
            'surname'=> $ad->getSurname(),
            'updateTime'=> $ad->getUpdateTime(),
            'status'=> $ad->getStatus()
        );
        //var_dump($admin);exit();
        $where = array('username'=>$admin['username']);
        $findUser = $ad->findById($where);
        //var_dump($findUser);exit();
        if (!$findUser){
            return $this->error('未找到该用户');
        }
        $result = $ad->update($admin, $where);
        if (!$result){
            return $this->error('修改失败');
        }
        return $this->success('修改成功', 'admin/listAdmin');
    }

    /**
     * @param $hex
     * @param $ad
     * @return array
     * @Description 获取前端输入的参数---添加
     */
    public function getAdminParamsForAdd($hex, $ad){
        $postPassword = input('param.password');    //获取的默认密码值：123456；
        $password = $hex->encrypt($postPassword);   //密码用AES加密；
        $time = $_SERVER['REQUEST_TIME'];         //客户端向服务端发送请求的时间
        $username = input('param.username');
        $surname = input('param.surname');
        $createTime = date('Y-m-d H:i:s', $time);
        $status = input('param.status');
        $ad->setUsername($username);
        $ad->setSurname($surname);
        $ad->setCtreateTime($createTime);
        $ad->setStatus($status);
        $ad->setPassword($password);
        $admin = array(
            'username'=> $ad->getUsername(),
            'surname'=> $ad->getSurname(),
            'password'=> $ad->getPassword(),
            'createTime'=> $ad->getCtreateTime(),
            'status'=> $ad->getStatus()
        );
        return $admin;
    }
    public function getAdminParamsForUpdate($ad){
        $time = $_SERVER['REQUEST_TIME'];         //客户端向服务端发送请求的时间
        $username = input('param.username');
        $surname = input('param.surname');
        $updateTime = date('Y-m-d H:i:s', $time);
        $status = input('param.status');
        $ad->setUsername($username);
        $ad->setSurname($surname);
        $ad->setUpdateTime($updateTime);
        $ad->setStatus($status);
        $admin = array(
            'username'=> $ad->getUsername(),
            'surname'=> $ad->getSurname(),
            'updateTime'=> $ad->getUpdateTime(),
            'status'=> $ad->getStatus()
        );
        return $admin;
    }
    


}