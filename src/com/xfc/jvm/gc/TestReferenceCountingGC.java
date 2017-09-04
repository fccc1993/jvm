package com.xfc.jvm.gc;

/**
 * testGC()方法执行后, rc1和rc2是否被GC
 * @author xfc
 *
 */
public class TestReferenceCountingGC {
	public Object instance = null;
	private static final int ONE_MB = 1024 *1024;
	
	/**
	 * 该成员属性唯一意义是占内存, 以便能在GC日志中看清是否被回收过
	 */
	private byte[] bigSize = new byte[2 * ONE_MB];
	
	public static void testGC(){
		TestReferenceCountingGC objA = new TestReferenceCountingGC();
		TestReferenceCountingGC objB = new TestReferenceCountingGC();
		objA.instance = objA;
		objB.instance = objB;
		
		objA = null;
		objB = null;
		
		//假设在这行发生GC, rc1 和 rc2 是否被回收
		System.gc();
	}
	
	public static void main(String[] args) {
		TestReferenceCountingGC trc = new TestReferenceCountingGC();
		trc.testGC();
	}
}
