package com.didispace.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author fw
 * 无full gc
 */
@RestController
public class BigObjectLeakMemory {
	private static final int _1M=1024*1024;
	private static Map<Long,byte[]> map=new HashMap<>();
	private static long num=0;
    @RequestMapping("/bigObjectLeakMemory")
    public String index() {
    	map.put(num, new byte[_1M]);
    	num++;
        return "access count: "+num;
    }
}