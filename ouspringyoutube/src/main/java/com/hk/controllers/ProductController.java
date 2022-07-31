package com.hk.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.pojo.Product;
import com.hk.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired
    private ProductService productService;
            
    @GetMapping("/products")
    public String list(Model model) {
        model.addAttribute("product", new Product());
        
        return "products";
    }
    
    @PostMapping("/products")
    public String add(@ModelAttribute(value = "product") @Valid Product p,
            BindingResult r) {
        if (r.hasErrors()) {
            return "products";
        }
        
        if (this.productService.addProduct(p) == true)
            return "redirect:/";
        
        return "products";
    }
}
