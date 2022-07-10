package com.theplayer.kits.foodboys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.theplayer.kits.foodboys.dao.UserDAO;
import com.theplayer.kits.foodboys.service.FootBallService;
import com.theplayer.kits.foodboys.vo.User;
//author: Thinh
@Controller
public class AccountController {
	//private UserDAO userdao;
	private FootBallService ser;
	public AccountController() {
		// TODO Auto-generated constructor stub
		ser = new FootBallService();
	}
	
	@RequestMapping(value="Login", method = RequestMethod.POST)
	public String Login(Model model,@RequestParam("username") String username, @RequestParam("password") String password) {
		String loginStatus = "false";
		int role = 1;
		if(ser.login(username, password)!=null){
			loginStatus  = "true";
			role = ser.login(username, password).getRole();
		}
		model.addAttribute("loginStatus",loginStatus);
		model.addAttribute("role",role);
		return "home";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String Register(Model model,User user, @RequestParam("username") String username)
	{
		if(ser.findUser(username) == null) {
			ser.insertUser(user);
		}
		else {
			System.out.println("Fail");
		}
		
		return "home";
	}
	
}
