<?php
/**
 * Created by PhpStorm.
 * User: HXL
 * Date: 2017/10/19
 * Time: 11:16
 */
namespace app\index\controller;

use app\index\controller\Base;
use app\index\getcode\GetCode;
use app\index\model\Clients;
use app\index\model\Codes;
use app\index\model\States;
use app\index\common\Common;

class Client extends Base{


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
}