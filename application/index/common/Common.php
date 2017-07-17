<?php
/**
 * Created by PhpStorm.
 * User: HXL
 * Date: 2017/5/11
 * Time: 11:37
 */
namespace app\index\common;

use think\Db;

class Common{
    public function _initialize(){
        //判断用户是否已经登录
        if (!isset($_SESSION['adId'])) {
            $this->error('对不起,您还没有登录!请先登录', 'Login/login');
        }
    }
    /*
     * 添加  add
     * */
    public function add($params, $tableName){
        $result = Db::table($tableName)->insert($params);
        return $result;
    }

    /*
     * 修改  update
     * */
    public function edit($params, $tableName, $where){
        $result = Db::table($tableName)->where($where)->update($params);
        var_dump($result);exit();
        return $result;
    }

    /*
     * 删除  delete
     * */
    public function delete($tableName, $where){
        $result = Db::table($tableName)->where($where)->delete();
        return $result;
    }

    /*
     * 查找  select
     * */
    public function select($tableName, $where){
        $result = Db::table($tableName)->where($where)->select();
        return $result;
    }

    /*
     * 判断用find 是否在数据库中 0表示存在，1表示不存在 
     * */
    public function find($field, $where, $tableName){
        $find = Db::table($tableName)->field($field)->where($where)->find();
        if ($find){
            return 0;   //表示已存在在数据库中
        }
        return 1;   //表示数据库中没有该数据
    }
    /*
     * 查找find
     * */
    public function findParam($where, $tableName){
        $find = Db::table($tableName)->where($where)->find();
        return $find;
    }

}
