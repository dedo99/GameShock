package it.uniroma3.siw.spring.controller;

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
import it.uniroma3.siw.spring.model.Platform;
import it.uniroma3.siw.spring.model.Videogame;
import it.uniroma3.siw.spring.service.VideogameService;

@Controller
public class VideogameController {
	

	
	@Autowired
	private VideogameService videogameService;
	
	@Autowired
	private VideogameValidator videogameValidator;
	
	/************
	 *** HOME ***
	 ************/
	
	@RequestMapping(value = "/videogames", method = RequestMethod.GET)
	public String showVideoGame(Model model) {
		model.addAttribute("videogames", this.videogameService.getAllVideogames());
		return "videogames";
	}
	
	@RequestMapping(value = "/detailsVideogame/{code}", method = RequestMethod.GET)
	public String showDetailsVideogame(@PathVariable("code") String code, Model model) {
		Videogame v = this.videogameService.getSingleVideogame(code);
		model.addAttribute("videogame", v);
		Platform p = v.getPlatform();
		model.addAttribute("videogamesRec", this.videogameService.getAllVideogamesByPlatform(p));
		return "details_videogame.html";
	}
	
	/*************
	 *** ADMIN ***
	 *************/
	
	@RequestMapping(value = "/admin/insertVideogame", method = RequestMethod.GET)
	public String showInsertVideogameAmm(Model model) {
		model.addAttribute("videogame", new Videogame());
		return "admin/insert_videogame_amm";
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
    	return "admin/insert_videogame_amm";
    }
	
	@RequestMapping(value = "/admin/deleteVideogameAmm/{code}", method = RequestMethod.GET)
	public String deleteVideogameAmm(@PathVariable("code") String code, Model model) {
		this.videogameService.deleteVideogame(code);
		model.addAttribute("videogames", this.videogameService.getAllVideogames());
		return "admin/show_videogames_amm";
	}
	
	@RequestMapping(value = "/admin/showDeleteVideogamesAmm", method = RequestMethod.GET)
	public String showVideogameAmm(Model model) {
		model.addAttribute("videogames", this.videogameService.getAllVideogames());
		return "admin/show_videogames_amm";
	}
	
	@RequestMapping(value = "/admin/researchVideogame", method = RequestMethod.POST)
	public String cercaVideogameAmm(@RequestParam("param") String paramSearch, Model model) {
		model.addAttribute("videogames", this.videogameService.searchVideogames(paramSearch));
		return "admin/show_videogames_amm";
	}
}
