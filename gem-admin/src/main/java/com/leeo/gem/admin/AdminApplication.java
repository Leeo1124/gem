package com.leeo.gem.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign
 * 
 * SpringCLoud中的“Discovery Service”有多种实现，比如：eureka, consul, zookeeper。
 * 
 * 1，@EnableDiscoveryClient 注解是基于spring-cloud-commons依赖，并且在classpath中实现；
 * 2，@EnableEurekaClient 注解是基于spring-cloud-netflix依赖，只能为eureka作用；
 * 
 * 如果你的classpath中添加了eureka，则它们的作用是一样的
 * 
 * 
 * @author leeo
 *
 */
@EnableDiscoveryClient
// @EnableEurekaClient
@SpringBootApplication
@RestController
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Bean
	@LoadBalanced // @LoadBalanced注解表明这个restRemplate开启负载均衡的功能
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Value("${server.port}")
	String port;

	@GetMapping("/hello")
	public String home(@RequestParam String name) {
		return "hello " + name + ",i am from port:" + port;
	}

	@Autowired
	private SystemProperties systemProperties;

	@GetMapping(value = "/config")
	public String config() {
		return systemProperties.getLocalUploadPath();
	}

}
