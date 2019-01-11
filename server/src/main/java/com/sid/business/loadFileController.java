package com.sid.business;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sid.model.Employe;
import com.sid.service.EmployeService;
import com.sid.service.StockageFichier;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class loadFileController {

	@Autowired
	private StockageFichier stockageService;
	
	@Autowired
	private EmployeService employeService;

	@PostMapping("/charger")
	public ResponseEntity<String> chargerFichier(@RequestParam("file") MultipartFile file) {
		String message = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			stockageService.stocker(file);
			message = "Le fichier : " + file.getOriginalFilename() + " a été chargé avec succès.";
			TypeReference<List<Employe>> typRef = new TypeReference<List<Employe>>() {};
			InputStream is = file.getInputStream();
			List<Employe> employes = mapper.readValue(is, typRef);
			employeService.save(employes);
			System.out.println("Employees enregistré dans la base de données avec succès.");
			return ResponseEntity.status(HttpStatus.OK).body(message);

		} catch (Exception e) {
			message = "Erreur de chargement du fichier : " + file.getOriginalFilename() + " !";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

}
