package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Accessory;

public interface AccessoryRepository extends CrudRepository<Accessory,String> {
	
}
