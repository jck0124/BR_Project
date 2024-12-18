package com.br.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.dto.GoogleOAuthTokenDto;
import com.br.dto.GoogleUserInfoDto;
import com.br.service.GoogleLoginServiceImpl;
import com.br.service.MemberServiceImpl;
import com.br.service.NaverLoginBO;
import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
public class HomeController {
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	@Autowired
	private MemberServiceImpl mSvc;
	
	/* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    // 구글 로그인
    @Autowired
    private GoogleLoginServiceImpl gSvc;
    
    // loginSuccessTemp : 매핑경로 충돌방지, 임시로 Temp 붙임
    @RequestMapping("/loginSuccessTemp")
    public String loginSuccess(HttpSession session,
    		@RequestParam("id") String loginId ) {
    	
    	session.setAttribute("loginId", loginId);
    	
    	if(mSvc.adminCheck(loginId)) {
    		// BroadSocket.adminCheck = true;
    		session.setAttribute("adminCheck", true);
    	} 
    	return "redirect:/menu_icecream";
    }
    
    // 로그인 첫 화면 요청
    @RequestMapping(value = "/loginPage", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, HttpSession session) {
        return "etc/log_in";
    }

    // 네이버 로그인
    @RequestMapping(value="/naverLogin", method = { RequestMethod.GET })
    public String naverLogin(Model model, HttpSession session) {
    	  /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO 클래스의 getAuthorizationUrl 메소드 호출 */
    	String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        return "redirect:" + naverAuthUrl;
        
    }
    
    // 네이버 로그인 성공 시 callback 호출 메소드
    @RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, 
                           @RequestParam String code, 
                           @RequestParam String state, 
                           HttpSession session) 
            throws IOException, ParseException {
    	
        OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);

        // 1. 로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken); // String 형식의 JSON 데이터
        
        // 2. String 형식인 apiResult를 JSON 형태로 바꿈
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(apiResult);
        JSONObject jsonObj = (JSONObject) obj;

        // 3. 데이터 파싱
        //최상위레벨 단계 _response 파싱
        JSONObject response_obj = (JSONObject) jsonObj.get("response");
        //response의 값 파싱
        String email = (String) response_obj.get("email");
        System.out.println("email : "+ email);
        String nickname = (String) response_obj.get("name");

        model.addAttribute("result", apiResult);
        
	    // 4. 파싱한 닉네임을 세션으로 저장, 로그인 체크 
	    // 이미 가입된 사용자가 아니면, 회원가입 진행
    	if(!mSvc.IdDuplicationCheck(email)) {
    		mSvc.signUp(email, nickname);
    	}
    	session.setAttribute("loginId", email); // 세션 생성
    	return "etc/log_in";
    }
    
    // 로그아웃
    @RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
    public String logout(HttpSession session) throws IOException {
        session.invalidate();
        return "redirect:menu_icecream";
    }
    
    // 에러 페이지로 이동
    @RequestMapping("/errorPage")
    public String error() {
    	return "etc/error";
    }
    
    // 카카오 로그인 
    @RequestMapping(value="/kakaoLogin", method=RequestMethod.GET)
    public String kakaoLogin(@RequestParam(value = "code", required = false)String code, HttpServletRequest request) {
    	String access_Token = mSvc.getAccessToken(code);
    	
    	// access_Token을 보내 사용자 정보 얻기 
    	HashMap<String, Object> userInfo = mSvc.getUserInfo(access_Token);
    	
    	// HttpSession을 이용해서 사용자 정보 저장 
    	HttpSession session = request.getSession();
    	String email = (String) userInfo.get("email");
    	String nickname = (String) userInfo.get("nickname");
    	
    	// 로그인 체크 
    	if(!mSvc.IdDuplicationCheck(email)) {
    		// 신규 회원, 회원가입 진행
    		mSvc.signUp(email, nickname);
    	}	
    	session.setAttribute("loginId", userInfo.get("email"));
    	return "redirect:/menu_icecream";
    	
    }
    
    // 구글 로그인
    @RequestMapping(value="googleLogin")
    public void googleLoginStart(HttpServletResponse response) {
    	try {
    		response.sendRedirect(gSvc.getOauthRedirectUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value="login/oauth2/code/google")
    public String googleLoginCallBack(
    		@RequestParam(value="code") String code,
    		HttpSession session
    		) {
    	
    	ResponseEntity<String> tokenResponse = gSvc.requestAccessToken(code);
    	GoogleOAuthTokenDto tokenDto = gSvc.getAccessToken(tokenResponse);
    	
    	ResponseEntity<String> userInfoResponse = gSvc.requestUserInfo(tokenDto);
    	GoogleUserInfoDto userInfoDto = gSvc.getUserInfo(userInfoResponse);
    	
    	String email = userInfoDto.getEmail();
    	
    	if(!mSvc.IdDuplicationCheck(email)) {
    		mSvc.signUp(email, "none");
    	}
    	session.setAttribute("loginId", email);
    	
    	return "redirect:/menu_icecream";
    }
    
}