package com.vignesh.tradingApplication.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfigure implements WebMvcConfigurer{
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
	}
	 @Bean
	    public FormHttpMessageConverter formHttpMessageConverter() {
	        return new FormHttpMessageConverter();
	    }
	
	

}
