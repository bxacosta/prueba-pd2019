package com.bxacosta.app02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class App02Application {

	public static void main(String[] args) {
		SpringApplication.run(App02Application.class, args);
	}
}
