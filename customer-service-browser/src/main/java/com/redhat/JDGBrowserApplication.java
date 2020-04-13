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
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableCaching
@EnableSwagger2WebMvc
@ImportResource("classpath:infinispan-cache.xml")
public class JDGBrowserApplication {
	
	static Logger logger = LoggerFactory.getLogger(JDGBrowserApplication.class);
	
	public static void main(String[] args) {
        try {
		SpringApplication.run(JDGBrowserApplication.class, args);
        } catch (Exception e){
        	logger.error("Exception in main: ", e);
        }
	}
	
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
        			.paths(regex("/cache.*"))
        			.build();       	        
    }
    
}
