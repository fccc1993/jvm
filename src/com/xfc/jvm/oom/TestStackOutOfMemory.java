package com.xfc.jvm.oom;

/**
 * VM Args:
 * -verbose:gc -Xss2M -XX:+PrintGCDetails
 * -XX:+HeapDumpOnOutOfMemoryError
 * @author xfc
 *
 */
public class TestStackOutOfMemory {
	private void dontStop(){
		while(true){
			
		}
	}
	
	public void stackLeapByThread(){
		while(true){
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) throws Throwable{
		TestStackOutOfMemory stackOutOfMemory = new TestStackOutOfMemory();
		stackOutOfMemory.stackLeapByThread();
	}
}
