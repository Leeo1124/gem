package com.leeo.gem.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

	@Autowired
	FeignService feignService;

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public String sayHi(@RequestParam String name) {
		return feignService.sayHiFromClientOne(name);
	}
}