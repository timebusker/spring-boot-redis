package cn.timebusker.service;

import cn.timebusker.entity.DemoInfoToCache;

public interface TestDemoInfoCache {

	DemoInfoToCache addOneDemoInfo(String strId);
	
	DemoInfoToCache getOneDemoInfo(String strId);
	
	DemoInfoToCache updateDemoInfo(String strId);
	
	DemoInfoToCache deleteDemoInfo(String strId);
}
