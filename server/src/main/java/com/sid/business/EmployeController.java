package com.sid.business;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.model.Employe;
import com.sid.service.EmployeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeController {

	@Autowired
	private EmployeService employeService;

	public EmployeController(EmployeService employeService) {
		this.employeService = employeService;
	}

	//return a list of Employe
	@GetMapping("/list")
	public Iterable<Employe> list() {
		return employeService.list();
	}
	
	//return a Single Employe
	@GetMapping("/list/{id}")
	public Employe getEmploye(@PathVariable("id") long id) {
		return employeService.getEmploye(id);
	}
	
	//save an Employe
	@PostMapping("/save")
	public Employe save(@Valid @RequestBody Employe e) {
		return employeService.save(e);
	}
	
	//delete an Employe
	@DeleteMapping("/delete/{id}")
	public void save(@PathVariable("id") long id) {
		employeService.delete(id);
	}


}
