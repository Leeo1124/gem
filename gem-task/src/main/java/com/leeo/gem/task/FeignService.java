package com.leeo.gem.task;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gem-admin", fallback = FeignServiceHystric.class)
public interface FeignService {

	@GetMapping("/hello")
	String sayHiFromClientOne(@RequestParam("name") String name);
}