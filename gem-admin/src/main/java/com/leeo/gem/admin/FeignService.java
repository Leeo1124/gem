package com.leeo.gem.admin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gem-task")
public interface FeignService {

	@GetMapping("/hello")
	String sayHiFromClientOne(@RequestParam("name") String name);
}