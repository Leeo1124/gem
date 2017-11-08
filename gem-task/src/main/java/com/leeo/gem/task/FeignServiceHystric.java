package com.leeo.gem.task;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceHystric implements FeignService {// 熔断
	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry " + name;
	}
}