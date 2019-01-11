package com.sid.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.sid.model.Employe;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void save() {
		ResponseEntity<Employe> responseEntity = restTemplate.postForEntity("/api/save",
				new Employe("MATELDO", "Nadem", "Ingénieur C++"), Employe.class);
		Employe employe = responseEntity.getBody();
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("MALELDO", employe.getNom());
	}

}
