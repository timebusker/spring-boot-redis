package cn.timebusker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.timebusker.entity.DemoInfoToCache;
import cn.timebusker.service.TestDemoInfoCache;

@Controller
@RequestMapping("/cache")
public class CacheController {

	@Autowired
	TestDemoInfoCache cacheService;

	@RequestMapping("/add/{id}")
	public @ResponseBody DemoInfoToCache addOne(@PathVariable String id) {
		DemoInfoToCache demo = null;
		demo = cacheService.addOneDemoInfo(id);
		return demo;
	}

	@RequestMapping("/get/{id}")
	public @ResponseBody DemoInfoToCache getOne(@PathVariable String id) {
		DemoInfoToCache demo = null;
		demo = cacheService.getOneDemoInfo(id);
		return demo;
	}

	@RequestMapping("/update/{id}")
	public @ResponseBody DemoInfoToCache updateOne(@PathVariable String id) {
		DemoInfoToCache demo = null;
		demo = cacheService.addOneDemoInfo(id);
		return demo;
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody DemoInfoToCache deleteOne(@PathVariable String id) {
		DemoInfoToCache demo = null;
		demo = cacheService.deleteDemoInfo(id);
		return demo;
	}

	@RequestMapping("/")
	public void getAll() {
	}
}
