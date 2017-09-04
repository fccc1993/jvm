package com.xfc.jvm.oom;

/**
 * VM Args:
 * -verbose:gc -Xss128k -XX:+PrintGCDetails
 * -XX:+HeapDumpOnOutOfMemoryError
 * @author xfc
 *
 *Console:
 *stack length:982
 *Exception in thread "main" java.lang.StackOverflowError
	at com.xfc.jvm.TestStackOverFlow.stackLeak(TestStackOverFlow.java:17)
	at com.xfc.jvm.TestStackOverFlow.stackLeak(TestStackOverFlow.java:18)
	
 */
public class TestStackOverFlow {
	private int stackLength = 1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable {
		
		TestStackOverFlow stackOverFlow = new TestStackOverFlow();
		
		try{
			stackOverFlow.stackLeak();
			
		}catch(Throwable e){
			System.out.println("stack length:" + stackOverFlow.stackLength);
			throw e;
		}
	}
}
