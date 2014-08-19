package org.advanceit.calcv2.template;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * AppConfiguration class
 * 
 * <P>This class is used to override the default configuration done by spring boot  
 *    
 * @author MPyvovarov
 */
public class AppConfiguration {
	
	/**
	 * Returns a InternalResourceViewResolver object used to override the default viewresolver provided by Spring Boot
	 * @Bean annotation makes this method return statement a runtime bean
	 *
	 * @return      InternalResourceViewResolver object
	*/
	@Bean       
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
	
}
