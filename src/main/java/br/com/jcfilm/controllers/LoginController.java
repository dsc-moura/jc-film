package br.com.jcfilm.controllers;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController{
	
	@RequestMapping(value="/index", method=RequestMethod.GET)	
	public ModelAndView loginForm() throws SQLException{	
		ModelAndView modelAndView = new ModelAndView("index");		
		return modelAndView;		
	}
}
