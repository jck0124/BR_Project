package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.dto.DrinkDetailDto;
import com.br.service.BoardServiceImpl;
import com.br.service.MenuServiceImpl;
import com.br.service.StoreServiceImpl;


@Controller
public class HomeController {
	
	@Autowired
	MenuServiceImpl mSvc;
	
	@Autowired
	BoardServiceImpl bSvc;
	
	@Autowired
	StoreServiceImpl sSvc;
	
	//찬균
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
	
	//수연
	@RequestMapping(value={"/", "/menu_icecream"})
	public String home(Model model) {
		
		if(mSvc.getIcecreamList() != null) {
			model.addAttribute("icecreamList", mSvc.getIcecreamList());
		}
		return "menu/menu_icecream";
	}

	@RequestMapping("/br_recipe")
	public String brRecipe(Model model) {
		
		if(bSvc.getRecipeList() != null) {
			model.addAttribute("recipeList", bSvc.getRecipeList());
		}
		return "br_play/br_recipe";
	}
	
	@RequestMapping("/store_map")
	public String store(Model model) {
		
		if(sSvc.getStoreList() != null) {
			model.addAttribute("storeList", sSvc.getStoreList());
		}
		return "delivery_store/store_map";
	}
	
	//수빈
}
