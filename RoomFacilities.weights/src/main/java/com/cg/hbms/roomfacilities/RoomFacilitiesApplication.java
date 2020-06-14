package com.cg.hbms.roomfacilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.cg")
//@EnableDiscoveryClient
public class RoomFacilitiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomFacilitiesApplication.class, args);

	}
	
	@Bean
//	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}
//CatalogMsApplication