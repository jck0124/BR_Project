package com.br.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.out.println("LoginId: " + session.getAttribute("loginId"));
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
	public void chatResize(
			@RequestParam(value="chatSize") String chatSize,
			HttpSession session) {
		
		if( chatSize.equals("big") ) {
			session.setAttribute("chatSize", "header_chat_hidden");
		} else {
			session.setAttribute("chatSize", null);
		}
		
	}
	
	
	// ajax 카카오 페이
	@RequestMapping("/api/payReady")
    public @ResponseBody KakaoPayReadyDto payReady(@RequestBody KakaoPayOrderFormDto kakaoPayOrder) {
        
        String name = kakaoPayOrder.getName();
        int totalPrice = kakaoPayOrder.getTotalPrice();

        KakaoPayReadyDto readyResponse = pSvc.payReady(name, totalPrice);
        // 세션에 결제 고유번호(tid) 저장
        KakaoPaySessionUtils.addAttribute("tid", readyResponse.getTid());

        return readyResponse;
    }
	
//	ajax store 필터링
	@RequestMapping("/filter/store")
	@ResponseBody
	public List<StoreDto> filteredStore(@RequestParam("storeTypeBrChecked") String storeTypeBrChecked,
			@RequestParam("storeTypeFlavor") String storeTypeFlavor,
			@RequestParam("parkingChecked") String parkingChecked,
			@RequestParam("deliveryChecked") String deliveryChecked,
			@RequestParam("pickupChecked") String pickupChecked,
			@RequestParam("hereChecked") String hereChecked,
			@RequestParam("happyStationChecked") String happyStationChecked,
			@RequestParam("blindBoxChecked") String blindBoxChecked,
			@RequestParam("sel1Selected") String sel1Selected,
			@RequestParam("sel2Selected") String sel2Selected,
			@RequestParam("storeSearched") String storeSearched, Model model) {
		
		model.addAttribute("storeTypeBrChecked", storeTypeBrChecked);
		model.addAttribute("storeTypeFlavor", storeTypeFlavor);
		model.addAttribute("parkingChecked", parkingChecked);
		model.addAttribute("deliveryChecked", deliveryChecked);
		model.addAttribute("pickupChecked", pickupChecked);
		model.addAttribute("hereChecked", hereChecked);
		model.addAttribute("happyStationChecked", happyStationChecked);
		model.addAttribute("blindBoxChecked", blindBoxChecked);
		model.addAttribute("sel1Selected", sel1Selected);
		model.addAttribute("sel2Selected", sel2Selected);
		model.addAttribute("storeSearched", storeSearched);
		
		List<StoreDto> filteredStoreList = sSvc.getFilteredStoreList(storeTypeBrChecked, storeTypeFlavor, parkingChecked, deliveryChecked, pickupChecked, hereChecked, happyStationChecked, blindBoxChecked, sel1Selected, sel2Selected, storeSearched);
		model.addAttribute("filteredStoreList", filteredStoreList);
		
		return filteredStoreList;
	}
}
