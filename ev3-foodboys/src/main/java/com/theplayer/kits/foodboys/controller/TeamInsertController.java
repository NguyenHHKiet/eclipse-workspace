package com.theplayer.kits.foodboys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theplayer.kits.foodboys.service.FootBallService;
import com.theplayer.kits.foodboys.vo.Team;
// author: Thinh
@Controller
public class TeamInsertController {
	private FootBallService serviceteam;
	
	
	public TeamInsertController() {
		// TODO Auto-generated constructor stub
		this.serviceteam = new FootBallService();
	}
	
	@RequestMapping(value = "insertteam", method = RequestMethod.POST)
	public String insertTeam(Model model, @ModelAttribute Team team) {
		serviceteam.insertTeam(team); //call service
		model.addAttribute("message", "Insert successfully!");
		return "home";
	}
}
