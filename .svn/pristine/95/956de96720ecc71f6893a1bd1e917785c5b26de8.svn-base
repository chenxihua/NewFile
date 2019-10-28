package com.neuedu.crm.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.neuedu.crm.utils.Operation;



/**
 * AOP 切面编程，结合日志框架
 * @author Administrator
 *
 */

@Component
@Aspect
public class BookAOP {
	
	private Logger logger = LoggerFactory.getLogger(BookAOP.class);
	
	
	@Pointcut("execution(* com.neuedu.crm.view.*.*(..))")
	public void method(){
	}
	
	@After("method()")
	public void afterMethod(JoinPoint joinPoint){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();		
		Class<? extends Object> clazz =  joinPoint.getTarget().getClass();
		String controllerOperation = clazz.getName();
		if(clazz.isAnnotationPresent(Operation.class)){
			// 当前controller操作的名称
			controllerOperation = clazz.getAnnotation(Operation.class).name();
		}
		// 获取当前方法
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		// clazz类下的所有方法
		Method[] methods = clazz.getDeclaredMethods();
		String methodOperation = "";
		for (Method m : methods) {
			if(m.equals(method)){
				methodOperation = m.getName();
				if(m.isAnnotationPresent(Operation.class)){
					methodOperation = m.getAnnotation(Operation.class).name();
					// 进行输出
					String username = (String) request.getSession().getAttribute("name");
					if(username != null){
						logger.info(username + "操作了：" + controllerOperation + "类，下的：" + methodOperation+"方法。");
					}else{
						logger.info("未知用户操作了：" + controllerOperation + "类，下的：" + methodOperation+"方法。");
					}
				}
			}
		}
	}
	

}
