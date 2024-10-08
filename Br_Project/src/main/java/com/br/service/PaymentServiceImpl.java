package com.br.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.dto.KakaoPayApproveDto;
import com.br.dto.KakaoPayReadyDto;
import com.nimbusds.jose.shaded.json.JSONObject;

@Service 
public class PaymentServiceImpl implements PaymentService {
	 // 카카오페이 결제창 연결
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
        parameters.put("approval_url", "http://localhost/order/pay/completed"); // 결제 성공 시 URL
        parameters.put("cancel_url", "http://localhost/order/pay/cancel");      // 결제 취소 시 URL
        parameters.put("fail_url", "http://localhost/order/pay/fail");          // 결제 실패 시 URL

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

    // 카카오페이 결제 승인
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
    
    // 카카오페이 측에 요청 시 헤더부에 필요한 값
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "DEV_SECRET_KEY DEVE24EFC6EF4E21C4B9847ABD71C2673EC9BD51");
        headers.set("Content-type", "application/json");

        return headers;
    }
    
    
//    // 네이버 페이
//    private final String partnerId = "np_dhjmo727289";
//    private final String clientId = "HN3GGCMDdTgGUfl0kFCo";
//	private final String secret = "ftZjkkRNMR";
//	
//	
//    @Override
//    public Map<String, Object> naverPay(Map<String, Object> params) {
//    	
//    	
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-Naver-Client-Id", clientId);
//        headers.set("X-Naver-Client-Secret", secret);
//        headers.set("Content-Type", "application/json");
//
//        Map<String, Object> payParams = new HashMap<>();
//        payParams.put("merchanPayKey", params.get("merchanPayKey"));  // 실 데이터를 사용
//        payParams.put("merchanUserKey", params.get("merchanUserKey"));  // 실 데이터를 사용
//        payParams.put("productName", params.get("productName"));
//        payParams.put("totalPayAmount", params.get("totalPayAmount"));
//        payParams.put("returnUrl", "https://your-return-url.com");  // 리턴 url 추가
//
//        // JSON 객체로 변환
//        JSONObject jObj = new JSONObject(payParams); 
//
//        // 네이버페이 결제 준비 api 요청 
//        HttpEntity<?> request = new HttpEntity<>(jObj.toString(), headers);
//
//        RestTemplate template = new RestTemplate();
//        String url = "https://dev.apis.naver.com/"+partnerId+"/naverpay/payments/v2/reserve";
//
//        // 요청 결과
//        Map<String, Object> res = template.postForObject(url, request, Map.class);
//        return res;
//    }

}
