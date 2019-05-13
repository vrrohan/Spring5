package com.ron.controller.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String LOGIN_PAGE_URL = "/showMyLoginPage";
	public static final String LOGIN_PROCESSING_URL_TO_AUTHENTICATE = "/authenticateUser";
	public static final String EMPLOYEE_ROLES_HOME_PAGE_URL_ACCESS = "/";
	public static final String MANAGER_ROLES_PAGE_URL_ACCESS = "/manager/**";
	public static final String ADMIN_ROLES_PAGE_URL_ACCESS = "/admin/**";
	public static final String ACCESS_DENIED_MAPPING_URL = "/accessDenied";
	// 60 is seconds Hence for 5 minutes, its 5*60
	public static final int TIME_FOR_REMEMBER_ME_SESSION_LOGIN = 5 * 60;

	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers(EMPLOYEE_ROLES_HOME_PAGE_URL_ACCESS)
				.hasAnyRole("EMPLOYEE", "ADMIN", "MANAGER").antMatchers(MANAGER_ROLES_PAGE_URL_ACCESS)
				.hasRole("MANAGER").antMatchers(ADMIN_ROLES_PAGE_URL_ACCESS).hasRole("ADMIN").and().formLogin()
				.loginPage(LOGIN_PAGE_URL).loginProcessingUrl(LOGIN_PROCESSING_URL_TO_AUTHENTICATE).permitAll().and()
				.logout().deleteCookies("JSESSIONID").permitAll().and().rememberMe().key("uniqueAndSecret")
				.tokenValiditySeconds(TIME_FOR_REMEMBER_ME_SESSION_LOGIN).and().exceptionHandling()
				.accessDeniedPage(ACCESS_DENIED_MAPPING_URL);
	}

}
