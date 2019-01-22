package com.wj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/*
 * Permet d'activer le service de configuration
 * Ce service de configuation a besoin d'être configurer
 * On le fait dans le fichier application.properties.
 * Dans ce fichier on change le port car toutes les 
 * microservices ne peuvent démarrer sur le même port.
 * On doit indiquer à ce microservice de configuration le chemin du 
 * dossier qui contient le fichier de configuration de l'ensemble
 * des microservices. 
 * Un dossier de configuration utilise git. On va utiliser un repository
 * git.
 * 
 */
@EnableConfigServer 

@SpringBootApplication
public class ServiceConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigApplication.class, args);
	}

}

