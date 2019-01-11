package com.sid.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StockageFichier {
	
	private final Path emplacement = Paths.get("upload-dir");
	
	public void stocker(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.emplacement.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("Probleme de stockage !");
		}
	}
	
	public Resource chargerFichier(String filename) {
		try {
			Path file = emplacement.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Probleme de lecture !");
			}
		} catch (Exception e) {
			throw new RuntimeException("Probleme de lecture !");
		}
	}
	
	public void supprimerFichiers() {
		FileSystemUtils.deleteRecursively(emplacement.toFile());
	}
	
	public void initialiser() {
		try {
			Files.createDirectory(emplacement);
		} catch (IOException e) {
			throw new RuntimeException("Probleme d'initialisation de l'emplacement de stockage !");
		}
	}

}
