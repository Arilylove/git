package com.laison.common.cache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import redis.clients.jedis.Jedis;

import com.google.common.collect.Sets;
import com.laison.common.utils.HttpUtils;
import com.laison.common.utils.JedisUtils;
import com.laison.common.utils.JsonUtils;


/**
 * 
* @ClassName: JedisCacheManager 
* @Description:  缓存管理 使用时 new一个对象 给cacheKeyPrefix赋值
* @author lihua
* @date 2017年9月22日 上午10:12:51 
*
 */
public class JedisCacheManager implements CacheManager {
	/**
	 * 根据名字判断这个JedisCacheManager实例是管理那个类型的cache  如"laison_shiro_cache_"代表是用来管理shiro的cache
	 */
	private String cacheKeyPrefix ;
	
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return new JedisCache<K, V>(cacheKeyPrefix + name);
	}

	public String getCacheKeyPrefix() {
		return cacheKeyPrefix;
	}

	public void setCacheKeyPrefix(String cacheKeyPrefix) {
		this.cacheKeyPrefix = cacheKeyPrefix;
	}
	
	/**
	 * 
	* @ClassName: JedisCache 
	* @Description: JedisCache<K, V> 成员变量string cacheKeyName
	* 提供get(K key)、put(K key, V value) remove(K key) clear() size()等方法
	* @author lihua
	* @date 2017年9月15日 上午11:20:43 
	* 
	* @param <K>
	* @param <V>
	 */
	public class JedisCache<K, V> implements Cache<K, V> {

		private Logger logger = LoggerFactory.getLogger(getClass());

		private String cacheKeyName = null;

		public JedisCache(String cacheKeyName) {
			this.cacheKeyName = cacheKeyName;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public V get(K key) throws CacheException {
			if (key == null){
				return null;
			}
			
			V v = null;
			HttpServletRequest request = HttpUtils.getRequest();
			if (request != null){
				v = (V)request.getAttribute(cacheKeyName);
				if (v != null){
					return v;
				}
			}
			
			V value = null;
			Jedis jedis = null;
			try {
				jedis = JedisUtils.getResource();
				value = (V)JedisUtils.toObject(jedis.hget(JedisUtils.getBytesKey(cacheKeyName), JedisUtils.getBytesKey(key)));
				
			} catch (Exception e) {
				logger.error("get {} {} {}", cacheKeyName, key, request != null ? request.getRequestURI() : "", e);
			} finally {
				JedisUtils.returnResource(jedis);
			}
			
			if (request != null && value != null){
				request.setAttribute(cacheKeyName, value);
			}
			
			return value;
		}

		@Override
		public V put(K key, V value) throws CacheException {
			if (key == null){
				return null;
			}
			
			Jedis jedis = null;
			try {
				jedis = JedisUtils.getResource();
				jedis.hset(JedisUtils.getBytesKey(cacheKeyName), JedisUtils.getBytesKey(key), JedisUtils.toBytes(value)); //二进制
				logger.debug("put {} {} = {}", cacheKeyName, key, value);
			} catch (Exception e) {
				logger.error("put {} {}", cacheKeyName, key, e);
			} finally {
				JedisUtils.returnResource(jedis);
			}
			return value;
		}

		@SuppressWarnings("unchecked")
		@Override
		public V remove(K key) throws CacheException {
			V value = null;
			Jedis jedis = null;
			try {
				jedis = JedisUtils.getResource();
				value = (V)JedisUtils.toObject(jedis.hget(JedisUtils.getBytesKey(cacheKeyName), JedisUtils.getBytesKey(key)));
				Long hdel = jedis.hdel(JedisUtils.getBytesKey(cacheKeyName), JedisUtils.getBytesKey(key));
				//logger.debug("remove {} {}", cacheKeyName, key);
				//logger.debug("成功删除{} 个", hdel);
			} catch (Exception e) {
				e.printStackTrace();
				//logger.warn("remove {} {}", cacheKeyName, key, e);
			} finally {
				JedisUtils.returnResource(jedis);
			}
			return value;
		}

		@Override
		public void clear() throws CacheException {
			Jedis jedis = null;
			try {
				jedis = JedisUtils.getResource();
				jedis.hdel(JedisUtils.getBytesKey(cacheKeyName));
				logger.debug("clear {}", cacheKeyName);
			} catch (Exception e) {
				logger.error("clear {}", cacheKeyName, e);
			} finally {
				JedisUtils.returnResource(jedis);
			}
		}

		@Override
		public int size() {
			int size = 0;
			Jedis jedis = null;
			try {
				jedis = JedisUtils.getResource();
				size = jedis.hlen(JedisUtils.getBytesKey(cacheKeyName)).intValue();
				logger.debug("size {} {} ", cacheKeyName, size);
				return size;
			} catch (Exception e) {
				logger.error("clear {}",  cacheKeyName, e);
			} finally {
				JedisUtils.returnResource(jedis);
			}
			return size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<K> keys() {
			Set<K> keys = Sets.newHashSet();
			Jedis jedis = null;
			try {
				jedis = JedisUtils.getResource();
				Set<String> hkeys = jedis.hkeys(cacheKeyName);
				Set<byte[]> set = jedis.hkeys(JedisUtils.getBytesKey(cacheKeyName));
				for(byte[] key : set){
					Object obj = (K)JedisUtils.getObjectKey(key);
					if (obj != null){
						keys.add((K) obj);
					}
	        	}
				//logger.debug("keys {} {} ", cacheKeyName, keys);
				return keys;
			} catch (Exception e) {
				//logger.error("keys {}", cacheKeyName, e);
			} finally {
				JedisUtils.returnResource(jedis);
			}
			return keys;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<V> values() {
			Collection<V> vals = new ArrayList<V>();
			Jedis jedis = null;
			try {
				jedis = JedisUtils.getResource();
				List<byte[]> col = jedis.hvals(JedisUtils.getBytesKey(cacheKeyName));
				Iterator<V> iterator = vals.iterator();
				for(byte[] val : col){
					Object obj = JedisUtils.toObject(val);
					if (obj != null){
						vals.add((V) obj);
					}
	        	}
				logger.debug("values {} {} ", cacheKeyName, vals);
				return vals;
			} catch (Exception e) {
				logger.error("values {}",  cacheKeyName, e);
			} finally {
				JedisUtils.returnResource(jedis);
			}
			return vals;
		}
	}
}
