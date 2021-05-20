package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Videogame;
import it.uniroma3.siw.spring.repository.VideogameRepository;

@Service
public class VideogameService {

	@Autowired
	private VideogameRepository videogamerepository;
	
	@Transactional
	public Videogame addVideogame(Videogame videogame) {
		return this.videogamerepository.save(videogame);
	}
	
	public Videogame getSingleVideogame(String code) {
		Optional<Videogame> optional = this.videogamerepository.findById(code);
		if(optional.isPresent())
			return optional.get();
		else return null;
	}
	
	public List<Videogame> getAllVideogames() {
		return (List<Videogame>) this.videogamerepository.findAll();
	}
	
	public boolean alreadyExistsVideogame(Videogame videogame) {
		Videogame v = this.getSingleVideogame(videogame.getCode());
		return v != null;
	}
	
}
