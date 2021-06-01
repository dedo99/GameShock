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
	
	@RequestMapping(value = "/videogame", method = RequestMethod.GET)
	public String visualizzaVideoGame() {
		return "videogame.html";
	}

	@RequestMapping(value = "/accessori", method = RequestMethod.GET)
	public String visualizzaAccessori() {
		return "accessori.html";
	}
	
	@RequestMapping(value = "/informazioni", method = RequestMethod.GET)
	public String visualizzaInformazioni() {
		return "informazioni.html";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String visualizzaLogin() {
		return "login_amm.html";
	}

}
