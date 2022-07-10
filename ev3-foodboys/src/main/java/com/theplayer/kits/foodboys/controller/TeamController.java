package com.theplayer.kits.foodboys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.theplayer.kits.foodboys.service.FootBallService;
import com.theplayer.kits.foodboys.vo.Team;

// author: Hung
@Controller
public class TeamController {

	//Controller ~ Servlet => call Service
	// hoan thanh show toan bo cua bang ma minh muon
	//  Team Controller la chinh
	@Autowired 					   
	private FootBallService service;     //Tomcat find bean(là Class implements Interface FootBallService)
	@RequestMapping(path = {"/team/show"}, method = RequestMethod.GET)
	public String show(Model model) { 
		System.out.println("all controller!!");
		model.addAttribute("players", service.showTeam());
		model.addAttribute("playeritems", service.showPlayer());
		model.addAttribute("matches", service.showMatches());
		
		return "home";
	}
	
	@RequestMapping(value="insertTeam", method=RequestMethod.POST)
	public String insertTeam(Model model,Team team)
	{
		service.insertTeam(team);
		return "home";
	}
	
	@RequestMapping(value="updateTeam", method=RequestMethod.POST)
	public String updateTeam(Model model,Team team) {
		service.updateTeam(team);
		return "home";
	}
	@RequestMapping(value="deleteTeam", method=RequestMethod.POST)
	public String deleteTeam(Model model, Team team) {
		service.deleteTeam(team);
		return "home";
	}
}

