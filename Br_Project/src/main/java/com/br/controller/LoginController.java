package com.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	
	// 로그인 페이지
	@RequestMapping("/login")
	public String googleLoginPage() {
		
		return "etc/login";
	}
	
	// 로그인 요청
	@RequestMapping("/google_login")
	public String googleLogin() {
		
		// String clientId= "604086868209-1fjupjltvc4s2rvl7ob3ehii9gotmsrl.apps.googleusercontent.com";
		String reqUrl = "https://accounts.google.com/o/oauth2/v2/auth?client_id=604086868209-1fjupjltvc4s2rvl7ob3ehii9gotmsrl.apps.googleusercontent.com&redirect_uri=http://localhost:9090/login/oauth2/code/google&response_type=code&scope=email";
		
		return "redirect:" + reqUrl;
	}

	// 로그인 여부
	// @RequestMapping("/login/oauth2/code/google")
	@RequestMapping("/login_reusult")
	public String loginTry(String error) {
	    return "etc/login_success"; // 로그인 성공
	    // return "etc/login_fail"; // 로그인 실패
	}
	
	
}
