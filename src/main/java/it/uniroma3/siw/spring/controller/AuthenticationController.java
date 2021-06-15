package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Amministrator;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.service.CredentialsService;

@Controller
public class AuthenticationController {
	
	@Autowired
	private CredentialsService credentialsService;
	
	@RequestMapping(value = "/admin/homeAmm", method = RequestMethod.GET)
	public String showHomeAmm(Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	model.addAttribute("admin",credentials.getAdmin());
		return "admin/home_amm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showFormLogin() {
		return "login_amm";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "index";
	}
	
    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String defaultAfterLogin(Model model) {
        
    	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
    		model.addAttribute("userDetails",userDetails);
    		model.addAttribute("admin",credentials.getAdmin());
            return "admin/home_amm";
        }
    	return "login/amm";
    }
    
    @RequestMapping(value = { "/register" }, method = RequestMethod.GET)
    public String registerUser() {

        Credentials c = Credentials.builder().username("pippo").password("pluto").role(Credentials.ADMIN_ROLE).build();
        Amministrator a = Amministrator.builder().name("Mario").surname("Rossi").build();
        c.setAdmin(a);
        credentialsService.saveCredentials(c);
        return "login_amm";
    }
    
//    @RequestMapping(value = "/default", method = RequestMethod.GET)
//    public String defaultAfterLogin(Model model,
//    		@ModelAttribute("credenziali") Credenziali credenziali,
//    		BindingResult bindingResult) {
//        
//    	this.credenzialiValidator.validate(credenziali, bindingResult);
//    	if(!bindingResult.hasErrors()) {
//    		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        	Credenziali credentials = credenzialiService.getCredentials(userDetails.getUsername());
//        	if (credentials.getRole().equals(Credenziali.ADMIN_ROLE)) {
//                return "admin/home_amm";
//            }
//        	return "index";
//    	}
//    	return "login_amm";
//    }
	

}
