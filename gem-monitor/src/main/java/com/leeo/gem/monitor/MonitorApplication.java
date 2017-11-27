package com.leeo.gem.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zipkin.server.EnableZipkinServer;

@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@EnableTurbine
@EnableZipkinServer
public class MonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorApplication.class, args);
	}

	@Value("${server.port}")
	String port;
	
	@GetMapping("/hello")
	public String home(@RequestParam("name") String name) {
		return "hello "+name+",i am from port:" +port;
	}
	
	@Autowired
	private SystemProperties systemProperties;

	@GetMapping(value = "/config")
	public String config() {
		return systemProperties.getLocalUploadPath();
	}

}
