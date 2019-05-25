package br.com.herbies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.herbies.exception.ResourceNotFoundException;
import br.com.herbies.model.PersonEntity;
import br.com.herbies.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	
	public PersonEntity create(PersonEntity person) {
		return repository.save(person);
	}
	
	public List<PersonEntity> findAll(){
		return repository.findAll();
	}
	
	public PersonEntity findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Records Found for this Id"));
	}

	public PersonEntity update(PersonEntity person) {
		PersonEntity entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No Records Found for this Id"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		PersonEntity entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Records Found for this Id"));
		repository.delete(entity);
	}	
}