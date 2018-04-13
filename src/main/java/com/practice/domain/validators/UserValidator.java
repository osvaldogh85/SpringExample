package com.practice.domain.validators;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.practice.domain.User;


public class UserValidator implements Validator{


	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
				"required.nombre", "nombre es requerido");	
	}
	
}