package com.leeo.gem.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CenterApplication {

	public static void main(String[] args) {
// java -jar gem-center.jar --spring.profiles.active=center1
// java -jar gem-center.jar --spring.profiles.active=center2
// java -jar gem-center.jar --spring.profiles.active=center3

		SpringApplication.run(CenterApplication.class, args);
	}
}
