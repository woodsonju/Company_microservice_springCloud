package com.wj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
//Si on veut qu'il publie son nom dans l'annuaire
@EnableDiscoveryClient
public class ServiceProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProxyApplication.class, args);
	}

}

