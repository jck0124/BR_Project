package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.dto.DrinkDetailDto;
import com.br.service.MenuServiceImpl;


@Controller
public class HomeController {
	
	@Autowired
	MenuServiceImpl mSvc;
	
	
	
	@RequestMapping("/menu_drinks")
	public String menuDrinks(Model model) {
		
		model.addAttribute("drinksList", mSvc.getDrinksList());
		return "menu/menu_drinks";
		
	}
	
	
	
	@RequestMapping("/menu_drinks_detail")
	public String menuDrinksDetail(
				@RequestParam("drinksIdx") Integer drinksIdx, Model model) {
		
		DrinkDetailDto dto = mSvc.getDrinkDetail(drinksIdx);
		model.addAttribute("drinkDto", dto.getDto());
		model.addAttribute("drinkDetailMenuList", dto.getDetailMenuList());
		
		return "menu/drinks_detail";
	}
	
	
	
	
	
	@RequestMapping("/menu_ice_cream_cake")
	public String menuIceCreamCake() {
		
		return "menu/menu_ice_cream_cake";
	}
	
	@RequestMapping("/br_play_plaza")
	public String brPlayPlaza() {
		
		return "br_play/br_play_plaza";
	}
	
	
	
	
}
