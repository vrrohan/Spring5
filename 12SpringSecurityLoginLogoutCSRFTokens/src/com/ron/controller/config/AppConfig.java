package com.ron.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ron.controller")
public class AppConfig {

	public static final String VIEW_TEMPLATE_LOCATION_PREFIX = "/WEB-INF/views/";
	public static final String VIEW_TEMPLATE_FILE_SUFFIX = ".jsp";

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix(VIEW_TEMPLATE_LOCATION_PREFIX);
		viewResolver.setSuffix(VIEW_TEMPLATE_FILE_SUFFIX);
		return viewResolver;
	}
}
