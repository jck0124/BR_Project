package com.br.service;

import com.br.dto.KakaoPayApproveDto;
import com.br.dto.KakaoPayReadyDto;

public interface PaymentService {
	KakaoPayReadyDto payReady(String name, int totalPrice);
	
	KakaoPayApproveDto payApprove(String tid, String pgToken);
}
