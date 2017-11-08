package com.leeo.gem.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

	@Autowired
	FeignService feignService;

	@GetMapping(value = "/feign")
	public String feign(@RequestParam String name) {
		return feignService.sayHiFromClientOne(name);
	}
}