package cn.timebusker.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class SessionController {
	
	@RequestMapping(value = "/admin")
    public Map<String, Object> firstResp (HttpSession httpSession){  
        Map<String, Object> map = new HashMap<>();  
//      map.put("account", httpSession.getAttribute("account"));
//      map.put("password", httpSession.getAttribute("password"));
        map.put("MAP", httpSession.getAttribute("map"));
        map.put("sessionId", httpSession.getId());
        map.put("AAA", "AAA");
        return map;
    }
}  