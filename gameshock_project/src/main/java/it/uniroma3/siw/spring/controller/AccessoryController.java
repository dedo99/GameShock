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
	
	@RequestMapping(value = "/admin/showDeleteAccessorioAmm", method = RequestMethod.GET)
	public String visualizzaAccessoriAmm(Model model) {
		model.addAttribute("accessori", this.accessoryService.getAllAccessories());
		return "admin/vedi_accessorio_amm";
	}
	
	
	@RequestMapping(value = "/admin/ricercaAccessorio", method = RequestMethod.POST)
	public String cercaVideogameAmm(@RequestParam("param") String paramSearch, Model model) {
		model.addAttribute("accessori", this.accessoryService.searchAccessories(paramSearch));
		return "admin/vedi_accessorio_amm";
	}
	
	
	@RequestMapping(value = "/admin/deleteAccessorioAmm/{code}", method = RequestMethod.GET)
	public String cancellaAccessorioAmm(@PathVariable("code") String code, Model model) {
		this.accessoryService.deleteAccessory(code);
		return "admin/vedi_accessorio_amm";
	}
	
	
	@RequestMapping(value = "/admin/insertAccessorio", method = RequestMethod.GET)
	public String visualizzaInserisciAccessorioAmm(Model model) {
		model.addAttribute("accessorio", new Accessory());
		return "admin/inserisci_accessorio_amm";
	}
	
	
	@RequestMapping(value = "/admin/addAccessorio", method = RequestMethod.POST)
    public String saveAccessory(@RequestParam("file") MultipartFile file,
    		@ModelAttribute("accessorio") Accessory accessorio,
    		Model model,
    		BindingResult bindingResult)
    {
		this.accessoryValidator.validate(accessorio, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.accessoryService.saveAccessoryToDB(file, accessorio);
			model.addAttribute("accessorio", new Accessory());
		}
    	return "admin/inserisci_accessorio_amm";
    }


}
