package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.spring.controller.validator.VideogameValidator;
import it.uniroma3.siw.spring.model.Videogame;
import it.uniroma3.siw.spring.service.VideogameService;

@Controller
public class VideogameController {
	
	private static final Logger logger = LoggerFactory.getLogger(VideogameController.class);
	
	@Autowired
	private VideogameService videogameService;
	
	@Autowired
	private VideogameValidator videogameValidator;
	
	
	@RequestMapping(value = "/videogame", method = RequestMethod.GET)
	public String visualizzaVideoGame(Model model) {
		model.addAttribute("videogames", this.videogameService.getAllVideogames());
		return "videogame.html";
	}
	
	
	@RequestMapping(value = "/dettaglioVideogame/{code}", method = RequestMethod.GET)
	public String visualizzaDettagliVideogame(@PathVariable("code") String code, Model model) {
		Videogame v = this.videogameService.getSingleVideogame(code);
		model.addAttribute("videogame", v);
		logger.debug(v.getGenre().name());
		model.addAttribute("videogamesRec", this.videogameService.getAllVideogamesWithGenre(v.getGenre()));
		return "dettagli_videogame.html";
	}
	
	@RequestMapping(value = "/admin/insertVideogame", method = RequestMethod.GET)
	public String visualizzaInserisciVideogameAmm(Model model) {
		model.addAttribute("videogame", new Videogame());
		return "admin/inserisci_videogame_amm";
	}
	
	@RequestMapping(value = "/admin/showDeleteVideogameAmm", method = RequestMethod.GET)
	public String visualizzaVideogameAmm(Model model) {
		model.addAttribute("videogames", this.videogameService.getAllVideogames());
		return "admin/vedi_videogame_amm";
	}
	
	@RequestMapping(value = "/admin/ricercaVideogame", method = RequestMethod.POST)
	public String cercaVideogameAmm(@RequestParam("param") String paramSearch, Model model) {
		model.addAttribute("videogames", this.videogameService.searchVideogames(paramSearch));
		return "admin/vedi_videogame_amm";
	}
	
	@RequestMapping(value = "/admin/deleteVideogameAmm/{code}", method = RequestMethod.GET)
	public String cancellaVideogameAmm(@PathVariable("code") String code, Model model) {
		this.videogameService.deleteVideogame(code);
		return "admin/vedi_videogame_amm";
	}
	
	@RequestMapping(value = "/admin/addVideogame", method = RequestMethod.POST)
    public String saveVideogame(@RequestParam("file") MultipartFile file,
    		@ModelAttribute("videogame") Videogame videogame,
    		Model model,
    		BindingResult bindingResult)
    {
		this.videogameValidator.validate(videogame, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.videogameService.saveVideogameToDB(file, videogame);
			model.addAttribute("videogame", new Videogame());
		}
    	return "admin/inserisci_videogame_amm";
    }
	
}