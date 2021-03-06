package org.advanceit.calcv2.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * SecurityConfig class
 * 
 * <P>Configures Spring security
 *    
 * @author MPyvovarov
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
   /**
    * Configures association between user credentials and roles
    *
    * @param       AuthenticationManagerBuilder auth
    */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("max").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	  auth.inMemoryAuthentication().withUser("sfdc").password("123456").roles("CALCV2_CLIENT");
	}
     
	/**
     * Configures the access to the appropriate resources for the roles
	 *
	 * @param       HttpSecurity http
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.authorizeRequests()
	  	.antMatchers("/calcV2/**").access("hasRole('ROLE_CALCV2_CLIENT')")
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.and().formLogin();
 
	}
}
