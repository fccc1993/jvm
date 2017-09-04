package com.xfc.jvm.classloading;


class SuperClass {
	static {
		System.out.println("SuperClass init!");
	}
	
	public static int value = 123;
}

class SubClass extends SuperClass {
	static {
		System.out.println("SubClass init!");
	}
}

/**
 * 通过子类引用父类的静态字段, 不会导致子类初始化
 * 
 * 输出:
 * SuperClass init!
 * 123
 * @author xfc
 *
 */
//public class NotInitialization {
//	public static void main(String[] args) {
//		System.out.println(SubClass.value);
//	}
//}

/**
 * 通过数组定义来引用类, 不会触发此类的初始化
 * 
 * 无输出
 * @author xfc
 *
 */
//public class NotInitialization {
//	public static void main(String[] args) {
//		SuperClass[] superClass = new SuperClass[10]; 
//	}
//}



//----------------------------------------------------------------------------------------

class ConstClass {
	static {
		System.out.println("ConstClass init!");
	}
	
	public static final String HELLOWORLD = "hello world!";
}

/**
 * 常量在编译阶段会存入调用类的常量池中, 本质上没有直接引用到定义常量的类, 不会触发定义常量的类的初始化
 * 
 * 输出:
 * hello world!
 * @author xfc
 *
 */
public class NotInitialization {
	public static void main(String[] args) {
		System.out.println(ConstClass.HELLOWORLD); 
	}
}


