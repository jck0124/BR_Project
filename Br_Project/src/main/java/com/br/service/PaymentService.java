package com.br.service;

import java.util.Map;

import com.br.dto.KakaoPayApproveDto;
import com.br.dto.KakaoPayReadyDto;

public interface PaymentService {
	KakaoPayReadyDto payReady(String name, int totalPrice);
	
	KakaoPayApproveDto payApprove(String tid, String pgToken);
	
	//Map<String, Object> naverPay(Map<String, Object> param);
}
