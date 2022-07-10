package com.theplayer.kits.foodboys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.theplayer.kits.foodboys.service.FootBallService;
import com.theplayer.kits.foodboys.vo.Player;

//author: Hung
@Controller
public class FileController {
	@Autowired
	private FootBallService service;

	@RequestMapping(path = {"insertImages"}, method = RequestMethod.POST)
	protected String upload(
			@RequestParam("profileImage") MultipartFile file,
			Model model) {
		Player player = new Player();
		player = service.findPlayer("Tran Duc Bo");
		service.ImagesPlayer(file, player);
		player = service.findPlayer("Tran Duc Bo");
		String imgUrl = player.getPlayer_image();
		System.out.println("/images/"+imgUrl);
		model.addAttribute("url", "/images/"+imgUrl);
		return "upImages";
	}

}
