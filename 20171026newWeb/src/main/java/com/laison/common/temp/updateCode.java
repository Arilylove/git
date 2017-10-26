package com.laison.common.temp;

import com.laison.common.cache.lock.RedisLock;
import com.laison.common.utils.JedisUtils;

public class updateCode implements Runnable{

		@Override
		public void run() {
			for(int i=0 ;i<10000;i++) {
	            	RedisLock lock = JedisUtils.getLock("laison_code_cache_2017081010");
	            	try {
	                    if(lock.lock()) {
	                    	String fromMapCache = JedisUtils.getFromMapCache("laison_code_cache", "2017081010");
	                    	if(fromMapCache==null) {
	                    		System.out.println("即将写入0");
	                    		JedisUtils.setToMapCache("laison_code_cache", "2017081010", 0+"");
	                    	}else {
	                    		System.out.println("即将写入"+(Long.parseLong(fromMapCache)+1)+"");
	                    		JedisUtils.setToMapCache("laison_code_cache", "2017081010", Long.parseLong(fromMapCache)+1+"");
	                    	}
	                        
	                    }
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }finally {
	                    
	                    lock.unlock();
	                }
	        }
			
		}
		
	} 