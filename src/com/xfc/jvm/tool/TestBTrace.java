package com.xfc.jvm.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBTrace {
	public int add(int a, int b){
		return a + b;
	}
	
	public static void main(String[] args) throws IOException {
		TestBTrace testBTrace = new TestBTrace();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			reader.readLine();
			int a = (int) Math.round(Math.random() * 1000);
			int b = (int) Math.round(Math.random() * 1000);
			System.out.println(testBTrace.add(a, b));
		}
	}
}
