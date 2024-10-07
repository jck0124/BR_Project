package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String payment() {
    	
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
//        log.info("결제승인 요청을 인증하는 토큰: " + pgToken);
//        log.info("결제 고유번호: " + tid);

        // 카카오 결제 요청하기
        KakaoPayApproveDto approveResponse = pSvc.payApprove(tid, pgToken);

        return "redirect:/icecream";
    }
}
