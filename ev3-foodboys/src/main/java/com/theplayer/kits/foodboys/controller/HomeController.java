package com.theplayer.kits.foodboys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//author: Long
@Controller
public class HomeController {
	
	@Autowired
	public HomeController() {
	}
	
	@RequestMapping(path = {"/"}, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("title", "<strong>KITS</strong>");
		model.addAttribute("thay", model);
		return "home";// /WEB-INF/views/ home .jsp
	}
}
