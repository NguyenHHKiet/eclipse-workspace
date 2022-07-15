package com.hk.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author HoangKiet
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model,
			@RequestParam(value="kw", defaultValue = "") String kw) {
		List<String> categories = new ArrayList<String>();
		categories.add("Mobile");
		categories.add("Table");
		categories.add("Desktop");
		
		List<String> products = new ArrayList<String>();
		products.add("iPhone 7 Plus");
		products.add("iPhone X");
		products.add("iPhone 12 Pro");
		products.add("Galaxy Tab S8");
		
		model.addAttribute( "categories" ,categories);
		
		if (kw != null) {
			model.addAttribute( "products" ,products.stream().filter(p -> 
				p.contains(kw)).collect(Collectors.toList()));
		}else {
			model.addAttribute( "products" ,products);
		}
		
		return "index";
	}
}
