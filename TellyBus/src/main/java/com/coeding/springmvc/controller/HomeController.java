package com.coeding.springmvc.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coeding.springmvc.config.ApplicationProperty;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String showHome(Locale locale) {
		logger.info("Welcome HomeController! The client locale is {}.", locale);
		logger.info("Welcome HomeController! The client locale is {}.", ApplicationProperty.userName);
		logger.info("Welcome HomeController! The client locale is {}.", ApplicationProperty.userEmail);
		return "home";
	}	
}
