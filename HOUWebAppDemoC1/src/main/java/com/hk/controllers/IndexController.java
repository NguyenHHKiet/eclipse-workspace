package com.hk.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.services.CategoryService;
import com.hk.services.ProductService;

/**
 * @author HoangKiet
 *
 */
@Controller
public class IndexController {

	@Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
	@RequestMapping("/")
	public String index(Model model,
			@RequestParam(value="kw", defaultValue = "") String kw,@RequestParam Map<String, String> params) {
		
		model.addAttribute("categories", this.categoryService.getCategories());
	       
        model.addAttribute("products", this.productService.getProducts(params, 0));
		
//		List<String> categories = new ArrayList<String>();
//		categories.add("Mobile");
//		categories.add("Table");
//		categories.add("Desktop");
//		
//		List<String> products = new ArrayList<String>();
//		products.add("iPhone 7 Plus");
//		products.add("iPhone X");
//		products.add("iPhone 12 Pro");
//		products.add("Galaxy Tab S8");
//		
//		model.addAttribute( "categories" ,categories);
//		
//		if (kw != null) {
//			model.addAttribute( "products" ,products.stream().filter(p -> 
//				p.contains(kw)).collect(Collectors.toList()));
//		}else {
//			model.addAttribute( "products" ,products);
//		}
		
		return "index";
	}
}
