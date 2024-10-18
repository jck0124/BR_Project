package com.br.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.dto.DrinkDetailDto;
import com.br.dto.DrinkPaginationDto;
import com.br.service.MenuServiceImpl;

@Controller
public class MenuController {
	@Autowired
	MenuServiceImpl mSvc;
	
	//찬균
	@RequestMapping("/menu_drinks")
	public String menuDrinks(
				@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, 
				Model model) {
		
		DrinkPaginationDto dDto = mSvc.getPaginationDrinksList(pageNum);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("drinksList", dDto.getDrinkList());
		model.addAttribute("totalPageNum", dDto.getTotalPageNum());
		
		return "menu/menu_drinks";	
		
	}
	
	@RequestMapping("/menu_drinks_detail")
	public String menuDrinksDetail(
				@RequestParam("drinksIdx") Integer drinksIdx, 
				Model model) {
		
		DrinkDetailDto dto = mSvc.getDrinkDetail(drinksIdx);
		model.addAttribute("drinkDto", dto.getDto());
		model.addAttribute("drinkDetailMenuList", dto.getDetailMenuList());
		
		return "menu/drinks_detail";
	}
	
	//수연
	@RequestMapping(value={"/", "/menu_icecream"})
	public String home(HttpServletRequest request, Model model) {
		int pageNum = 1;//현재페이지 (초기값: 1)
		try {
			pageNum = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) { } 
		
		Map<String, Object> list = mSvc.getIcecreamList(pageNum);
		if(list != null) {
			model.addAttribute("icecreamList", list.get("icecreamList"));
			model.addAttribute("startNum", list.get("startNum"));
			model.addAttribute("endNum", list.get("endNum"));
			model.addAttribute("lastPageNum", list.get("lastPageNum"));
		}
		return "menu/menu_icecream";
	}
	
	@RequestMapping("/icecream_detail")
	public String icecreamDtail(int icecreamIdx, Model model) {
//		IcecreamDto dto = mSvc.getIcecreamDetail(icecreamIdx);
		model.addAttribute("icecreamIdx", icecreamIdx);
		if(mSvc.getIcecreamDetail(icecreamIdx) != null) {
			model.addAttribute("icecreamDetail", mSvc.getIcecreamDetail(icecreamIdx));
			model.addAttribute("ingredientList", mSvc.getIngredient(icecreamIdx));
		}
		return "menu/icecream_detail";
				
	}
	
	//수빈
	@RequestMapping("/menu_ice_cream_cake")
	public String menu_ice_cream_cake(HttpServletRequest request, Model model) {
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) { }
		
		Map<String, Object> result = mSvc.showIceCreamCake(pageNum);
		
		if(result != null) {
			model.addAttribute("cakesList", result.get("cakesList"));
			model.addAttribute("startNum", result.get("startNum"));
			model.addAttribute("endNum", result.get("endNum"));
			model.addAttribute("lastPageNum", result.get("lastPageNum"));
		}
		return "menu/menu_ice_cream_cake";
	}

	@RequestMapping("/ice_cream_cake_detail")
	public String menu_ice_cream_cake_detail(String korName, Model model) {
		model.addAttribute("korName", korName);
		if(mSvc.showIceCreamCakeDetail(korName)  != null) {
			model.addAttribute("cakeDetail", mSvc.showIceCreamCakeDetail(korName));
		}
		return "menu/ice_cream_cake_detail";
	}

	
	
	
}
