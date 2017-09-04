package com.xfc.jvm.gc;

/**
 * 此代码演示两点:
 * 1. 对象可以在被 GC 时自我拯救
 * 2. 自救机会只有一次,因为一个对象的 finalize() 方法只会被系统调用一次
 * @author xfc
 *Console:
 *finalize method executed!
yes, i am still alive!
no, i am dead !
 */
public class TestFinalizeEscaperGC {
	
	public static TestFinalizeEscaperGC SAVE_HOOK = null;
	
	public void isAlive(){
		System.out.println("yes, i am still alive!");
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize method executed!");
		TestFinalizeEscaperGC.SAVE_HOOK = this;
	}
	
	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new TestFinalizeEscaperGC();
		
		//对象第一次成功拯救自己
		SAVE_HOOK = null;
		System.gc();
		//因为 Finalize()方法优先级很低, 所以暂停 0.5 秒等待
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no, i am dead !");
		}
		
		//对象第二次拯救失败
		SAVE_HOOK = null;
		System.gc();
		
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no, i am dead !");
		}
		
		
	}
	
	
}
