package com.theplayer.kits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theplayer.kits.deprecated.Thay;

@Controller
public class HomeController {
	private final Thay thay;
	
	@Autowired
	public HomeController(Thay thay) {
		this.thay = thay;
	}
	
	@RequestMapping(path = {"/"}, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("title", "<strong>KITS</strong>");
		model.addAttribute("thay", thay);
		return "home";// /WEB-INF/views/ home .jsp
	}
}
