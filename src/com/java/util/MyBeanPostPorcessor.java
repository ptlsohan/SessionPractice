package com.java.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostPorcessor implements BeanPostProcessor{

	
	public  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Before init"+ beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("After init"+ beanName);
		return bean;
	}
}
