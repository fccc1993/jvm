package com.xfc.jvm.gc;

/**
 * VM Args:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728
 * @author xfc
 *
 */
public class TestPretenureSizeThreshold {
private static final int ONE_MB = 1024*1024;
	
	public static void testPretenureSizeThreshold(){
		
		byte[] allocation;
		allocation = new byte[4 * ONE_MB];
		
	}
	
	public static void main(String[] args) {
		TestPretenureSizeThreshold pretenureSizeThreshold = new TestPretenureSizeThreshold();
		pretenureSizeThreshold.testPretenureSizeThreshold();
	}
}
