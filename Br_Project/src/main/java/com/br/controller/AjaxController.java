package com.br.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.dto.PlazaBoardDto;
import com.br.service.BoardServiceImpl;

@RestController
public class AjaxController {
	
	@Autowired
	BoardServiceImpl bSvc;
	
	// 배라광장 무한스크롤
	@RequestMapping(value = "/api/plaza", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PlazaBoardDto> getPlazaBoardList(
			@RequestParam(value = "orderType", required = false, defaultValue = "latest") String orderType,
			@RequestParam("pageNum") int pageNum ) {
		
		return bSvc.palzaPagination(orderType, pageNum).getBoardList(); 
	}
	
	// 배라광장 추천버튼
	@RequestMapping("/api/increaseLikes")
	public boolean increaseLikes(@RequestParam("boardIdx") int boardIdx) {
		
		bSvc.increaseLikes(boardIdx);
		return true;
	}
	
	// ajax 로그인 체크
	@RequestMapping("/api/loginCheck")
	public boolean loginCheck(HttpSession session) {
		
		// 임시 로그인 
		// session.setAttribute("loginId", "test123");
		return session.getAttribute("loginId") != null;
	}
	
	
}
