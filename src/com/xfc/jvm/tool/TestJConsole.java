package com.xfc.jvm.tool;


import java.util.ArrayList;
import java.util.List;

public class TestJConsole {
	/**
	 * 内存占位符对象, 一个 OOM 大约占 64kb
	 * @author xfc
	 *
	 */
	static class OOM{
		public byte[] placeholder = new byte[64 * 1024];
	}
	
	public static void fillHeap(int num) throws InterruptedException{
		List<OOM> list = new ArrayList<OOM>();
		for (int i = 0; i < num; i++) {
			Thread.sleep(50);
			list.add(new OOM());
		}
		System.gc();
	}
	
	public static void main(String[] args) throws InterruptedException {
		fillHeap(1000);
	}
	
	
	
	
}
