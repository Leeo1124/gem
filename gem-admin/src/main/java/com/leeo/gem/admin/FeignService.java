package com.leeo.gem.admin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gem-monitor", fallback = FeignServiceHystric.class)
public interface FeignService {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String sayHiFromClientOne(@RequestParam(value = "name") String name);
}