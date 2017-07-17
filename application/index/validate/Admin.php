<?php
/**
 * Created by PhpStorm.
 * User: HXL
 * Date: 2017/5/8
 * Time: 17:22
 */
namespace app\index\validate;

use think\Validate;

class Admin extends Validate{
    protected $rule = array(
        'username'=>'require|unique:admin',
        'username'=>'length:6,20',
        'adId'=>'require'
    );
    protected $message = array(
        'username.require'=>'用户名要求',
        'username.length'=>'用户名长度在6-20位之间',
        'username.unique'=>'用户名已存在',
        'adId.require'=>'用户编号要求'/*,
        'adId.unique'=>'用户编号已存在'*/
    );
}