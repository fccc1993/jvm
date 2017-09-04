package com.xfc.jvm.gc;

/**
 * VM Args:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=15 -XX:PrintTenuringDistribution
 * @author xfc
 *
 */
public class TestTenuringThreshold2 {
	private static final int ONE_MB = 1024*1024;
	
	public static void testTenuringThreshold2(){
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[ONE_MB / 4];
		//allocation1 + allocation2 大于survivor 空间一半
		allocation2 = new byte[ONE_MB / 4];
		allocation3 = new byte[4 * ONE_MB];
		allocation4 = new byte[4 * ONE_MB];
		allocation4 = null;
		allocation4 = new byte[4 * ONE_MB];
	}
	
	public static void main(String[] args) {
		TestTenuringThreshold2 testTenuringThreshold2 = new TestTenuringThreshold2();
		testTenuringThreshold2.testTenuringThreshold2();
	}
}
