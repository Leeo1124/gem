package com.leeo.gem.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonControler {

	@Autowired
	RibbonService ribbonService;

	@RequestMapping(value = "/hello")
	public String hello(@RequestParam String name) {
		return ribbonService.helloService(name);
	}

}