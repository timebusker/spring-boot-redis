package cn.timebusker.service;

import cn.timebusker.entity.DemoInfoToCache;

public interface DemoInfoService {

	DemoInfoToCache findDemoInfoById(Long id);

	DemoInfoToCache updateDemoInfoById(DemoInfoToCache demoInfo);

	DemoInfoToCache addDemoInfoById(DemoInfoToCache demoInfo);
	
	void deleteDemoInfoById(Long id);
}
