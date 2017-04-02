package cn.timebusker.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.timebusker.entity.DemoInfoToCache;
import cn.timebusker.repository.DemoInfoToCacheRepository;
import cn.timebusker.service.DemoInfoService;

@Service
public class DemoInfoServiceImpl implements DemoInfoService {
	
	@Resource
	private DemoInfoToCacheRepository demoInfoToCacheRepository;

	
	@Override
	public DemoInfoToCache findDemoInfoById(Long id) {
		DemoInfoToCache ditc = null;
		System.out.println("查询的数据是---"+demoInfoToCacheRepository.findById(id));
		System.out.println("查询的数据是---"+JSON.toJSONString(demoInfoToCacheRepository.findById(id)));
		ditc = demoInfoToCacheRepository.findById(id);
		return ditc;
	}

    
	@Override
	public DemoInfoToCache updateDemoInfoById(DemoInfoToCache demoInfo) {
		return demoInfoToCacheRepository.saveAndFlush(demoInfo);
	}
	
	
	@Override
	public DemoInfoToCache addDemoInfoById(DemoInfoToCache demoInfo) {
		return demoInfoToCacheRepository.saveAndFlush(demoInfo);
	}

	
	@Override
	public void deleteDemoInfoById(Long id) {
		demoInfoToCacheRepository.delete(id);
	}

}
