package com.ron.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		// create spring application context
		AnnotationConfigWebApplicationContext con = new AnnotationConfigWebApplicationContext();
		con.register(AppConfig.class);

		// create dispatcher servlet
		DispatcherServlet dis = new DispatcherServlet(con);

		// register and configure dispatcher servlet
		ServletRegistration.Dynamic regis = servletContext.addServlet("dispatcher", dis);
		regis.setLoadOnStartup(1);
		regis.addMapping("/");
	}

}
