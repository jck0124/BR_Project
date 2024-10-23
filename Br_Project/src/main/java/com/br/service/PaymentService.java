package com.br.service;

import java.util.Map;

import com.br.dto.KakaoPayApproveDto;
import com.br.dto.KakaoPayReadyDto;

// 결제(카카오 페이)
public interface PaymentService {
	
	// 결제(카카오 페이)
	// 파라미터: 상품명(name) / 총 가격(totalPrice)
	KakaoPayReadyDto payReady(String name, int totalPrice);
	
	// 결제(카카오 페이) 토큰
	// 파라미터: 결제 고유번호(tid) / 결제승인 요청 인증 토큰(pgToken)
	KakaoPayApproveDto payApprove(String tid, String pgToken);
}
