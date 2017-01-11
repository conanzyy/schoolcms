package com.cuckoo.cms.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 
 * @author tsx270129
 *
 */
public class CmsBeanFactory implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		setAppContext(context);
	}

	private static void setAppContext(ApplicationContext context){
		CmsBeanFactory.applicationContext=context;
	}
	
	@SuppressWarnings("unchecked")
	public static<T>T getBean(Class<T> cls){
		return (T)applicationContext.getBean(cls.getSimpleName());
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T>T getBean(String beanName){
		return (T)applicationContext.getBean(beanName);
	}
	
}
