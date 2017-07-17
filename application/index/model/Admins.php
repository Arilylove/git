<?php
/**
 * Created by PhpStorm.
 * User: HXL
 * Date: 2017/6/1
 * Time: 15:44
 */
namespace app\index\model;

use think\Controller;
use app\index\controller\Base;
use app\index\crypt\AesCrypt;
use app\index\common\Common;

class Admins extends Controller{
    protected $tableAdmin = 'admin';
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
	*查询修改的信息
	*/
    public function one(){
        $adId = input('param.adId');
        $where = array('adId'=>$adId);
        $d = $this->com()->select($this->tableAdmin, $where);
        echo json_encode($d);
    }

    /*
     * 用户列表search($tableName1, $tableName2 = '', $param, $html, $field, $where, $destination)
     * */
    public function listAdmin(){
        // $admin = Db::table($this->tableAdmin)->select();
        $tableName2 = '';
        $param = '';
        $html = 'admin';
        $field = 'username,surname,password,adId,status,createTime';
        $where = '';
        $destination = 'admin/listAdmin';
        $listAd = $this->base()->search($this->tableAdmin, $tableName2, $param, $html, $field, $where, $destination);
        return $listAd;
    }

    /*
     * 增加用户
     * */
    public function add(){
        $hex = new AesCrypt();
        $postPassword = input('param.password');    //获取的默认密码值：123456；
        $password = $hex->encrypt($postPassword);   //密码用AES加密；
        $time = $_SERVER['REQUEST_TIME'];         //客户端向服务端发送请求的时间
        $adId = input('param.adId');
        $username = input('param.username');
        $surname = input('param.surname');
        $createTime = date('Y-m-d H:i:s', $time);
        $status = input('param.status');
        $admin = array(
            'adId'=> $adId,
            'username'=> $username,
            'surname'=> $surname,
            'password'=> $password,
            'createTime'=> $createTime,
            'status'=> $status
        );
        //$where = array('adId', $adId);
        $adId = $this->com()->find('adId', array('adId'=>$adId), $this->tableAdmin);
        $username = $this->com()->find('username', array('username'=>$username), $this->tableAdmin);
        if (!$adId){
            return $this->error('用户编号已存在');
        }
        if (!$username){
            return $this->error('用户名已存在');
        }
        $result = $this->com()->add($admin, $this->tableAdmin);
        return $result;
    }
    /*
     * 删除用户
     * */
    public function delete(){
        $adId = input('param.adId');
        //var_dump($adId);exit;
        $findId = $this->com()->find('adId', array('adId'=>$adId), $this->tableAdmin);
        if ($findId){
            return $this->error('未找到该用户');
        }
        $where = array('adId'=>$adId);
        $delete = $this->com()->delete($this->tableAdmin, $where);
        return $delete;
    }

    /*
     * 用户信息编辑
     * */
    public function edit(){
        $adId = input('param.adId');
        $username = input('param.username');
        $surname = input('param.surname');
        $status = input('param,status');
        $admin = array(
            'adId'=> $adId,
            'username'=> $username, //用户名不可更改
            'surname'=> $surname,
            'status'=> $status
        );
        $findUser = $this->com()->find('username', array('username'=>$username), $this->tableAdmin);
        if ($findUser){
            return $this->error('未找到该用户');
        }
        $admin['updateTime'] = time();
        $where = array('username'=>$username);
        $result = $this->com()->edit($admin, $this->tableAdmin, $where);
        return $result;
    }

}