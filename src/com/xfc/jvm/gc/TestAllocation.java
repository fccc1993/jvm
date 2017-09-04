package com.xfc.jvm.gc;

/**
 * VM Args:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author xfc
 *
 */
public class TestAllocation {
	private static final int ONE_MB = 1024*1024;
	
	public static void testAllocation(){
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * ONE_MB];
		allocation2 = new byte[2 * ONE_MB];
		allocation3 = new byte[2 * ONE_MB];
		//出现一次Minor GC
		allocation4 = new byte[4 * ONE_MB];
		
	}
	
	public static void main(String[] args) {
		TestAllocation allocation = new TestAllocation();
		allocation.testAllocation();
	}
}
