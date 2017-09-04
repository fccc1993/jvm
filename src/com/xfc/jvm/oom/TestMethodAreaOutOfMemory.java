package com.xfc.jvm.oom;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM Args:
 * -XX:PermSize=10M -XX:MaxPermSize=10M -verbose:gc -XX:+PrintGCDetails
 * @author xfc
 *
 */
public class TestMethodAreaOutOfMemory {
	public static void main(String[] args) {
		while(true){
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOM.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor(){
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable{
					return proxy.invokeSuper(obj, args);
				}
			});
			
			enhancer.create();
		}
	}
	
	static class OOM{
		
	}
}
