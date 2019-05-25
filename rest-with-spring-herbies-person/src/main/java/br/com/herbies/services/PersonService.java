package br.com.herbies.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.herbies.model.PersonEntity;

@Service
public class PersonService {
	private final AtomicLong counter = new AtomicLong();
	
	public PersonEntity create(PersonEntity person) {
		return person;
	}
	
	public PersonEntity update(PersonEntity person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public PersonEntity findById(String id) {
		PersonEntity person = new PersonEntity();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Herbert");
		person.setLastName("Filhik de Lima");
		person.setAddress("São Paulo - Brasil");
		person.setGender("Male");
		
		return person;
	}
	
	public List<PersonEntity> findAll(){
		List<PersonEntity> persons = new ArrayList<PersonEntity>();
		for(int i = 0; i < 8; i++ ) {
			PersonEntity person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private PersonEntity mockPerson(int i) {
		PersonEntity person = new PersonEntity();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name" + i);
		person.setLastName("Last Name" + i);
		person.setAddress("São Paulo - Brasil" + i);
		person.setGender("Male");
		return person;
	}

}
