package com.br.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.simple.JSONObject;  // json_simple 라이브러리 import
import org.json.simple.parser.JSONParser;  // JSONParser import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberDao mDao;
	
	private NaverLoginBO naverLoginBO;
	
	// 로그인(네이버)
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	// 로그인(카카오) 토큰 발급
	// 파라미터 : 인증 코드(authorize_code)
    public String getAccessToken(String authorize_code) {
       
    	String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";
        
        try {
            URL url = new URL(reqURL);
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            
            // POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=179c8429a668f25b23f83e8fd29c90c5"); // 본인이 발급받은 key
            sb.append("&redirect_uri=http://119.205.221.216:9090/BR_Project/kakaoLogin"); // 본인이 설정한 주소
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();
            
            // 결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);
            
            // 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder result = new StringBuilder();  // StringBuilder 사용
            
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            System.out.println("response body : " + result.toString());
            
            // json_simple 라이브러리를 사용하여 JSON 파싱
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result.toString());
            
            access_Token = (String) jsonObject.get("access_token");
            refresh_Token = (String) jsonObject.get("refresh_token");
            
            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);
            
            br.close();
            bw.close();
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        
        return access_Token;
    }
    
    // 로그인(카카오) 카카오 사용자 정보 받아오기
    // 파라미터: 허용 토큰(access_Token)
    public HashMap<String, Object> getUserInfo(String access_Token) {
    	
        // 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            System.out.println("response body : " + result);

            JSONParser parser = new JSONParser();
            JSONObject element = (JSONObject) parser.parse(result.toString());

            JSONObject properties = (JSONObject) element.get("properties");
            JSONObject kakao_account = (JSONObject) element.get("kakao_account");

            String nickname = (String) properties.get("nickname");
            String email = (String) kakao_account.get("email");

            userInfo.put("nickname", nickname);
            userInfo.put("email", email);

        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        
        return userInfo;
    }
    
    // 회원 있는지 확인
    // 파라미터: 이메일(email)
    public boolean IdDuplicationCheck(String email) {
    	
    	String loginId = mDao.IdDuplicationCheck(email);
    	
    	return loginId != null; // 로그인 ID가 존재하면 true 반환
    }
    
    // 회원가입 메서드
    // 파라미터: 이메일(email), 별명(nickname)
    public void signUp(String email, String nickname) {
    	mDao.SignUp(email, nickname);
    }
    
    // 관리자 여부 체크
    // 파라미터: 아이디(id)
    @Override
    public boolean adminCheck(String id) {
    	return mDao.adminCheck(id);
    }
    
}
