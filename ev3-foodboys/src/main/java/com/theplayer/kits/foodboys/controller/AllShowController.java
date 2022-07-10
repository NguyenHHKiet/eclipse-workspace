package com.theplayer.kits.foodboys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theplayer.kits.foodboys.service.FootBallService;
//author: Kiet
@Controller
public class AllShowController {
	@Autowired 					   
	private FootBallService service;     //Tomcat find bean(là Class implements Interface FootBallService)
	
	@RequestMapping(method = RequestMethod.GET)
	public String show(Model model) { 
		System.out.println("all controller!!");
		model.addAttribute("players", service.showTeam());
		model.addAttribute("playeritems", service.showPlayer());
		model.addAttribute("matches", service.showMatches());
		return "home";
	}
}
