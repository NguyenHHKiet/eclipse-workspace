package com.theplayer.kits.foodboys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theplayer.kits.foodboys.service.FootBallService;
import com.theplayer.kits.foodboys.vo.Matches;
//author: Long
@Controller
public class MatchesController {

	private FootBallService ser;
	public MatchesController() {
		// TODO Auto-generated constructor stub
		ser = new FootBallService();
	}
	@RequestMapping(value = "insertmatches", method = RequestMethod.POST)
	public String insert(Model model, Matches matches) {
		ser.insertMatches(matches);
		return "home";
	}
	
	
	@RequestMapping(value="updatematches", method = RequestMethod.POST)
	public String update(Model model,Matches matches) {
		ser.updateMatches(matches);
		return "home";
	}
	
	
}
