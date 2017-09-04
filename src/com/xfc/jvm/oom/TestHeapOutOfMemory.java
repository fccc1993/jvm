package com.xfc.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:
 * -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 * 
 * Console:Instance:810325
 * java.lang.OutOfMemoryError: Java heap space
 * Dumping heap to java_pid14732.hprof ...
 * Heap dump file created [27981217 bytes in 0.235 secs]
 * 
 * 
 * @author xfc
 *
 */
public class TestHeapOutOfMemory {
	public static void main(String[] args) {
		
		List<HeapOOM> list = new ArrayList<HeapOOM>();
		
		int counter = 0;
		
		while(true){
			list.add(new HeapOOM());
			System.out.println("Instance:" + (++counter));
		}
	}
}

class HeapOOM{
	
}