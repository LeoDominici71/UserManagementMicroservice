package com.fiap.clientRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRegistryApplication.class, args);
	}

}
