package com.br.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.dto.KakaoPayApproveDto;
import com.br.service.PaymentServiceImpl;
import com.br.util.KakaoPaySessionUtils;

@Controller
public class PaymentController {
	
	@Autowired
	private PaymentServiceImpl pSvc;
    
    // 결제 페이지
    @RequestMapping("/payment")
    public String payment(@RequestParam("totalPrice") Integer totalPrice
    		, @RequestParam("products") String products, Model model) {
    	
    	model.addAttribute("totalPrice", totalPrice);
    	if(products != null) {
    		String[] product = products.split(",");
    		List<Map<String, String>> menuInfoList = new ArrayList<>();
    		
    		for(String menu : product) {
    			String[] menuInfo = menu.split("/");
    				Map<String, String> menuDetails = new HashMap<String, String>();
    				menuDetails.put("name", menuInfo[0].trim());
    				menuDetails.put("count", menuInfo[1].trim());
    				menuDetails.put("price", menuInfo[2].trim());
    				menuInfoList.add(menuDetails);
    		}
    		model.addAttribute("menuInfoList", menuInfoList);
    		// System.out.println("menuInfoList: "+ menuInfoList.toString());
    	}
    	
    	return "etc/payment";
    }
    
    // 결제 성공
    @GetMapping("/pay/completed")
    public String payCompleted(@RequestParam("pg_token") String pgToken) {
        String tid = KakaoPaySessionUtils.getStringAttributeValue("tid");

        // 카카오 결제 요청
        KakaoPayApproveDto approveResponse = pSvc.payApprove(tid, pgToken);

        return "redirect:http://119.205.221.216:9090/BR_Project/menu_icecream";
    }
    
}
