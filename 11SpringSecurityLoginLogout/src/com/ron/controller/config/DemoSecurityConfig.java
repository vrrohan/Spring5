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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("rohan").password("rohan123").roles("EMP"))
				.withUser(users.username("admin").password("admin123").roles("ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage(LOGIN_PAGE_URL)
				.loginProcessingUrl(LOGIN_PROCESSING_URL_TO_AUTHENTICATE).permitAll().and().logout().permitAll();
	}

}
