package com.br.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.service.MenuServiceImpl;
import com.br.service.StoreServiceImpl;

@Controller
public class StoreController {
	
	@Autowired
	StoreServiceImpl sSvc;
	
	//수연
	// 매장 목록 및 상세 정보
	@RequestMapping("/store_map")
	public String store(Model model) {
		if(sSvc.getStoreList() != null && sSvc.getStore() != null) {
			model.addAttribute("storeList", sSvc.getStoreList());
			model.addAttribute("selectStore", sSvc.getStore());
		}
		
		return "delivery_store/store_map";
	}
	
	// 주문 list 
	@RequestMapping("/order_list")
	public String orderList(Model model, String storeName) {
		Map<String, Object> products = sSvc.getProducts();
		model.addAttribute("products", products);
		model.addAttribute("storeName", storeName);
		
		return "delivery_store/order_list";
	}
	
}
