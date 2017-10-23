<?php
/**
 * Created by PhpStorm.
 * User: HXL
 * Date: 2017/10/19
 * Time: 11:18
 */
namespace app\index\controller;

use app\index\controller\Base;
use app\index\getcode\GetCode;
use app\index\model\States;
use app\index\common\Common;

class Code extends Base{


    /*
     * 注册码列表
     * */
    public function listCode(){
        $where = '';
        $param = 'cliId';
        $html = 'code';
        $field = 'coId,company,mac,creator,createTime,expireTime,code,other';
        $destination = 'user/listCode';
        $tableClient = 'client';
        $tableCode = 'code';
        //获取不重复的公司名
        $client = $this->clients()->selectDistinct('company,cliId', $where);
        //var_dump($client);exit();
        $this->assign('client', $client);
        $search = $this->base()->search($tableCode, $tableClient, $param, $html, $field, $where, $destination);
        return $search;
    }

    /*
     * 申请注册码
     * */
    public function add(){
        $client = $this->clients()->selectDistinct('company', '');
        //var_dump($client);exit();
        $this->assign('client', $client);
        return $this->fetch('user/add');
    }
    public function addCode(){
        $nowTime = time();
        $coId = mt_rand(0,99999);
        $co = $this->codes();
        $code = $this->getCode($co);
        //var_dump($code);exit();
        $code['coId'] = $coId;
        /*$validate = $this->validate($code, 'Code');
        if (true !== $validate){
            return $this->error(" $validate ");
        }*/
        /**
         * 请求注册码接口
         */
        $operatetype = 'generatelapisregkey';
        $operatoruid = 'hhj';
        $operatorpwd = '4BCBBBC00B0341B4B413CFFC9EB02208';
        $companycode = '0';
        $mac = $code['mac'];
        $expirydate = $code['expireTime'];
        $requestid = $code['coId'];
        /*
         * operatetype=generatelapisregkey&operatoruid=hhj&operatorpwd=4BCBBBC00B0341B4B413CFFC9EB02208&companycode=0&mac=123456789562&expirydate=20170630&requestid=12354
         * */
        $getcode = new GetCode();
        $response = $getcode->getCode($operatetype, $operatoruid, $operatorpwd, $companycode, $mac, $expirydate, $requestid);
        set_time_limit(20);
        if(empty($response)){
            return $this->error('未连接，注册码申请失败');
        }
        //var_dump($response);exit();
        $regstring = substr($response, strrpos($response, '&') + 1);
        //var_dump($regstring);exit();
        $code['code'] = substr($regstring, strrpos($regstring, '=') + 1);
        //var_dump($code['code']);exit();
        if (strlen($code['code']) == 35){
            $result = Db::table($this->tableCode)->insert($code);
            if (!$result){
                return $this->error('申请失败，请重新申请');
            }
            session('coId', $requestid);
            session('cliId',$code['cliId']);
            return $this->success('申请成功', 'user/code');
        }
        return $this->error('未连接，注册码申请失败');

    }
    /*
   *查询修改注册码的信息
   */
    public function code(){
        $coId = session('coId');
        $tableClient = 'client';
        $field = 'coId,company,mac,creator,expireTime,createTime,code,other';
        $where = array('coId'=>$coId);
        //var_dump($coId);exit();
        $join = "$tableClient.' cli', 'cli.cliId=co.cliId'";
        $code = $this->codes()->joinSelect($join, $where, $field);
        //var_dump($code['0']);exit();
        $this->assign('code', $code['0']);
        return $this->fetch('user/code');
        session('coId', null);
        session('cliId',null);
        //echo json_encode($d);
    }
    /*
     * 查询即将失效注册码,失效日期在当前日期30以内
     * */
    public function soonExpire(){
        return $this->fetch('user/soonExpireCode');
    }
    public function soonExpireCode(){
        //只显示即将失效的注册码，已经失效的则不显示
        $soonTime = date('Ymd', strtotime('+1 month'));
        $expire = date('Ymd', strtotime('-1 minute'));
        //var_dump($expire);exit();
        $destination = 'user/soonExpireCode';
        $param = 'cliId';
        $html = 'soonExpireCode';
        $tableClient = 'client';
        $tableCode = 'code';
        //条件很重要！！！！！！！！！！！！！！！！！！！！！！！
        $where = array('expireTime'=>['between', [$expire, $soonTime]]);
        $field = 'coId,company,mac,creator,createTime,expireTime,code,other';
        //获取不重复的公司名
        $client = $this->clients()->selectDistinct('company,cliId', '');
        //var_dump($client);exit();
        $this->assign('client', $client);
        $search = $this->base()->search($tableCode, $tableClient, $param, $html, $field, $where, $destination);
        return $search;
    }
    public function expireCode(){
        //只显示即将失效的注册码，已经失效的则不显示
        $now = date('Ymd', time());
        $destination = 'user/expireCode';
        $param = 'cliId';
        $html = 'expireCode';
        $tableClient = 'client';
        $tableCode = 'code';
        //条件很重要！！！！！！！！！！！！！！！！！！！！！！！
        $where = array('expireTime'=>['between', ['0', $now]]);
        $field = 'coId,company,mac,creator,createTime,expireTime,code,other';
        //获取不重复的公司名
        $client = $this->clients()->selectDistinct('company,cliId', '');
        //var_dump($client);exit();
        $this->assign('client', $client);
        $search = $this->base()->search($tableCode, $tableClient, $param, $html, $field, $where, $destination);
        return $search;
    }

    public function getCode($co){
        //$co = $this->codes();
        $expire1 = input('param.expireTime');
        $expire2 = explode('-', $expire1);
        $expireTime = join('', $expire2);
        $creator = session('username');   //创建者即为用户
        $company = input('param.company');   //以公司名获取客户公司编号
        $other = input('param.other');
        $mac = input('param.mac');
        $where = array('company'=>$company);
        $cliId = $this->clients()->findById($where);
        //var_dump($cliId);exit();
        $co->setCliId($cliId['cliId']);
        $co->setCreator($creator);
        $co->setOther($other);
        $co->setMac($mac);
        $co->setExpireTime($expireTime);
        $code = array(
            'cliId'=> $co->getCliId(),
            'mac'=> $co->getMac(),
            'creator'=> $co->getCreator(),
            'expireTime'=>$co->getExpireTime(),
            'other'=>$co->getOther()
        );
        return $code;
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