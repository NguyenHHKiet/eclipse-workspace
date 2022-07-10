package com.theplayer.kits.foodboys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theplayer.kits.foodboys.service.FootBallService;

//author: Thinh
@Controller
public class PlayerShowController {
	@Autowired 					   
	private FootBallService service;     //Tomcat find bean(là Class implements Interface FootBallService)
	
	@RequestMapping( path = {"/player/show"} ,method = RequestMethod.GET)
	public String showPlayer(Model model) {
		model.addAttribute("playeritems", service.showPlayer());
		return "";
	}
}
