package com.basic.rest.project.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@ComponentScan
@Slf4j
@EntityScan("com.basic.rest.project.rest")



public class RestApplication {

	public static void main(String[] args) {
		log.info("========Starting Rest Application=========");
		SpringApplication.run(RestApplication.class, args);
		log.info("========Stopping Rest Application=========");
	}

}
