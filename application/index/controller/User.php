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
use app\index\validate\States;
use think\Db;
use think\Request;
use app\index\common\Common;

class User extends Base{
    protected $tableClient = 'client';
    protected $tableStates = 'states';
    protected $tableCode = 'code';
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
     * 客户列表 search($tableName1, $tableName2, $param, $html, $field, $destination)
     * */
    public function listClient(){
        $param = 'stId';
        $html = 'client';
        $where = '';
        $field = 'cliId,state,contacts,phone,company,email,app';
        //需要从国家列表中获取国家名称
        $states = $this->com()->select($this->tableStates, $where);
        $destination = 'user/listClient';
        $this->assign('states', $states);
        //当前国家$tableName1, $tableName2 = '', $param, $html, $field, $where, $destination
        $search = $this->base()->search($this->tableClient, $this->tableStates, $param, $html, $field, $where, $destination);
        //var_dump($search);
        return $search;
    }

    /*
     *查询修改客户的信息
     */
    public function client(){
        $cliId = input('param.cliId');
        $data = Db::table($this->tableClient)->where('cliId', $cliId)->select();
        echo json_encode($data);
    }

    /*
     * 增加客户
     * */
    public function addClient(){
        //以国家名称获取国家编号
        $state = input('param.state');
        //var_dump($state);exit();
        $field = 'stId';
        $where = array('state'=>$state);
        $stId = $this->com()->findParam($where, $this->tableStates);
        //echo $stId->getLastSql();exit();
        //var_dump($stId);exit();
        //查找当前数据库中最大的id
        $maxId = Db::table($this->tableClient)->field("cliId")->max("cliId");
        //var_dump($maxId);exit();
        $cliId = $maxId+1;
        //var_dump($cliId);exit();
        $company = input('param.company');
        $contacts = input('param.contacts');
        $phone = input('param.phone');
        $email = input('param.email');
        $app = input('param.app');
        $client = array(
            'cliId'=> $cliId,
            'stId'=> $stId['stId'],
            'company'=> $company,
            'contacts'=> $contacts,
            'phone'=> $phone,
            'email'=> $email,
            'app'=> $app
        );
        //var_dump($client);exit();
        $cliId = $this->com()->find('cliId', array('cliId'=>$cliId), $this->tableClient);
        if (!$cliId){
            return $this->error('该客户编号已存在');
        }
        $validate = $this->validate($client, 'Client');
        if (true !== $validate){
            //return $this->error(" $validate ", $_SERVER['HTTP_REFERER']);
            return $this->error(" $validate ");
        }
        $result = $this->com()->add($client, $this->tableClient);
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
        //var_dump($cliId);exit();
        $find = $this->com()->find('cliId', array('cliId'=>$cliId), $this->tableClient);
        if ($find){
            return $this->error('未找到该客户');
        }
        $delete = $this->com()->delete($this->tableClient, array('cliId'=>$cliId));
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
        $find = $this->com()->find('cliId', array('cliId'=>$cliId), $this->tableClient);
        if ($find){
            return $this->error('未找到该客户');
        }
        $state = input('param.state');
        $stId = $this->com()->findParam(array('state'=>$state), $this->tableStates);
        //var_dump($stId);exit();
        $company = input('param.company');
        $contacts = input('param.contacts');
        $phone = input('param.phone');
        $email = input('param.email');
        $app = input('param.app');
        $client = array(
            'stId' => $stId['stId'],
            'company' => $company,
            'contacts' => $contacts,
            'phone' => $phone,
            'email' => $email,
            'app' => $app
        );
        //var_dump($client);exit();
        $validate = $this->validate($client, 'Client');
        if (true !== $validate){
            return $this->error(" $validate ");
        }
        $result = Db::table($this->tableClient)->where('cliId', $cliId)->update($client);
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
    public function add(){
        $client = Db::table($this->tableClient)->field('company')->distinct(true)->select();
        //var_dump($client);exit();
        $this->assign('client', $client);
        return $this->fetch('user/add');
    }
    public function addCode(){
        $expire1 = input('param.expireTime');
        $expire2 = explode('-', $expire1);
        $expireTime = join('', $expire2);
        //var_dump($expireTime);exit();
        $nowTime = time();
        $coId = mt_rand(0,99999);
        $creator = session('username');   //创建者即为用户
        $company = input('param.company');   //以公司名获取客户公司编号
        $other = input('param.other');
        $cliId = Db::table($this->tableClient)->field('cliId')->where('company', $company)->find();
        //var_dump($cliId);exit();
        $code = array(
            'coId'=> $coId,
            'cliId'=> $cliId['cliId'],
            'mac'=> input('param.mac'),
            'creator'=> $creator,
            'createTime'=> date('Y-m-d H:i:s', $nowTime),
            //'expireTime'=> date('Ymd', strtotime('+1 year'))   //有效期一年
            'expireTime'=>$expireTime,     //申请注册码的人填写
            'other'=>$other
        );
        //var_dump($code);exit();
        $validate = $this->validate($code, 'Code');
        if (true !== $validate){
            return $this->error(" $validate ");
        }
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
        //var_dump($response);exit();
        $regstring = substr($response, strrpos($response, '&') + 1);
        //var_dump($regstring);exit();
        $code['code'] = substr($regstring, strrpos($regstring, '=') + 1);
        //var_dump($code['code']);exit();
        if ($code['code']){
            $result = Db::table($this->tableCode)->insert($code);
            if (!$result){
                //return $this->error('申请失败，请重新申请', $_SERVER['HTTP_REFERER']);
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
        //var_dump($coId);exit();
        $code = Db::table($this->tableCode)->alias('co')->join($this->tableClient.' cli', 'cli.cliId=co.cliId')
            ->where('coId', $coId)->field('coId,company,mac,creator,expireTime,createTime,code,other')->select();
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
        /*$code = Db::table($this->tableCode)
            ->alias('co')->join($this->tableClient.' cli', 'co.cliId=cli.cliId')
            ->where('expireTime', '>', $expire)->where('expireTime', '<', $soonTime)->select();*/
        //var_dump($code);exit();
        $destination = 'user/soonExpireCode';
        $param = 'cliId';
        $html = 'expireCode';
        //条件很重要！！！！！！！！！！！！！！！！！！！！！！！
        $where = array('expireTime'=>['between', [$expire, $soonTime]]);
        $field = 'coId,company,mac,creator,createTime,expireTime,code,other';
        //获取不重复的公司名
        $client = Db::table($this->tableClient)->field('company,cliId')->distinct(true)->select();
        //var_dump($client);exit();
        $this->assign('client', $client);
        $search = $this->base()->search($this->tableCode, $this->tableClient, $param, $html, $field, $where, $destination);
        return $search;
    }

    
    /*
     * 添加国家
     * */
    public function addStates(){
        $stId = input('param.stId');
        $state = input('param.state');
        $states = array(
            'stId'=> $stId,
            'state'=> $state
        );
        if (empty($stId) || empty($state)){
            return $this->error('信息不能为空');
        }
        $validate = $this->validate($states, 'States');
        //var_dump($validate);exit();
        if (true !== $validate){
            return $this->error(" $validate ");
        }
        $stId = $this->com()->find('stId', array('stId'=>$stId), $this->tableStates);
        $state = $this->com()->find('state', array('state'=>$state), $this->tableStates);
        if (!$stId){
            return $this->error('国家代码已存在');
        }
        if (!$state){
            return $this->error('国家名称已存在');
        }
        $result = Db::table($this->tableStates)->insert($states);
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
        $search = $this->base()->search($this->tableStates, '', $param, $html, $field, $where, $destination);
        return $search;
    }
    /*
     *查询修改国家的信息
     */
    public function states(){
        $stId = input('stId/s');
        $data = Db::table($this->tableStates)->where('stId', $stId)->select();
        echo json_encode($data);
    }
    /*
     * 国家信息修改
     * */
    public function editStates(){
        $stId = input('stId/s');
        //var_dump($stId);exit();
        $find = $this->com()->find('stId', array('stId'=>$stId), $this->tableStates);
        if ($find){
            return $this->error('未找到该国家信息');
        }
        $state = input('param.state');
        $states = array(
            'stId'=> $stId,
            'state'=> $state
        );
        //var_dump($states);exit();
        $result = Db::table($this->tableStates)->where('stId', $stId)->update($states);
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
        $find = $this->com()->find('stId', array('stId'=>$stId), $this->tableStates);
        if ($find){
            return $this->error('未找到该国家');
        }
        $delete = $this->com()->delete($this->tableStates, array('stId'=>$stId));
        if (!$delete){
            return $this->error('删除失败');
        }
        return $this->success('删除成功', 'user/listStates');
    }

}