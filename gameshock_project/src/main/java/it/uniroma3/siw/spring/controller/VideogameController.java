package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.VideogameService;

@Controller
public class VideogameController {
	
	
	@Autowired
	private VideogameService videogameService;
	
	
	@RequestMapping(value = "/videogame", method = RequestMethod.GET)
	public String visualizzaVideoGame(Model model) {
		model.addAttribute("videogame", this.videogameService.getAllVideogames());
		return "videogame.html";
	}
	
	
	@RequestMapping(value = "/dettaglioVideogame/{code}", method = RequestMethod.GET)
	public String visualizzaDettagliVideogame(@PathVariable("code") String code, Model model) {
		model.addAttribute("videogame", this.videogameService.getSingleVideogame(code));
		return "dettagli_videogame.html";
	}
	
	
}
