package br.com.herbies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.herbies.model.PersonEntity;
import br.com.herbies.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService services; 
	
	@GetMapping
	public List<PersonEntity> findAll() {
		return services.findAll();
	}

	@GetMapping("/{id}")
	public PersonEntity findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}

	@PostMapping
	public PersonEntity create(@RequestBody PersonEntity person) {
		return services.create(person);
	}
	
	@PutMapping
	public PersonEntity update(@RequestBody PersonEntity person) {
		return services.update(person);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
}