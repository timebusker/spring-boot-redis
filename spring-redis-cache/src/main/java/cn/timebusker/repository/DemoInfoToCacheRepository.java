package cn.timebusker.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.timebusker.entity.DemoInfoToCache;

public interface DemoInfoToCacheRepository  extends JpaRepository<DemoInfoToCache,Long> {
	
	/**
	 * 要缓存的 Java 对象必须实现 Serializable 接口，因为 Spring 会将对象先序列化再存入 Redis
	 * 
	 * 不实现 Serializable 的话将会遇到类似这种错误：nested exception is java.lang.IllegalArgumentException
	 */
	
	/**
	 * @Cacheable
	 * 
	 * value：缓存位置名称，不能为空，如果使用EHCache，就是ehcache.xml中声明的cache的name  
	 * 
	 * key：缓存的key，默认为空，既表示使用方法的参数类型及参数值作为key，支持SpEL,
	 * 定义缓存的key值的方式就很重要，最好是能够唯一，因为这样可以准确的清除掉特定的缓存，而不会影响到其它缓存值
	 * 
	 * condition：触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL
	 */
	@Cacheable(value="cacheInfo")
	DemoInfoToCache findById(Long id);
    
    
    /**
     * @CachePut
     * 
     * 注释可以确保方法被执行，同时方法的返回值也被录到缓存中，实现缓存与数据库的同步更新spEl表达式
     * 
     * @CachePut(value="cacheInfo",key="'cn.timebusker.repositoryDemoInfoToCacheRepository'+#demoInfo.id")
     */
	@SuppressWarnings("unchecked")
	@CachePut(value="cacheInfo",key="'cn.timebusker.repositoryDemoInfoToCacheRepository'+#p0.id")
	DemoInfoToCache saveAndFlush(DemoInfoToCache demoInfo);
	
    /**
     * @CacheEvict 支持如下几个参数：
     * 
     * value：缓存位置名称，不能为空，同上
     * 
     * key：缓存的key，默认为空，同上 
     * 
     * condition：触发条件，只有满足条件的情况才会清除缓存，默认为空，支持SpEL
     * 
     * allEntries：true表示清除value中的全部缓存，默认为false
     * 
     */
    @CacheEvict(value="cacheInfo")
	void delete(Long id);
}
