package com.xfc.jvm.gc;

/**
 * VM Args:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:-HandlePromotionFailure
 * @author xfc
 *
 */
public class TestHandlePromotion {
	private static final int ONE_MB = 1024*1024;
	
	public static void testHandlePromotion(){
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
		
		allocation1 = new byte[2 * ONE_MB];
		allocation2 = new byte[2 * ONE_MB];
		allocation3 = new byte[2 * ONE_MB];
		allocation1 = null;
		
		allocation4 = new byte[2 * ONE_MB];
		allocation5 = new byte[2 * ONE_MB];
		allocation6 = new byte[2 * ONE_MB];
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		
		allocation7 = new byte[2 * ONE_MB];
	}
	
	public static void main(String[] args) {
		TestHandlePromotion testHandlePromotion = new TestHandlePromotion();
		testHandlePromotion.testHandlePromotion();
	}
}
