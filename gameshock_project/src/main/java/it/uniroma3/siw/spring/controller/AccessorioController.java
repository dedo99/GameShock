package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Category;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Platform;
import it.uniroma3.siw.spring.service.AccessoryService;

@Controller
public class AccessorioController {
	
	@Autowired
	private AccessoryService accessoryService;
	
	
	@RequestMapping(value = "/accessori", method = RequestMethod.GET)
	public String visualizzaAccessori(Model model) {
		model.addAttribute("accessori", this.accessoryService.getAllAccessories());
		return "accessori.html";
	}
	
	
	@RequestMapping(value = "/dettaglioAccessorio/{code}", method = RequestMethod.GET)
	public String visualizzaDettagliAccessorio(@PathVariable("code") String code, Model model) {
		model.addAttribute("accessorio", this.accessoryService.getSingleAccessory(code));
		return "dettagli_accessorio.html";
	}
	
	
	@RequestMapping(value = "/admin/addAccessorio", method = RequestMethod.POST)
    public String saveOpera(@RequestParam("file") MultipartFile file,
    		@RequestParam("code") String code,
    		@RequestParam("name") String name,
    		@RequestParam("description") String description,
    		@RequestParam("rating") Float rating,
    		@RequestParam("newPrice") Float newPrice,
    		@RequestParam("usedPrice") Float usedPrice,
    		@RequestParam("color") String color,
    		@RequestParam("category") Category category,
    		@RequestParam("platform") Platform platform,
    		@RequestParam("usedPrice") Float usedPrice,
    		Model model)
    {
		this.accessoryService.saveOperaToDB(file, titolo, descrizione, anno, collezione, artista);
    	return "inserisci_accessorio_amm.html";
    }


}
