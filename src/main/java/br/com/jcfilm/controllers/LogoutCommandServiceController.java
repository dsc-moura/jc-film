package br.com.jcfilm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutCommandServiceController{
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:index";
	}

}
