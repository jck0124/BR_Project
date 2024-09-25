package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.service.BoardServiceImpl;

@Controller
public class BoardController {
	@Autowired
	BoardServiceImpl bSvc;
	
	// 찬균
	@RequestMapping("/br_plaza")
	public String brPlaza(Model model) {
		
		return "br_play/br_plaza";
	}
	
	@RequestMapping("/br_plaza_detail")
	public String brPlazaDetail(Model model) {
		
		return "br_play/br_plaza_detail";
	}
	
	
	//수연
	@RequestMapping("/br_recipe")
	public String brRecipe(Model model) {
		
		if(bSvc.getRecipeList() != null) {
			model.addAttribute("recipeList", bSvc.getRecipeList());
		}
		return "br_play/br_recipe";
	}
	
	//수빈
	@RequestMapping("/event")
	public String event(Model model) {
		if(bSvc.selectEvent() != null) {
			model.addAttribute("selectEvent", bSvc.selectEvent());
		}
		return "br_play/event";
	}
	
	@RequestMapping("/manager")
	public String manager() {
		return "manager/manager";
	}
}
