package com.leeo.gem.admin;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceHystric implements FeignService {//熔断
	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry " + name;
	}
}