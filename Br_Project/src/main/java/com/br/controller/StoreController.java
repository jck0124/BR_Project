package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.service.StoreServiceImpl;

@Controller
public class StoreController {
	@Autowired
	StoreServiceImpl sSvc;
	
	//수연
	@RequestMapping("/store_map")
	public String store(Model model) {
		
		if(sSvc.getStoreList() != null) {
			model.addAttribute("storeList", sSvc.getStoreList());
		}
		return "delivery_store/store_map";
	}
}
