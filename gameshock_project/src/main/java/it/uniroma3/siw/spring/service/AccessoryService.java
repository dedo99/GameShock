package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Accessory;
import it.uniroma3.siw.spring.repository.AccessoryRepository;

@Service
public class AccessoryService {

	@Autowired
	private AccessoryRepository accessoryrepository;
	
	@Transactional
	public Accessory addAccessory(Accessory accessory) {
		return this.accessoryrepository.save(accessory);
	}
	
	public Accessory getSingleAccessory(String code) {
		Optional<Accessory> optional = this.accessoryrepository.findById(code);
		if(optional.isPresent())
			return optional.get();
		else return null;
	}
	
	public List<Accessory> getAllAccessories() {
		return (List<Accessory>) this.accessoryrepository.findAll();
	}
	
	public boolean alreadyExistsAccessory(Accessory accessory) {
		Accessory a = this.getSingleAccessory(accessory.getCode());
		return a != null;
	}
}
