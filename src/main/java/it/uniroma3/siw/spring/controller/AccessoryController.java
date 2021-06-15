package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.spring.controller.validator.AccessoryValidator;
import it.uniroma3.siw.spring.model.Accessory;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.Platform;
import it.uniroma3.siw.spring.service.AccessoryService;
import it.uniroma3.siw.spring.service.CredentialsService;

@Controller
public class AccessoryController {
	
	@Autowired
	private AccessoryService accessoryService;
	
	@Autowired
	private CredentialsService credentialsService;
	
	@Autowired
	private AccessoryValidator accessoryValidator;
	
	/************
	 *** HOME ***
	 ************/
	
	@RequestMapping(value = "/accessories", method = RequestMethod.GET)
	public String showAccessories(Model model) {
		model.addAttribute("accessories", this.accessoryService.getAllAccessories());
		return "accessories";
	}
	
	@RequestMapping(value = "/detailsAccessory/{code}", method = RequestMethod.GET)
	public String showDetailsAccessory(@PathVariable("code") String code, Model model) {
		Accessory a = this.accessoryService.getSingleAccessory(code);
		model.addAttribute("accessory", a);
		Platform p = a.getPlatform();
		model.addAttribute("accessoriesRec", this.accessoryService.getAllAccessoriesByPlatform(p));
		return "details_accessory";
	}
	
	@RequestMapping(value = "/researchAccessory", method = RequestMethod.POST)
	public String researchAccessory(@RequestParam("param") String paramSearch, Model model) {
		model.addAttribute("accessories", this.accessoryService.searchAccessories(paramSearch));
		return "accessories";
	}
	
	/*************
	 *** ADMIN ***
	 *************/
	
	@RequestMapping(value = "/admin/insertAccessory", method = RequestMethod.GET)
	public String showInsertAccessoryAmm(Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	model.addAttribute("admin",credentials.getAdmin());
		model.addAttribute("accessory", new Accessory());
		return "admin/insert_accessory_amm";
	}
	
	@RequestMapping(value = "/admin/addAccessory", method = RequestMethod.POST)
    public String saveAccessory(@RequestParam("file") MultipartFile file,
    		@ModelAttribute("accessory") Accessory accessory,
    		Model model,
    		BindingResult bindingResult)
    {
		this.accessoryValidator.validate(accessory, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.accessoryService.saveAccessoryToDB(file, accessory);
			model.addAttribute("accessory", new Accessory());
		}
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	model.addAttribute("admin",credentials.getAdmin());
    	return "admin/insert_accessory_amm";
    }
	
	@RequestMapping(value = "/admin/showDeleteAccessoriesAmm", method = RequestMethod.GET)
	public String showAccessoriesAmm(Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	model.addAttribute("admin",credentials.getAdmin());
		model.addAttribute("accessories", this.accessoryService.getAllAccessories());
		return "admin/show_accessories_amm";
	}
	
	@RequestMapping(value = "/admin/deleteAccessoryAmm/{code}", method = RequestMethod.GET)
	public String deleteAccessoryAmm(@PathVariable("code") String code, Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	model.addAttribute("admin",credentials.getAdmin());
		this.accessoryService.deleteAccessory(code);
		model.addAttribute("accessories", this.accessoryService.getAllAccessories());
		return "admin/show_accessories_amm";
	}
	
	@RequestMapping(value = "/admin/researchAccessory", method = RequestMethod.POST)
	public String researchAccessoryAmm(@RequestParam("param") String paramSearch, Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	model.addAttribute("admin",credentials.getAdmin());
		model.addAttribute("accessories", this.accessoryService.searchAccessories(paramSearch));
		return "admin/show_accessories_amm";
	}
}
