package com.star.sud.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

import com.star.sud.filter.RequestResponseLoggingFilter;

@Configuration
public class FilterConfig {

	// Uncomment this and comment the @Component in the filter class definition to
	// register only for a url pattern
	// @Bean
	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {
		FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new RequestResponseLoggingFilter());

		registrationBean.addUrlPatterns("/employees/*");

		return registrationBean;

	}

}