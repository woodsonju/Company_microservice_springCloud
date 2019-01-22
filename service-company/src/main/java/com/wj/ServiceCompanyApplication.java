package com.wj;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.wj.dao.CompanyRepository;
import com.wj.dao.entities.Company;

/*
 * On a l'habitude d'implementer l'interface CommandLineRunner
 * Ici on va créer une methode start() avec CommandLineRunner;
 * et l'annotation @Bean (Tout ce qui est déclaré Bean s'éxecute 
 * au démarrage)
 */
@SpringBootApplication
//Quand tu démarres publies ta réference dans l'annuaire
@EnableDiscoveryClient
public class ServiceCompanyApplication implements CommandLineRunner {

	@Autowired
	CompanyRepository companyRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		companyRepository.save(new Company(null, "X", 100+Math.random()+900));
		companyRepository.save(new Company(null, "Y", 100+Math.random()+900));
		companyRepository.save(new Company(null, "Z", 100+Math.random()+900));
		
		companyRepository.findAll().forEach(c-> {
			System.out.println(c);
		});
		
	}
	

	
	/*CommandLineRunner start(CompanyRepository companyRepository) {
		return args->{
			Stream.of("A", "B", "C").forEach(cn->{
						companyRepository.save(new Company(null,cn, 100+Math.random()+900));
					});
			companyRepository.findAll().forEach(System.out::println);
		};
	}*/

}

