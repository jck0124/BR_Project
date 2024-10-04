package com.br.controller;

//추가
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.service.MemberService;
import com.br.service.NaverLoginBO;
import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
public class HomeController {
	
	/* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;

    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }
    
 // 로그인 첫 화면 요청 메소드
    @RequestMapping(value = "/loginPage", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, HttpSession session) {
        /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO 클래스의 getAuthorizationUrl 메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&		
        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
        //System.out.println("네이버:" + naverAuthUrl);
        //System.out.println("로그인 첫 화면 요청 메서드");
        // 네이버 로그인 URL을 모델에 추가
        model.addAttribute("url", naverAuthUrl);
        
        return "etc/log_in";
    }

    // 네이버 로그인 성공 시 callback 호출 메소드
    @RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, 
                           @RequestParam String code, 
                           @RequestParam String state, 
                           HttpSession session) 
            throws IOException, ParseException {
    	
        System.out.println("여기는 callback");
        OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);

        // 1. 로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken); // String 형식의 JSON 데이터

        /** apiResult json 구조		
          {"resultcode":"00",		 
          "message":"success",		 
          "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
 		**/
        
        // 2. String 형식인 apiResult를 JSON 형태로 바꿈
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(apiResult);
        JSONObject jsonObj = (JSONObject) obj;

        // 3. 데이터 파싱
        //Top레벨 단계 _response 파싱
        JSONObject response_obj = (JSONObject) jsonObj.get("response");
        //response의 nickname값 파싱
        String nickname = (String) response_obj.get("nickname");
        System.out.println(nickname);

        // 4. 파싱한 닉네임을 세션으로 저장
        session.setAttribute("sessionId", nickname); // 세션 생성
        model.addAttribute("result", apiResult);

        return "c";
    }
    // 로그아웃
    @RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
    public String logout(HttpSession session) throws IOException {
        System.out.println("logout");
        session.invalidate();
        return "redirect:menu_icecream";
    }
    
    @RequestMapping("/errorPage")
    public String error() {
    	return "etc/error";
    }
    
    @Autowired
    private MemberService ms;
    // 카카오 로그인 
    @RequestMapping(value="/kakaoLogin", method=RequestMethod.GET)
    public String kakaoLogin(@RequestParam(value = "code", required = false)String code, HttpServletRequest request) {
    	String access_Token = ms.getAccessToken(code);
    	System.out.println("#########" + code);
    	
    	// access_Token을 보내 사용자 정보 얻기 
    	HashMap<String, Object> userInfo = ms.getUserInfo(access_Token);
    	System.out.println("###access_Token#### : " + access_Token);
    	System.out.println("###nickname#### : " + userInfo.get("nickname"));
    	System.out.println("###email#### : " + userInfo.get("email"));
    	
    	// HttpSession을 이용해서 사용자 정보 저장 
    	HttpSession session = request.getSession();
    	String email = (String) userInfo.get("email");
    	String nickname = (String) userInfo.get("nickname");
    	
    	// 로그인 체크 
    	if(ms.loginCheck(email)) {
    		// 이미 가입된 사용자 
    		session.setAttribute("loginId", userInfo.get("nickname"));
    		return "etc/log_in";
    	} else {
    		// 신규 회원, 회원가입 진행
    		ms.signUp(email, nickname);
    		session.setAttribute("loginId", userInfo.get("nickname"));
    		return "etc/log_in";
    	}
    }
}
	

