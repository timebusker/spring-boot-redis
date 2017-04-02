package cn.timebusker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.timebusker.entity.DemoInfoToCache;
import cn.timebusker.service.TestDemoInfoCache;

@Service
public class TestDemoInfoCacheImpl implements TestDemoInfoCache {

	@Autowired
	private RedisTemplate<String, DemoInfoToCache> redisTemplate;
	
	@Override
	public DemoInfoToCache addOneDemoInfo(String strId) {
		Long id = Long.parseLong(strId);
		DemoInfoToCache demo = creatDemoInfo(id);
		redisTemplate.opsForValue().set(demo.getId().toString(), demo);
		return demo;
	}

	@Override
	public DemoInfoToCache getOneDemoInfo(String strId) {
		Long id = Long.parseLong(strId);
		DemoInfoToCache demo = redisTemplate.opsForValue().get(id);
		return demo;
	}

	@Override
	public DemoInfoToCache updateDemoInfo(String strId) {
		Long id = Long.parseLong(strId);
		DemoInfoToCache demo = creatDemoInfo(id);
		return demo;
	}

	@Override
	public DemoInfoToCache deleteDemoInfo(String strId) {
		Long id = Long.parseLong(strId);
		DemoInfoToCache demo = redisTemplate.opsForValue().get(id);
		redisTemplate.dump(strId);
		return demo;
	}
	
	private DemoInfoToCache creatDemoInfo(Long id) {
		DemoInfoToCache demo = new DemoInfoToCache();
		demo.setId(id);
		demo.setName("name");
		demo.setPwd("pwd");
		return demo;
	}

}
