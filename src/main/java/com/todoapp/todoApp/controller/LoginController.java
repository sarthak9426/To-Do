package com.todoapp.todoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todoapp.todoApp.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	@RequestMapping(value= "/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap map)
	{
		//map.put("name",name);
		return "login";
	}
	
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public String showWelcomePage(ModelMap map, @RequestParam String name, @RequestParam String password)
	{
		boolean isValid = service.validateUser(name, password);
		if(!isValid)
		{
			map.put("errormsg","Invalid credentials");
			return "login";	
		}
		map.put("name",name);
		map.put("password",password);
		return "welcome";
	}
}