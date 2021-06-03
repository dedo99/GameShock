package it.uniroma3.siw.spring.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.spring.model.Accessory;
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
	
	
	@Transactional
	public Videogame getSingleVideogame(String code) {
		Optional<Videogame> optional = this.videogamerepository.findById(code);
		if(optional.isPresent())
			return optional.get();
		else return null;
	}
	
	
	@Transactional
	public List<Videogame> getAllVideogames() {
		return (List<Videogame>) this.videogamerepository.findAll();
	}
	
	
	@Transactional
	public boolean alreadyExistsVideogame(Videogame videogame) {
		Videogame v = this.getSingleVideogame(videogame.getCode());
		return v != null;
	}
	
	
	@Transactional
	public void  saveVideogameToDB(MultipartFile file, Videogame videogame){
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			videogame.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
        this.addVideogame(videogame);
	}
	
}
