package com.didispace.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fw
 * 单例模式使用不当引发的full gc
 */
@RestController
@Scope("prototype")
public class SingleInstanceLeakMemory {
	private static final int _50K=1024*50;
	private static Map<Long,byte[]> map=new HashMap<>();
	private static long num=0;
    @RequestMapping("/singleInstanceLeakMemory")
    public String index() {
    	map.put(num, new byte[_50K]);
    	num++;
        return "access count: "+num;
    }
}