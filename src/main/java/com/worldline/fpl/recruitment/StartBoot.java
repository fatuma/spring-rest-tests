package com.worldline.fpl.recruitment;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application entry point
 * 
 * @author A525125
 *
 */
@SpringBootApplication
@Slf4j
@EnableJpaRepositories
@EnableAutoConfiguration
public class StartBoot {
	
	/** The Constant log. */
	private final static Logger log = LoggerFactory.getLogger(StartBoot.class);
	public static void main(String[] args) {
		log.info("Start application ...");
		SpringApplication.run(StartBoot.class, args);
	}

}
