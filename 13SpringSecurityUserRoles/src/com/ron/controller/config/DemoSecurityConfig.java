package com.ron.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String LOGIN_PAGE_URL = "/showMyLoginPage";
	public static final String LOGIN_PROCESSING_URL_TO_AUTHENTICATE = "/authenticateUser";
	public static final String EMPLOYEE_ROLES_HOME_PAGE_URL_ACCESS = "/";
	public static final String MANAGER_ROLES_PAGE_URL_ACCESS = "/manager/**";
	public static final String ADMIN_ROLES_PAGE_URL_ACCESS = "/admin/**";
	public static final String ACCESS_DENIED_MAPPING_URL = "/accessDenied";

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
				.withUser(users.username("rohan").password("rohan123").roles("EMPLOYEE", "MANAGER", "ADMIN"))
				.withUser(users.username("admin").password("admin123").roles("ADMIN"))
				.withUser(users.username("anjani").password("anji123").roles("EMPLOYEE"))
				.withUser(users.username("alice").password("alice123").roles("MANAGER"))
				.withUser(users.username("bob").password("bob123").roles("EMPLOYEE", "MANAGER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers(EMPLOYEE_ROLES_HOME_PAGE_URL_ACCESS)
				.hasAnyRole("EMPLOYEE", "ADMIN", "MANAGER").antMatchers(MANAGER_ROLES_PAGE_URL_ACCESS)
				.hasRole("MANAGER").antMatchers(ADMIN_ROLES_PAGE_URL_ACCESS).hasRole("ADMIN").and().formLogin()
				.loginPage(LOGIN_PAGE_URL).loginProcessingUrl(LOGIN_PROCESSING_URL_TO_AUTHENTICATE).permitAll().and()
				.logout().permitAll().and().exceptionHandling().accessDeniedPage(ACCESS_DENIED_MAPPING_URL);
	}

}
