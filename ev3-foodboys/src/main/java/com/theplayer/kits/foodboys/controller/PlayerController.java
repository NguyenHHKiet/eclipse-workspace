package com.theplayer.kits.foodboys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.theplayer.kits.foodboys.service.FootBallService;
import com.theplayer.kits.foodboys.vo.Player;
import com.theplayer.kits.foodboys.vo.Team;

//author: Nam Phuong
@Controller

public class PlayerController {
	
	//Controller ~ Servlet => call Service
	@Autowired 					   
	private FootBallService service; //Tomcat find bean(là Class implements Interface FootBallService)
		
	@RequestMapping(path = {"/player/search"}, method = RequestMethod.GET)
	public String search(@RequestParam("playerName") String name,Model model) { //Lấy param từ form
		model.addAttribute("player", service.searchPlayer(name)); //return 1 Player
		return "home";
	}
	
	@RequestMapping(value="insertPlayer", method=RequestMethod.POST)
	public String insertPlayer(Model model,Player player)
	{
		service.insertPlayer(player);
		return "home";
	}
	
	@RequestMapping(value="updatePlayer", method=RequestMethod.POST)
	public String updatePlayer(Model model,Player player) {
		service.updatePlayer(player);
		return "home";
	}
	@RequestMapping(value="deleteTeam", method=RequestMethod.DELETE)
	public String deletePlayer(Model model, Player player) {
		service.deletePlayer(player);
		return "home";
	}
}
