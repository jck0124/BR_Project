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
import com.fasterxml.jackson.core.JsonParser;
import com.nimbusds.jose.shaded.json.parser.ParseException;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberDao mDao;
	
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
            sb.append("&redirect_uri=http://localhost:9090/www/kakaoLogin"); // 본인이 설정한 주소
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
    
    // 로그인 체크 메서드 
    public boolean loginCheck(String email) {
    	String loginId = mDao.login(email);
    	return loginId != null; // 로그인 ID가 존재하면 true 반환
    }
    
    // 회원가입 메서드
    public void signUp(String email, String nickname) {
    	mDao.SignUp(email, nickname);
    }
    
    // 관리자 여부 체크
    @Override
    public boolean adminCheck(String id) {
    	return mDao.adminCheck(id);
    }
    
}
