<?php
/**
 * Created by PhpStorm.
 * User: HXL
 * Date: 2017/5/8
 * Time: 15:37
 */
namespace app\index\controller;

use app\index\controller\Base;
use app\index\getcode\GetCode;
use app\index\model\Clients;
use app\index\model\Codes;
use app\index\model\States;
use think\Db;
use think\Request;
use app\index\common\Common;

class User extends Base{
    /*
     * 控制器判断
     * */
    public function isUser(){
        $controll = lcfirst( request()->controller() );//控制器名
        if ($controll != 'User'){
            return false;
        }
        return true;
    }

    /**
     * 使用类
     * */
    public function base(){
        $base = new Base();
        return $base;
    }
    public function clients(){
        $c = new Clients();
        return $c;
    }
    public function codes(){
        $co = new Codes();
        return $co;
    }
    public function state(){
        $st = new States();
        return $st;
    }

    /*
     * 客户列表 search($tableName1, $tableName2, $param, $html, $field, $destination)
     * */
    public function listClient(){
        $param = 'stId';
        $html = 'client';
        $where = '';
        $field = 'cliId,state,contacts,phone,company,email,app';
        //需要从国家列表中获取国家名称
        $states = $this->state()->select('stId,state', $where);
        $destination = 'user/listClient';
        $this->assign('states', $states);
        $tableClient = 'client';
        $tableStates = 'states';
        //当前国家$tableName1, $tableName2 = '', $param, $html, $field, $where, $destination
        $search = $this->base()->search($tableClient, $tableStates, $param, $html, $field, $where, $destination);
        //var_dump($search);
        return $search;
    }

    /*
     *查询修改客户的信息
     */
    public function client(){
        $cliId = input('param.cliId');
        $field = 'cliId,contacts,phone,company,email,app';
        $where = array('cliId'=>$cliId);
        $data = $this->clients()->select($field, $where);
        //var_dump($data);
        echo json_encode($data);
    }

    /*
     * 增加客户
     * */
    public function addClient(){
        //随机编号
        $cliId = mt_rand(1,999);
        $cli = $this->clients();
        $cli->setCliId($cliId);
        $client = $this->getClients($cli);
        $client['cliId'] = $cliId;
        //var_dump($client);exit();
        $where = array('cliId'=>$cliId);
        $findCliId = $cli->findById($where);
        if ($findCliId){
            return $this->error('该客户编号已存在');
        }
        /*$validate = $this->validate($client, 'Client');
        if (true !== $validate){
            return $this->error(" $validate ");
        }*/
        $result = $cli->add($client, '');
        if (!$result){
            return $this->error('添加失败');
        }
        return $this->success('添加成功', 'user/listClient');
    }
    /*
     * 删除客户
     * */
    public function deleteClient(){
        $cliId = input('param.cliId');
        $where = array('cliId'=>$cliId);
        $findCliId = $this->clients()->findById($where);
        if (!$findCliId){
            return $this->error('未找到该客户');
        }
        $delete = $this->clients()->del($where);
        if (!$delete){
            return $this->error('删除失败');
        }
        return $this->success('删除成功', 'user/listClient');

    }

    /*
     * 客户信息编辑
     * */
    public function editClient(){
        $cliId = input('param.cliId');
        $where = array('cliId'=>$cliId);
        $findCliId = $this->clients()->findById($where);
        if (!$findCliId){
            return $this->error('未找到该客户');
        }
        $client = $this->getClients($this->clients());
        //var_dump($client);exit();
        /*$validate = $this->validate($client, 'Client');
        if (true !== $validate){
            return $this->error(" $validate ");
        }*/
        $result = $this->clients()->update($client, $where);
        //echo Db::table($this->tableClient)->getLastSql();exit();
        if (!$result){
            return $this->error('修改失败，您未做任何修改');
        }
        return $this->success('修改成功', 'user/listClient');
    }

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
        $this->assign('condition', 'all');
        $search = $this->base()->search($tableCode, $tableClient, $param, $html, $field, $where, $destination);
        return $search;
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
        $destination = 'user/listCode';
        $param = 'cliId';
        $html = 'code';
        $tableClient = 'client';
        $tableCode = 'code';
        //条件很重要！！！！！！！！！！！！！！！！！！！！！！！
        $where = array('expireTime'=>['between', [$expire, $soonTime]]);
        $field = 'coId,company,mac,creator,createTime,expireTime,code,other';
        //获取不重复的公司名
        $client = $this->clients()->selectDistinct('company,cliId', '');
        //var_dump($client);exit();
        $this->assign('client', $client);
        $this->assign('condition', 'soonExpire');
        $search = $this->base()->search($tableCode, $tableClient, $param, $html, $field, $where, $destination);
        return $search;
    }

    /** 
     * 已经失效的注册码
     * @return mixed
     */
    public function expireCode(){
        //只显示即将失效的注册码，已经失效的则不显示
        $now = date('Ymd', time());
        $destination = 'user/listCode';
        $param = 'cliId';
        $html = 'code';
        $tableClient = 'client';
        $tableCode = 'code';
        //条件很重要！！！！！！！！！！！！！！！！！！！！！！！
        $where = array('expireTime'=>['between', ['0', $now]]);
        $field = 'coId,company,mac,creator,createTime,expireTime,code,other';
        //获取不重复的公司名
        $client = $this->clients()->selectDistinct('company,cliId', '');
        //var_dump($client);exit();
        $this->assign('client', $client);
        $this->assign('condition', 'expire');
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
            $result = $co->add($code, '');
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

    public function getClients($cli){
        //以国家名称获取国家编号
        $state = input('param.state');
        $where = array('state'=>$state);
        $stId = $this->state()->findById($where);
        $company = input('param.company');
        $contacts = input('param.contacts');
        $phone = input('param.phone');
        $email = input('param.email');
        $app = input('param.app');
        //$cli = $this->clients();
        $cli->setCompany($company);
        $cli->setContacts($contacts);
        $cli->setEmail($email);
        $cli->setApp($app);
        $cli->setPhone($phone);
        $cli->setStId($stId);
        $client = array(
            'stId'=>$cli->getStId(),
            'company'=> $cli->getCliId(),
            'contacts'=> $cli->getContacts(),
            'phone'=> $cli->getPhone(),
            'email'=> $cli->getEmail(),
            'app'=> $cli->getApp()
        );
        return $client;
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

}