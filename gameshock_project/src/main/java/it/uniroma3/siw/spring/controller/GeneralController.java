package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GeneralController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String visualizzaHome() {
		return "index.html";
	}
	
	@RequestMapping(value = "/informazioni", method = RequestMethod.GET)
	public String visualizzaInformazioni() {
		return "informazioni.html";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String visualizzaLogin() {
		return "login_amm.html";
	}
	
	@RequestMapping(value = "/homeAmm", method = RequestMethod.GET)
	public String visualizzHomeAmm() {
		return "home_amm.html";
	}
	
	@RequestMapping(value = "/insertVideogame", method = RequestMethod.GET)
	public String visualizzaInserisciVideogameAmm() {
		return "inserisci_videogame_amm.html";
	}
	
	@RequestMapping(value = "/insertAccessorio", method = RequestMethod.GET)
	public String visualizzaInserisciAccessorioAmm() {
		return "inserisci_accessorio_amm.html";
	}
	
	@RequestMapping(value = "/showDeleteVideogameAmm", method = RequestMethod.GET)
	public String visualizzaVideogameAmm() {
		return "vedi_videogame_amm.html";
	}
	
	@RequestMapping(value = "/showDeleteAccessorioAmm", method = RequestMethod.GET)
	public String visualizzaAccessoriAmm() {
		return "vedi_accessorio_amm.html";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String exitAccount() {
		return "index.html";
	}

}
