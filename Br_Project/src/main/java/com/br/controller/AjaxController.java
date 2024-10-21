package com.br.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.dao.MemberDaoImpl;
import com.br.dto.KakaoPayOrderFormDto;
import com.br.dto.KakaoPayReadyDto;
import com.br.dto.PlazaBoardDto;
import com.br.dto.StoreDto;
import com.br.service.BoardServiceImpl;
import com.br.service.PaymentServiceImpl;
import com.br.service.StoreServiceImpl;
import com.br.util.KakaoPaySessionUtils;
import com.nimbusds.jose.shaded.json.JSONArray;

@RestController
public class AjaxController {
	
	@Autowired
	BoardServiceImpl bSvc;
	
	// MemberServiceImpl로 변경 필요
	@Autowired
	MemberDaoImpl mDao;
	
	@Autowired
	PaymentServiceImpl pSvc;
	
	@Autowired
	StoreServiceImpl	sSvc;
	// 배라광장 무한스크롤
	@RequestMapping(value = "/api/plaza", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PlazaBoardDto> getPlazaBoardList(
			@RequestParam(value = "orderType", required = false, defaultValue = "latest") String orderType,
			@RequestParam("pageNum") int pageNum ) {
		
		return bSvc.palzaPagination(orderType, pageNum).getBoardList(); 
	}
	
	// 이벤트 무한스크롤 
	@RequestMapping(value="/api/event" , produces = "application/json") 
	@ResponseBody
	public JSONArray event(int pageNum) {
	    System.out.println("event 요청이 들어옴");
	    System.out.println(pageNum);
	    
	    return bSvc.selectEvent(pageNum);
	}
	
	// 배라광장 추천버튼
	@RequestMapping("/api/increaseLikes")
	public boolean increaseLikes(@RequestParam("boardIdx") int boardIdx) {
		
		bSvc.increaseLikes(boardIdx);
		
		return true;
	}
	
	// ajax 로그인 상태 체크
	@RequestMapping("/api/checkLoginStatus")
	@ResponseBody
	public boolean checkLoginStatus(HttpSession session) {
		return session.getAttribute("loginId") != null;
	}
	
	// ajax 로그인 체크 
	@RequestMapping("/api/loginCheck")
	public boolean loginCheck(
			@RequestParam("loginId") String loginId,
			@RequestParam("loginPw") String loginPw) {
		
		return mDao.loginCheck(loginId, loginPw);
	}
	
	// 채팅창 크게, 작게 저장
	@RequestMapping("/api/chatSize")
	public boolean chatResize(
			@RequestParam(value="chatSize") String chatSize,
			HttpSession session) {
		
		if( chatSize.equals("big") ) {
			session.setAttribute("chatSize", "header_chat_hidden");
		} else {
			session.setAttribute("chatSize", null);
		}
		
		return true;
	}
	
	// ajax 카카오 페이
	// 파라미터: KakaoPayOrderFormDto 객체 - 상품명(name) / 최종 가격(totalPrice)
	@RequestMapping("/api/payReady")
    public @ResponseBody KakaoPayReadyDto payReady(@RequestBody KakaoPayOrderFormDto kakaoPayOrder) {
        String name = kakaoPayOrder.getName();
        int totalPrice = kakaoPayOrder.getTotalPrice();

        KakaoPayReadyDto readyResponse = pSvc.payReady(name, totalPrice);
        // 세션에 결제 고유번호(tid) 저장
        KakaoPaySessionUtils.addAttribute("tid", readyResponse.getTid());

        return readyResponse;
    }
	
	//	ajax 매장 필터링
	// 파라미터: HashMap<String, Object> hmap - 매장 타입(storeTypeBrChecked) / 매장 타입(storeTypeFlavor) / 주차(parkingChecked) / 배달(deliveryChecked) / 픽업(pickupChecked) 
	// 취식여부(hereChecked) / 해피스테이션(happyStationChecked) / 가챠머신(blindBoxChecked) / 도/시(sel1Selected) / 구/군(sel2Selected) / 매장명(storeSearched)
	@ResponseBody
	@RequestMapping(value="/filter/store", method = RequestMethod.POST)
	public HashMap<String, Object> filteredStore(@RequestBody HashMap<String, Object> hmap) {
//		System.out.println(hmap);
		Boolean storeTypeBrChecked = (Boolean) hmap.get("storeTypeBrChecked");
		Boolean storeTypeFlavor = (Boolean) hmap.get("storeTypeFlavor");
		Boolean parkingChecked = (Boolean) hmap.get("parkingChecked");
		Boolean deliveryChecked = (Boolean) hmap.get("deliveryChecked");
		Boolean pickupChecked = (Boolean) hmap.get("pickupChecked");
		Boolean hereChecked = (Boolean) hmap.get("hereChecked");
		Boolean happyStationChecked = (Boolean) hmap.get("happyStationChecked");
		Boolean blindBoxChecked = (Boolean) hmap.get("blindBoxChecked");
		String sel1Selected = hmap.get("sel1Selected") != null && !hmap.get("sel1Selected").toString().trim().isEmpty() ? hmap.get("sel1Selected").toString() : null;
		String sel2Selected = hmap.get("sel2Selected") != null && !hmap.get("sel2Selected").toString().trim().isEmpty() ? hmap.get("sel2Selected").toString() : null;
		String storeSearched = hmap.get("storeSearched") != null ? hmap.get("storeSearched").toString() : null;
		
		HashMap<String, Object> response = new HashMap<>();
		ArrayList<StoreDto> filteredStoreList = sSvc.getFilteredStoreList(storeTypeBrChecked, storeTypeFlavor, parkingChecked, deliveryChecked, pickupChecked, hereChecked, happyStationChecked, blindBoxChecked, sel1Selected, sel2Selected, storeSearched);
		
		response.put("filteredStoreList", filteredStoreList);
		
		return response;
	}
	
}
