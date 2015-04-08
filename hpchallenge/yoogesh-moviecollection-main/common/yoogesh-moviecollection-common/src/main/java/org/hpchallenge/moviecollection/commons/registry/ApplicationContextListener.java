/**
 * 
 */
package org.hpchallenge.moviecollection.commons.registry;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @author yoogesh.sharma
 * @since 1.0
 */
@Component
public class ApplicationContextListener implements ApplicationContextAware {

	private static ApplicationContext contextMovieCollector;
	
	public static <T> T getBean(Class<T> T){
		return contextMovieCollector.getBean(T);
	}

	public static Object getBean(String beanName){
		return contextMovieCollector.getBean(beanName);
	}
	
	//@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		contextMovieCollector = applicationContext;
	}
}
