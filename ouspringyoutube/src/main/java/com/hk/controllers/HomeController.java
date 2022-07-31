package com.hk.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hk.service.CategoryService;
import com.hk.service.ProductService;

@Controller
@ControllerAdvice
public class HomeController {

	@Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
    @ModelAttribute
    public void commonAttr(Model model) {
         model.addAttribute("categories", this.categoryService.getCategories());
    } 
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("products", this.productService.getProducts(params, page));
        model.addAttribute("productCounter", this.productService.countProduct());
        
        return "index";
    }
	
	@RequestMapping("/greet")
    public ModelAndView showview()
    {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("result",
                     "GeeksForGeeks Welcomes "
                         + "you to Spring!");
        return mv;
    }
}
