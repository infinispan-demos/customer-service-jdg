package com.redhat;

import static springfox.documentation.builders.PathSelectors.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableCaching
public class CustomerServiceJDGApplication {
	
	static Logger logger = LoggerFactory.getLogger(CustomerServiceJDGApplication.class);
	
	public static void main(String[] args) {
        try {
		SpringApplication.run(CustomerServiceJDGApplication.class, args);
        } catch (Exception e){
        	logger.error("Exception in main: ", e);
        }
	}
	
    @Bean
    public Docket apiApp() {
        return new Docket(DocumentationType.OAS_30)
        		.select()
        			.paths(regex("/customer.*"))
        			.build();       	        
    }   
}
