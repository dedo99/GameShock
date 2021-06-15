package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Accessory;
import it.uniroma3.siw.spring.model.Platform;

public interface AccessoryRepository extends CrudRepository<Accessory,String> {

	public List<Accessory> findByNameOrCode(String name, String code);
	
	public List<Accessory> findByPlatform(Platform platform);
	
}
