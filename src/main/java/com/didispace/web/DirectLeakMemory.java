package com.didispace.web;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author fw
 * 无full gc
 */
@RestController
public class DirectLeakMemory {
	private static long num=0;
	List<ByteBuffer> list = new ArrayList<>();
    @RequestMapping("/directLeakMemory")
    public String index() {
    	ByteBuffer directMem=ByteBuffer.allocateDirect(1024*50);
    	list.add(directMem);
    	num++;
        return "access count: "+num;
    }
}