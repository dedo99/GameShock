package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Videogame;

public interface VideogameRepository extends CrudRepository<Videogame,String> {
	
}
