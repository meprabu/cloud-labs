package com.cloud;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class LuckyWordController {
	
	@Value("${lucky-word}") String luckyWord;
	
	@Autowired
    private Environment environment;
	
	private static final Logger logger = LoggerFactory.getLogger(LuckyWordController.class);

	  @RequestMapping("/lucky-word")
	  public String showLuckyWord() {
		  
		  logger.debug("the value from environment variable--->>>"+environment.getProperty("lucky-word"));  
		  logger.debug("the value from environment variable--->>>");  
		  logger.info("the value from environment variable--->>>");  
		  logger.warn("the value from environment variable--->>>");  
		  logger.error("the value from environment variable--->>>");  
		  
	    return "The lucky word is: " + luckyWord;
	  }	
	  
	  @RequestMapping("/test")
	  public String testmyConnection(){
		  return "TEST";
	  }

}
