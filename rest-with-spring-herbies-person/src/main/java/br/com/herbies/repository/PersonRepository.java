package br.com.herbies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.herbies.model.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long>{

}
