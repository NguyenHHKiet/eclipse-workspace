package com.theplayer.kits.foodboys.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theplayer.kits.foodboys.service.FootBallService;
import com.theplayer.kits.foodboys.vo.Matches;
//author: Kiet
@Controller
public class MatchInsertController {
	private FootBallService servicematch;
	
	
	public MatchInsertController() {
		// TODO Auto-generated constructor stub
		this.servicematch = new FootBallService();
	}
	
	@RequestMapping(value = "insertmatch", method = RequestMethod.POST)
	public String insertMatch(Model model,Matches match) {
		servicematch.insertMatches(match); //call service
		model.addAttribute("message", "Insert successfully!");
		return "home";
	}
}
