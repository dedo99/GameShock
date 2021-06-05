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

import it.uniroma3.siw.spring.controller.validator.AccessoryValidator;
import it.uniroma3.siw.spring.model.Accessory;
import it.uniroma3.siw.spring.service.AccessoryService;

@Controller
public class AccessoryController {
	
	@Autowired
	private AccessoryService accessoryService;
	
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
		model.addAttribute("accessory", this.accessoryService.getSingleAccessory(code));
		return "details_accessory";
	}
	
	/*************
	 *** ADMIN ***
	 *************/
	
	@RequestMapping(value = "/admin/insertAccessory", method = RequestMethod.GET)
	public String showInsertAccessoryAmm(Model model) {
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
    	return "admin/insert_accessory_amm";
    }
	
	@RequestMapping(value = "/admin/showDeleteAccessoriesAmm", method = RequestMethod.GET)
	public String showAccessoriesAmm(Model model) {
		model.addAttribute("accessories", this.accessoryService.getAllAccessories());
		return "admin/show_accessories_amm";
	}
	
	@RequestMapping(value = "/admin/deleteAccessoryAmm/{code}", method = RequestMethod.GET)
	public String deleteAccessoryAmm(@PathVariable("code") String code, Model model) {
		this.accessoryService.deleteAccessory(code);
		return "admin/show_accessories_amm";
	}
	
//	@RequestMapping(value = "/admin/ricercaAccessorio", method = RequestMethod.POST)
//	public String cercaVideogameAmm(@RequestParam("param") String paramSearch, Model model) {
//		model.addAttribute("accessori", this.accessoryService.searchAccessories(paramSearch));
//		return "admin/vedi_accessorio_amm";
//	}
}
