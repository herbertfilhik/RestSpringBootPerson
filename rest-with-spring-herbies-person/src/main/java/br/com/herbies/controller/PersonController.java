package br.com.herbies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.herbies.model.PersonEntity;
import br.com.herbies.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService services; 
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonEntity> findAll() {
		return services.findAll();
	}
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonEntity findById(@PathVariable("id") String id) {
		return services.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonEntity create(@RequestBody PersonEntity person) {
		return services.create(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonEntity update(@RequestBody PersonEntity person) {
		return services.update(person);
	}
	 
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		services.delete(id);
	}
}