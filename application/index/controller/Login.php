<?php
namespace app\index\controller;

use think\Controller;
use think\Db;
use org\Verify;
use app\index\crypt\AesCrypt;

/*
*登录控制器
*/
class Login extends Controller{
    
    public function index(){
        return $this->fetch('login/index');
    }

    //后台登录
    public function login(){
        $admin['username'] = input('param.username');
        $admin['password'] = input('param.password');
        $hex = new AesCrypt();
        $admin['password'] = $hex->encrypt($admin['password']);
        //var_dump($admin['password']);exit();
        $code = input("post.code");
        //var_dump($username);exit;
        $verify = new Verify();
        $check = $verify->check($code);
        if (!$check){
            return $this->error('验证码错误', $_SERVER['HTTP_REFERER']);
        }
        $hasAdmin = Db::table('Admin')->where('username', $admin['username'])->find();
        //var_dump($hasAdmin['password']);exit();
        if (empty($hasAdmin)){
            return $this->error('用户不存在', $_SERVER['HTTP_REFERER']);
        }

        if ($admin['password'] != $hasAdmin['password']){
            return $this->error('密码错误', $_SERVER['HTTP_REFERER']);
        }
        session('username', $admin['username']); //保存到session中判断是否登录
        session('status', $hasAdmin['status']); //保存用户权限，判断是管理员还是用户。
        //var_dump($hasAdmin['status']);exit;
        if ($hasAdmin['status'] == 0){
            return $this->success('登录成功', 'admin/listAdmin');
        }
        return $this->success('登录成功', 'user/listStates');

    }
    //验证码
    public function verify(){
        $verify = new Verify();
        $verify->imageH = 36;
        $verify->imageW = 140;
        $verify->length = 4;
        $verify->useNoise = false;
        $verify->fontSize = 18;
        return $verify->entry();
    }

    public function out(){
        if (true){
            session('username', null);
            session('status', null);
            return $this->fetch('login/index');
        }
        return false;
    }




    
}