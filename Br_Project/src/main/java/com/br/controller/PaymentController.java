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
//    		System.out.println("menuInfoList: "+ menuInfoList.toString());
    	}
    	return "etc/payment";
    }
    
//private final KakaoPayService kakaoPayService;
//    @PostMapping("/pay/ready")
//    public @ResponseBody KakaoPayReadyDto payReady(@RequestBody KakaoPayOrderFormDto kakaoPayOrder) {
//        
//        String name = kakaoPayOrder.getName();
//        int totalPrice = kakaoPayOrder.getTotalPrice();
//        
////        log.info("주문 상품 이름: " + name);
////        log.info("주문 금액: " + totalPrice);
//
//        // 카카오 결제 준비하기
//        KakaoPayReadyDto readyResponse = ps.payReady(name, totalPrice);
//        // 세션에 결제 고유번호(tid) 저장
//        KakaoPaySessionUtils.addAttribute("tid", readyResponse.getTid());
////        log.info("결제 고유번호: " + readyResponse.getTid());
//
//        return readyResponse;
//    }

    @GetMapping("/pay/completed")
    public String payCompleted(@RequestParam("pg_token") String pgToken) {
        String tid = KakaoPaySessionUtils.getStringAttributeValue("tid");

        // 카카오 결제 요청
        KakaoPayApproveDto approveResponse = pSvc.payApprove(tid, pgToken);

        return "redirect:/icecream";
    }
    
    
}
