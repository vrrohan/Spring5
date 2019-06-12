package com.ron.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.ron.springtest")
public class AppConfig implements WebMvcConfigurer {

	public static final String VIEW_TEMPLATE_LOCATION_PREFIX = "/WEB-INF/views/";
	public static final String VIEW_TEMPLATE_FILE_SUFFIX = ".jsp";

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/wel").setViewName("welcome");
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix(VIEW_TEMPLATE_LOCATION_PREFIX);
		viewResolver.setSuffix(VIEW_TEMPLATE_FILE_SUFFIX);
		return viewResolver;
	}
}
