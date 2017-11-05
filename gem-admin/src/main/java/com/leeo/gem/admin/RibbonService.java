package com.leeo.gem.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RibbonService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hiError")//熔断方法
	public String helloService(String name) {
		return restTemplate.getForObject("http://GEM-MONITOR/hello?name=" + name, String.class);
	}
	
	public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}