package com.practice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.domain.SuggestedNick;
import com.practice.domain.User;
import com.practice.domain.validators.UserValidator;
import com.practice.repository.database.IUserDAO;

@Controller
@RequestMapping(value = "/user")
public class ControllerUser {

	@Autowired
	private User usuario;
	@Autowired
	@Qualifier("daoMock")	
	private IUserDAO dao;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}

	@RequestMapping( method = RequestMethod.GET)
	public ModelAndView crearUser() {
		ModelAndView model =  new ModelAndView("form-user");
		model.addObject("user", new User("",""));
		return model;
	}
	// Metodo handler que procesa el envio de datos del form
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView validateUser(@Valid User user, BindingResult result) {
		ModelAndView model = null;
		if (result.hasErrors()) {
			return  new ModelAndView("form-user");
		}

		try {
			if (dao.validateUser(user)) {
				if (dao.existsUserAsRestrictedName(user)) {
					user.setSuggestedNames(dao.getSuggestedNames(user));
					model = new ModelAndView("form-suggestednames");
					model.addObject("list", user.getSuggestedNames());
					model.addObject("name", user.getFullName());
					return model;
				}else {
					model =  new ModelAndView("form-user");
					model.addObject("message", "User Name entered have restricted words");
					return model;
				}
			}else {
				
				model =  new ModelAndView("form-user");
				model.addObject("message", "User Name is available for use");
				return model;
			}

		} catch (Exception e) {
			model =  new ModelAndView("form-user");
			model.addObject("message", "Proccessing error at webpage, Try again");
			return model;
		}

	}

	
	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public IUserDAO getDao() {
		return dao;
	}

	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}

}
