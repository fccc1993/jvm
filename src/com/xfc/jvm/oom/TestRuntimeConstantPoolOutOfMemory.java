package com.xfc.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:
 * -verbose:gc -XX:PermSize=10M -XX:MaxPermSize=10M -XX:+PrintGCDetails
 * 
 * Console:
 * @author xfc
 *
 */
public class TestRuntimeConstantPoolOutOfMemory {
	public static void main(String[] args) {
		//使用List保持着常量池引用,避免FullGC回收常量池行为
		List<String> list = new ArrayList<String>();
		
		//10MB的PermSize在integer范围内足够产生OOM
		int i = 0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
		 
	}
}
