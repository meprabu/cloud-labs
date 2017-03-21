package com.cloud.lab4;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class SubjectController {
	
	@Value("${words}")
	String words;
	
	 @RequestMapping("/")
	  public @ResponseBody String getWord() {
	    String[] wordArray = words.split(",");
	    int i = (int)Math.round(Math.random() * (wordArray.length - 1));
	    return wordArray[i];
	  }
	 
	 
	 @RequestMapping("/id/{number}")
	  public String getNumberGreeting(@PathVariable String number) {
	   String greeting = "Welcome Glad to meet you" + number + "of people";
	    return greeting;
	  }

}
