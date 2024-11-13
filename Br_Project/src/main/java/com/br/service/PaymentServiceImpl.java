package com.br.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.dto.KakaoPayApproveDto;
import com.br.dto.KakaoPayReadyDto;

@Service 
public class PaymentServiceImpl implements PaymentService {
	// 결제(카카오페이) 결제창
	// 파라미터: 상품명(name) / 상품 총액(totalPrice)
	@Override
    public KakaoPayReadyDto payReady(String name, int totalPrice) {
    
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");                                    // 가맹점 코드(테스트용)
        parameters.put("partner_order_id", "1234567890");                       // 주문번호
        parameters.put("partner_user_id", "roommake");                          // 회원 아이디
        parameters.put("item_name", name);                                      // 상품명
        parameters.put("quantity", "1");                                        // 상품 수량
        parameters.put("total_amount", String.valueOf(totalPrice));             // 상품 총액
        parameters.put("tax_free_amount", "0");                                 // 상품 비과세 금액
        parameters.put("approval_url", "http://119.205.221.216:9090/BR_Project/pay/completed"); // 결제 성공 시 URL
        parameters.put("cancel_url", "http://119.205.221.216:9090/BR_Project/pay/cancel");      // 결제 취소 시 URL
        parameters.put("fail_url", "http://119.205.221.216:9090/BR_Project/pay/fail");          // 결제 실패 시 URL

        // HttpEntity : HTTP 요청 또는 응답에 해당하는 Http Header와 Http Body를 포함하는 클래스
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // RestTemplate
        // : Rest 방식 API를 호출할 수 있는 Spring 내장 클래스
        //   REST API 호출 이후 응답을 받을 때까지 기다리는 동기 방식 (json, xml 응답)
        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";
        // RestTemplate의 postForEntity : POST 요청을 보내고 ResponseEntity로 결과를 반환받는 메소드
        ResponseEntity<KakaoPayReadyDto> responseEntity = template.postForEntity(url, requestEntity, KakaoPayReadyDto.class);
//        log.info("결제준비 응답객체: " + responseEntity.getBody());

        return responseEntity.getBody();
    }

    // 결제(카카오페이) 승인
	// 파라미터: 결제 고유번호(tid) / 결제승인 요청 인증 토큰(pgToken)
    // 사용자가 결제 수단을 선택하고 비밀번호를 입력해 결제 인증을 완료한 뒤,
    // 최종적으로 결제 완료 처리를 하는 단계
	@Override
    public KakaoPayApproveDto payApprove(String tid, String pgToken) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");              // 가맹점 코드(테스트용)
        parameters.put("tid", tid);                       // 결제 고유번호
        parameters.put("partner_order_id", "1234567890"); // 주문번호
        parameters.put("partner_user_id", "roommake");    // 회원 아이디
        parameters.put("pg_token", pgToken);              // 결제승인 요청을 인증하는 토큰

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";
        KakaoPayApproveDto approveResponse = template.postForObject(url, requestEntity, KakaoPayApproveDto.class);
//        log.info("결제승인 응답객체: " + approveResponse);

        return approveResponse;
    }
    
    // 결제(카카오페이) 측에 요청 시 헤더부에 필요한 값
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "DEV_SECRET_KEY DEVE24EFC6EF4E21C4B9847ABD71C2673EC9BD51");
        headers.set("Content-type", "application/json");

        return headers;
    }

}
