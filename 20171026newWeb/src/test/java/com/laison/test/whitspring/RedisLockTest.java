package com.laison.test.whitspring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.laison.common.cache.JedisCacheManager;
import com.laison.common.cache.JedisCacheManager.JedisCache;
import com.laison.common.cache.lock.RedisLock;
import com.laison.common.utils.JedisUtils;
import com.laison.common.utils.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration({ "classpath:/spring/app*.xml" }) // 加载配置文件
// @ContextConfiguration({"classpath:/spring/applicationContext-jedis.xml"})
// //加载配置文件
public class RedisLockTest {
	
	@Before
	public void spring() {
		
	}

	@Test
	public void test() {
		Thread thread1 = new Thread(new updateCode());
		thread1.start();
		Thread thread2 = new Thread(new updateCode());
		thread2.start();

	}

	
}
