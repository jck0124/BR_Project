package com.br.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.dao.MemberDao;

@ServerEndpoint("/chat") 
public class BroadSocket {
	
	@Autowired
	private MemberDao mDao;
	
	// HomeController의 loginSuccess에서 관리자 로그인 시 true
	public static boolean adminCheck = false;
	
	public static Set<Session> setClients = Collections.synchronizedSet(new HashSet<Session>());
	
	// 클라이언트로부터 메시지 도착
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("메시지 : " + message);
		System.out.println("=================================");
		synchronized (setClients) {
			for(Session client : setClients) {
				if(!client.equals(session)) {
					try {
						client.getBasicRemote().sendText(message);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	// 새로운 클라이언트가 서버로 접속
	@OnOpen
	public void onOpen(Session session) {
		setClients.add(session);
		if(adminCheck) {
			System.out.println("관리자 접속");
			System.out.println("새로운 클라이언트 : " + setClients.size() + "명");
			System.out.println("=================================");
		} else {
			System.out.println("새로운 클라이언트 : " + setClients.size() + "명");
			System.out.println("=================================");
		}
	}
	
	// 클라이언트의 접속이 끊어졌을 때
	@OnClose
	public void onClose(Session session) {
		setClients.remove(session);
		System.out.println("클라이언트 나감 : " + setClients.size() + "명");
		System.out.println("=================================");
	}
	
	
	
}
