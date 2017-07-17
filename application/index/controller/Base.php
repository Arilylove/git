<?php
/**
 * Created by PhpStorm.
 * User: HXL
 * Date: 2017/5/9
 * Time: 13:26
 */
namespace app\index\controller;

use think\Controller;
use think\Request;
use think\Db;
use app\index\crypt\AesCrypt;
use app\index\common\Common;

class Base extends Controller{

    public function _initialize(){
        //判断是否登录
        //$hasAdmin = Db::table('Admin')->where('username', $username)->find();
        $username = session('username');
        if (empty($username)){
            return  $this->error('您尚未登录或登录超时，请重新登录', 'Login/index');
        }
        //Route::alias('user', 'index/User');
        //Route::alias('user','\app\index\controller\User');
        $status = session('status');
        $this->assign('username', $username);
        $this->assign('status', $status);
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
     * 搜索
     * */
    public function search($tableName1, $tableName2 = '', $param, $html, $field, $where, $destination){
        $select = input('param.sel');
        $searchText = input('param.search_text');//搜索框中输入的内容
        if (!empty($searchText)) {
            //选择框默认不为空，按条件（搜索内容为对应值）选择
            //需要进行联合查询的
            if ($param != null){
                $multiTableList = $this->multiTable($tableName1, $tableName2, $param, $select, $searchText, $where, $field, $html, $destination);
                return $multiTableList;
            }
            //单表查询
            $single = $this->singleTable($tableName1, $field, $select, $searchText, $where, $html, $destination);
            return $single;
        }
        //搜索内容为空，直接显示列表,联合查询
        if ($tableName2 != ''){
            $multiTableList = $this->multiTable($tableName1, $tableName2, $param, $select, $searchText, $where, $field, $html, $destination);
            return $multiTableList;
        }
        //单表查询
        $single = $this->singleTable($tableName1, $field, $select, $searchText, $where, $html, $destination);
        return $single;
    }

    /*
     * 单表查询
     * */
    public function singleTable($tableName1, $field, $select, $searchText, $where, $html, $destination){
        $count = Db::table($tableName1)->where($select, $searchText)->count();
        $table = Db::table($tableName1)->field($field)
            ->where($select, $searchText)->where($where)->paginate(5, $count);
        //var_dump($table);exit();
        $page = $table->render();
        //$this->assign('list', $list);
        $this->assign('page', $page);     //list 是列表内容
        $this->assign($html, $table);
        return $this->fetch($destination);
    }

    /*
     * 多表查询
     * */
    public function multiTable($tableName1, $tableName2, $param, $select, $searchText, $where, $field, $html, $destination){
        $count = Db::table($tableName1)->join($tableName2, $tableName1.'.'.$param.'='.$tableName2.'.'.$param)
            ->where($select, $searchText)->count();
        if (empty($searchText)){
            //没有field直接显示列表
            $table = Db::table($tableName1)->join($tableName2, $tableName1.'.'.$param.'='.$tableName2.'.'.$param)
                ->where($select,  $searchText)->where($where)->paginate(5, $count);
            $result = $this->pulicList($html, $table, $destination);
            return $result;
        }
        $table = Db::table($tableName1)->join($tableName2, $tableName1.'.'.$param.'='.$tableName2.'.'.$param)
            ->field($field)->where($select,  $searchText)->where($where)->paginate(5, $count);
        //echo Db::table($tableName1)->getLastSql().'<br/>';
        $result = $this->pulicList($html, $table, $destination);
        return $result;
    }

    /*
     * 公用列表-=>多表
     * */
    public function pulicList($html, $table, $destination){
        $page = $table->render();
        //$this->assign('list', $list);
        $this->assign('page', $page);     //list 是列表内容
        $this->assign($html, $table);
        return $this->fetch($destination);
    }

    /*
      *修改密码
      * */
    public function update(){
        $username = session('username');
        $this->assign('username', $username);
        return $this->fetch('Base/updatePassword');
    }
    public function updatePassword(){
        $username = session('username');
        $this->assign('username', $username);
        $find = $this->com()->find('username', array('username'=>$username), 'admin');
        if ($find){
            return $this->error('该用户不存在');
        }
        //var_dump($admin);exit;
        $admin = Db::table('admin')->where('username', $username)->find();
        //var_dump($admin['password']);exit();
        $this->assign('adId', $admin['adId']);
        $string = new AesCrypt();
        //解密
        $password = $string->decrypt($admin['password']);
        //var_dump($password);exit();
        $inputPassword = input('param.password');
        $update = input('param.update');
        $confirm = input('param.confirm');
       if (true){
           if ($update == $password){
               return $this->error('修改密码同原始密码相同');
           }
           if ($update == ''){
               return $this->error('密码不能为空');
           }
           if ($update != $confirm){
               return $this->error('两次输入密码不相同');
           }
           $update = $string->encrypt($update); //再加密后写入数据库
           $result = Db::table('admin')->where('username', $username)->update(['password'=>$update]);
           //var_dump($result);exit();
           if (!$result){
               return $this->error('修改失败');
           }
           if ($admin['status'] == 0){   //管理员
               session('username', null);
               session('status', null);
               return $this->success('修改成功,请重新登录', 'login/index');
               //return $this->success('修改成功');
           }
           session('username', null);
           session('status', null);
           return $this->success('修改成功,请重新登录', 'login/index');
           //return $this->success('修改成功');
       }

    }

    /*
     * 事务操作；
     * */
    public static function startTrans() {
        Db::startTrans();
    }

    public static function commit() {
        Db::commit();
    }

    public static function rollback() {
        Db::rollback();
    }
    

}