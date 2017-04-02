package cn.timebusker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * 本类的主要作用是引用@EnableRedisHttpSession，并在类中作增强配置，简单使用中，只需要将@EnableRedisHttpSession 注解到主类上即可
 * 
 * 注解 EnableRedisHttpSession 创建了一个名为springSessionRepositoryFilter的Spring Bean，
 * 该Bean实现了Filter接口。该filter负责通过 Spring Session 替换HttpSession从哪里返回。这里Spring Session是通过 redis 返回
 *
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 100)
@Configuration
public class RedisHttpSessionConfig {

	/**
	 * 推荐使用：
	 * 用来定义Spring Session的 HttpSession 集成使用HTTP的头来取代使用 cookie 传送当前session信息
	 * @return
	 */
	@Bean  
    public HttpSessionStrategy headerHttpSessionStrategy() {  
        return new HeaderHttpSessionStrategy();  
    }  
	
	/**
	 * 用来定义Spring Session的 HttpSession 集成使用 cookie 传送当前session信息
	 * @return
	 */
	//@Bean  
	public HttpSessionStrategy cookieHttpSessionStrategy() {  
	    return new CookieHttpSessionStrategy();  
	} 
}
