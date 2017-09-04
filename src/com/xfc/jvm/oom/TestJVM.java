package com.xfc.jvm.oom;

public class TestJVM {
	//main方法放在方法区(Method Area)中
	public static void main(String[] args) {
		
		Student student = new Student("DT_SPARK");
		
		student.sayHello();
	}
}
class Student{
	private String name;
	
	public Student(String name){
		this.name = name;
	}
	
	public void sayHello(){
		System.out.println("Hello," + name);
	}
}