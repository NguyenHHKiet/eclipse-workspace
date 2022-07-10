package com.theplayer.kits.foodboys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.theplayer.kits.foodboys.service.FootBallService;
import com.theplayer.kits.foodboys.vo.Player;

//Nguyen Huu Hoang Kiet
 
@Controller
public class PlayerInsertController {
	private FootBallService serviceplayer;
	
	
	public PlayerInsertController() {
		// TODO Auto-generated constructor stub
		this.serviceplayer = new FootBallService();
	}
	
	@RequestMapping(value = "insertplayer", method = RequestMethod.POST)
	public String insertPlayer(Model model,Player player) {
		serviceplayer.insertPlayer(player); //call service
		model.addAttribute("message", "Insert successfully!");
		return "home";
	}
}
