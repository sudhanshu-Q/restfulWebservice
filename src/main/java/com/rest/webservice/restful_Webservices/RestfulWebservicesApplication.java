package com.rest.webservice.restful_Webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
//@EnableSwagger2
//@EnableWebMvc
public class RestfulWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebservicesApplication.class, args);
	}

	  @Configuration
	    public class WebConfig implements WebMvcConfigurer {      
	        @Override
	        public void addResourceHandlers(ResourceHandlerRegistry registry) {
	            registry.addResourceHandler("/**")
	            .addResourceLocations("classpath:/static/","classpath:/image/")
	            .setCachePeriod(0);
	        }
	    }
}
