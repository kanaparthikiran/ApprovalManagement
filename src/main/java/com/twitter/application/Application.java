/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.application;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import com.twitter.util.IParameterParser;
/**
 * Main class that initializes the application
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
@SpringBootApplication
@ComponentScan({"com.twitter"})
public class Application implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private IParameterParser parameterParser;
    

    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		
        logger.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
        logger.info("NonOptionArgs: {}", args.getNonOptionArgs());
        logger.info("OptionNames: {}", args.getOptionNames());
        int count = 0;
        String paramValue = null;
        for (String name : args.getOptionNames()){
            	paramValue = name;
            	if(!StringUtils.isEmpty(paramValue)) {
            		count++;
            		break;
            	}
        }
        logger.info(" The count is {}  paramValue{} ", count,paramValue);
		try {
			parameterParser.parseParams(paramValue);
		}
		catch(Exception e){
			logger.error("Exception during Approval", e);
		}
	}

}

