package it.uniroma3.siw.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Platform;
import it.uniroma3.siw.spring.repository.PlatformRepository;

@Service
public class PlatformService {

	@Autowired
	private PlatformRepository platformRepository;
	
	public List<Platform> getAllPlatforms() {
		return (List<Platform>) this.platformRepository.findAll();
	}
}
