package com.sid;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sid.service.StockageFichier;

@SpringBootApplication
public class MicroServiceApplication implements CommandLineRunner {
	
	@Resource
	StockageFichier stockageFichier;

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		stockageFichier.supprimerFichiers();
		stockageFichier.initialiser();
	}

}
