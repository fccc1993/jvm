package com.xfc.jvm.gc;

/**
 * VM Args:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * @author xfc
 *
 */
public class TestTenuringThreshold {
	private static final int ONE_MB = 1024*1024;
	
	@SuppressWarnings("unused")
	public static void testTenuringThreshold(){
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[ONE_MB / 4];
		//何时进入老年代取决于: -XX:MaxTenuringThreshold 设置
		allocation2 = new byte[4 * ONE_MB];
		allocation3 = new byte[4 * ONE_MB];
		allocation3 = null;
		allocation3 = new byte[4 * ONE_MB];
	}
	
	public static void main(String[] args) {
		TestTenuringThreshold testTenuringThreshold = new TestTenuringThreshold();
		testTenuringThreshold.testTenuringThreshold();
	}
}
