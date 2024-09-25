//package com.br.controller;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//	
//	@ExceptionHandler(Exception.class)
//	public String handleAllExcepton(Exception e, Model model) {
//		model.addAttribute("errorMsg", "페이지 오류 잠시 후 다시 시도해주세요");
//		return "menu/menu_drinks";
//	}
//	
//}
