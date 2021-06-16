package it.uniroma3.siw.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Videogame;
import it.uniroma3.siw.spring.service.VideogameService;

@Component
public class VideogameValidator implements Validator{
	
	@Autowired
	private VideogameService videogameService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Videogame.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Videogame videogame = (Videogame) target;
		Float rating = videogame.getRating();
		ValidationUtils.rejectIfEmpty(errors, "code", "required");
		ValidationUtils.rejectIfEmpty(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "rating", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPrice", "required");
		ValidationUtils.rejectIfEmpty(errors, "usedPrice", "required");
		ValidationUtils.rejectIfEmpty(errors, "releaseDate", "required");
		ValidationUtils.rejectIfEmpty(errors, "genre", "required");
		ValidationUtils.rejectIfEmpty(errors, "pegi", "required");
		ValidationUtils.rejectIfEmpty(errors, "publisher", "required");
		ValidationUtils.rejectIfEmpty(errors, "platform", "required");
		
		
		if(!errors.hasErrors()) {
			if(this.videogameService.alreadyExistsVideogame(videogame)) {
				errors.reject("videogameDuplicato");
			}
			if(rating > 10 || rating < 0) {
				errors.reject("ratingNonValido");
			}
		}
		
	}
	
	

}
