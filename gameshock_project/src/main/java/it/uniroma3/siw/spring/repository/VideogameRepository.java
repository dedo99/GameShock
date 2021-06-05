package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Genre;
import it.uniroma3.siw.spring.model.Videogame;

public interface VideogameRepository extends CrudRepository<Videogame,String> {
	
	public List<Videogame> findByNameOrCode(String name, String code);

	public List<Videogame> findByGenre(Genre genre);	
	
}
