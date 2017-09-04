package com.xfc.jvm.classloading;

/**
 * 正确答案:
 * static Super
 * static Sub
 * I'm SuperClass
 * Super
 * I'm SubClass
 * Sub
 * 
 * 类初始化过程如下:
 * 1.先顺序执行父类的static初始化代码块,再执行子类的static初始化代码块;
 * 2.先顺序执行父类的非static初始化代码块,再执行子类的非static初始化代码块;
 * 3.先执行父类的构造函数,在执行子类的构造函数.
 * @author xfc
 *
 */
class Super {
	public Super(){
		System.out.println("Super");
	}
	{
		System.out.println("I'm SuperClass");
	}
	static{
		System.out.println("static Super");
	}
}

class Sub extends Super{
	public Sub(){
		System.out.println("Sub");
	}
	{
		System.out.println("I'm SubClass");
	}
	static{
		System.out.println("static Sub");
	}
	public static void main(String[] args) {
		new Sub();
	}
}
