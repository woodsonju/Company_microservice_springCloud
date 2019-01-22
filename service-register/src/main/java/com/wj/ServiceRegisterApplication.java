package com.wj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 * Pour démarrer le service d'enregistrement, on utilise l'annotation
 * @EnableEurekaServer. 
 * Il a besoin de trois propriétés, qu'on va définir ,non pas dans 
 * application.properties mais dans un fichier de configuration centraliser,
 * avec git; On l'appelle eureka-service.properties
 */
@EnableEurekaServer
@SpringBootApplication
public class ServiceRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegisterApplication.class, args);
	}

}

