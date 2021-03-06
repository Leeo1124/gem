package com.leeo.gem.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonControler {

	@Autowired
	RibbonService ribbonService;

	@GetMapping("/ribbon")
	public String ribbon(@RequestParam String name) {
		return ribbonService.ribbon(name);
	}

}