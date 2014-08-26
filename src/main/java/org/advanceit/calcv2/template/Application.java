package org.advanceit.calcv2.template;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Application class
 * 
 * <P>This class is used as the main class to run the app on behalf of Spring Boot.
 * 	  @Configuration needed for spring boot to run
 * 	  @EnableAutoConfiguration allows spring boot to configure spring for you ('opinionated' approach)
 * 	  @EnableWebMvc enables the mvc framework
 *    
 * @author MPyvovarov
 */
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan
public class Application {
	
    public static void main(String[] args) {
    	
        ApplicationContext ctx = SpringApplication.run(new Object[]{Application.class, AppConfiguration.class, SecurityConfig.class}, args);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}