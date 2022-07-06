package com.theplayer.kits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.theplayer.kits.service.FileService;

@Controller
public class FileController {

	@Autowired
	private FileService fservice;
	
	@PostMapping("/f/upload")
	protected String upload(
			@RequestParam("profileImage") MultipartFile file, Model model) {
		String imgUrl = fservice.store(file);
		model.addAttribute("url", "/images/upload/" + imgUrl);
//		return "redirect:/";
		return "home";
	}
}
