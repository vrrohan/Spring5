package com.ron.controller.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ron.controller")
@PropertySource("classpath:resources/persistence-mysql.properties")
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

	@Autowired
	private Environment environment;

	// Setup logger for debugging
	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public DataSource getSpringSecurityDataSource() {
		// create c3p0 connection pool
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

		try {
			// set jdbc connection properties
			comboPooledDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
			comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
			comboPooledDataSource.setUser(environment.getProperty("jdbc.user"));
			comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));

			// connection pooling properties
			comboPooledDataSource
					.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
			comboPooledDataSource
					.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
			comboPooledDataSource
					.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
			comboPooledDataSource
					.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info(">>>JDBC driver = " + environment.getProperty("jdbc.driver"));
		logger.info(">>>JDBC url = " + environment.getProperty("jdbc.url"));
		logger.info(">>>JDBC user = " + environment.getProperty("jdbc.user"));
		logger.info(">>>JDBC password = " + environment.getProperty("jdbc.password"));

		return comboPooledDataSource;
	}
}
