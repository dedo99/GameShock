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
import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Opera;
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
	
	
	@Transactional
	public void  saveAccessoryToDB(MultipartFile file,String titolo,
			String descrizione, Integer anno, Collezione col, Artista art){
		Accessory a = new Accessory();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			o.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		a.setTitolo(titolo);
		a.setAnnoDiRealizzazione(anno);
		a.setDescrizione(descrizione);
		a.setArtista(art);
		a.setCollezione(col);
        
        this.inserisciOpera(o);
	}
}
