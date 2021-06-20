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
		ValidationUtils.rejectIfEmpty(errors, "code", "required.videogame.code");
		ValidationUtils.rejectIfEmpty(errors, "name", "required.videogame.name");
		ValidationUtils.rejectIfEmpty(errors, "rating", "required.videogame.rating");
		ValidationUtils.rejectIfEmpty(errors, "newPrice", "required.videogame.newPrice");
		ValidationUtils.rejectIfEmpty(errors, "usedPrice", "required.videogame.usedPrice");
		ValidationUtils.rejectIfEmpty(errors, "releaseDate", "required.videogame.releaseDate");
		ValidationUtils.rejectIfEmpty(errors, "genre", "required.videogame.genre");
		ValidationUtils.rejectIfEmpty(errors, "pegi", "required.videogame.pegi");
		ValidationUtils.rejectIfEmpty(errors, "publisher", "required.videogame.publisher");
		ValidationUtils.rejectIfEmpty(errors, "platform", "required.videogame.platform");
		
		
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
