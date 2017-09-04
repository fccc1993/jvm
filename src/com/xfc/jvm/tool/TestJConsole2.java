package com.xfc.jvm.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestJConsole2 {
	/**
	 * 线程死循环演示
	 * @param args
	 * @throws InterruptedException
	 */
	public static void createBusyThread(){
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
					;
			}
			
		},"testBusyThread");
		thread.start();
	}
	
	/**
	 * 线程锁等待演示
	 * @param args
	 * @throws InterruptedException
	 */
	public static void createLockThread(final Object lock){
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			
		},"testLockThread");
		thread.start();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		buffer.readLine();
		createBusyThread();
		buffer.readLine();
		Object lock = new Object();
		createLockThread(lock);
	}
	
	
}
