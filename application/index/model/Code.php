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
use app\index\getcode\GetCode;
use app\index\common\Common;
use think\Db;

class Code extends Controller{
    protected $tableCode = 'code';
    protected $tableClient = 'client';

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
     * 注册码列表
     * */
    public function listCode(){
        $where = '';
        $param = 'cliId';
        $html = 'code';
        $field = 'coId,company,mac,creator,createTime,expireTime,code';
        $destination = 'user/listCode';
        //获取不重复的公司名
        $client = Db::table($this->tableClient)->field('company,cliId')->distinct(true)->select();
        //var_dump($client);exit();
        $this->assign('client', $client);
        $search = $this->base()->search($this->tableCode, $this->tableClient, $param, $html, $field, $where, $destination);
        return $search;
    }

    /*
     * 申请注册码
     * */
    public function add1(){
        $client = Db::table($this->tableClient)->field('company')->distinct(true)->select();
        //var_dump($client);exit();
        $this->assign('client', $client);
        return $this->fetch('user/add');
    }

    public function add(){
        

    }
    /*
   *查询修改注册码的信息
   */
    public function code(){
        
    }
    /*
     * 查询即将失效注册码,失效日期在当前日期之后30天以内
     * */
    public function soonExpireCode(){
        //只显示即将失效的注册码，已经失效的则不显示
        $soonTime = date('Ymd', strtotime('+1 month'));
        $expire = date('Ymd', strtotime('-1 minute'));
        /*$code = Db::table($this->tableCode)
            ->alias('co')->join($this->tableClient.' cli', 'co.cliId=cli.cliId')
            ->where('expireTime', '>', $expire)->where('expireTime', '<', $soonTime)->select();*/
        //var_dump($code);exit();
        $destination = 'user/soonExpireCode';
        $param = 'cliId';
        $html = 'expireCode';
        //条件很重要！！！！！！！！！！！！！！！！！！！！！！！
        $where = array('expireTime'=>['between', [$expire, $soonTime]]);
        $field = 'coId,company,mac,creator,createTime,expireTime,code';
        //获取不重复的公司名
        $client = Db::table($this->tableClient)->field('company,cliId')->distinct(true)->select();
        //var_dump($client);exit();
        $this->assign('client', $client);
        $search = $this->base()->search($this->tableCode, $this->tableClient, $param, $html, $field, $where, $destination);
        return $search;
    }

}