package cn.timebusker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.timebusker.entity.DemoInfoToCache;
import cn.timebusker.service.DemoInfoService;

@Controller
public class DemoInfoController {

	@Autowired
	DemoInfoService demoInfoService;

	@RequestMapping("/add/{id}")
	public @ResponseBody DemoInfoToCache addOne(@PathVariable Long id) {
		DemoInfoToCache demo = new DemoInfoToCache();
		demo.setId(id);
		demo.setName("N--" + System.currentTimeMillis());
		demo.setPwd("P--" + System.currentTimeMillis());
		try {
			demoInfoService.addDemoInfoById(demo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return demo;
	}

	@RequestMapping("/get/{id}")
	public @ResponseBody DemoInfoToCache getOne(@PathVariable Long id) {
		DemoInfoToCache demo = null;
		try {
			demo = demoInfoService.findDemoInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return demo;
	}

	@RequestMapping("/update/{id}")
	public @ResponseBody DemoInfoToCache updateOne(@PathVariable Long id) {
		DemoInfoToCache demo = null;
		try {
			demo = demoInfoService.findDemoInfoById(id);
			demo.setName(demo.getName() + "U");
			demo.setPwd(demo.getPwd() + "u");
			demoInfoService.updateDemoInfoById(demo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return demo;
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody Long deleteOne(@PathVariable Long id) {
		try {
			demoInfoService.deleteDemoInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@RequestMapping("/")
	public void getAll() {
	}
}
