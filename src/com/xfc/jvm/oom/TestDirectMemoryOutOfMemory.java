package com.xfc.jvm.oom;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

import sun.misc.Unsafe;

/**
 * VM Args:
 * -verbose:gc -Xms20M -XX:MaxDirectMemorySize=10M -XX:+PrintGCDetails
 * @author xfc
 *
 *Console:
 */
public class TestDirectMemoryOutOfMemory {
	private static final int ONE_MB = 1024*1024;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe)unsafeField.get(null);
		while(true){
			unsafe.allocateMemory(ONE_MB);
		}
	}
	
}
