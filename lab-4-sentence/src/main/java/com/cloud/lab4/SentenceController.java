package com.cloud.lab4;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {
	
	@Autowired
	DiscoveryClient client;
	
	@RequestMapping("/sentence")
	  public @ResponseBody String getSentence() {
	    return 
	      getWord("LAB-4-SUBJECT") + " "
	      + getWord("LAB-4-VERB") + " " 
	    	+  getGreeting("LAB-4-SUBJECT") + " " ;
	  }
	
	public String getWord(String service) {
	    List<ServiceInstance> list = client.getInstances(service);
	    if (list != null && list.size() > 0 ) {
	      URI uri = list.get(0).getUri();
	  if (uri !=null ) {
	    return (new RestTemplate()).getForObject(uri,String.class);
	  }
	    }
	    return null;
	  }
	
	public String getGreeting(String service){
		 List<ServiceInstance> list = client.getInstances(service);
		  if (list != null && list.size() > 0 ) {
		      URI uri = list.get(0).getUri();
		      if (uri !=null ) {
		  	    return (new RestTemplate()).getForObject(uri+"/id/2",String.class);
		  	  }
		  }  
		return null;
	}

}
