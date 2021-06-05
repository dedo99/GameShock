package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GeneralController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
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
	
	
	@RequestMapping(value = "/admin/homeAmm", method = RequestMethod.GET)
	public String visualizzHomeAmm() {
		return "admin/home_amm.html";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String exitAccount() {
		return "index.html";
	}

}
