package it.uniroma3.siw.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Accessory;
import it.uniroma3.siw.spring.service.AccessoryService;

@Component
public class AccessoryValidator implements Validator{
	
	@Autowired
	private AccessoryService accessoryService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Accessory.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Accessory accessory = (Accessory) target;
		Float rating = accessory.getRating();
		ValidationUtils.rejectIfEmpty(errors, "code", "required.accessorio.code");
		ValidationUtils.rejectIfEmpty(errors, "name", "required.accessorio.name");
		ValidationUtils.rejectIfEmpty(errors, "rating", "required.accessorio.rating");
		ValidationUtils.rejectIfEmpty(errors, "newPrice", "required.accessorio.newPrice");
		ValidationUtils.rejectIfEmpty(errors, "usedPrice", "required.accessorio.usedPrice");
		ValidationUtils.rejectIfEmpty(errors, "color", "required.accessorio.color");
		ValidationUtils.rejectIfEmpty(errors, "category", "required.accessorio.category");
		ValidationUtils.rejectIfEmpty(errors, "platform", "required.accessorio.platform");
		
		
		if(!errors.hasErrors()) {
			if(this.accessoryService.alreadyExistsAccessory(accessory)) {
				errors.reject("accessorioDuplicato");
			}
			if(rating > 10 || rating < 0) {
				errors.reject("ratingNonValido");
			}
		}
		
	}

}
