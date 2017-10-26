package com.laison.service;

public interface CodeRecordService {

	/**
	 * 
	* @Title: getCode 
	* @Description: 获取当前code值 不保证线程同步 ，需要在调用的地方自行上锁
	* @param @param codeType
	* @param @return   
	* @return long
	 */
	long getCode(int codeType);

	/**
	 * 
	* @Title: updateCode 
	* @Description:   更新code 不保证线程同步 ，需要在调用的地方自行上锁
	* @param @param codeType   
	* @return void
	 */
	void updateCode(int codeType);
	

}
