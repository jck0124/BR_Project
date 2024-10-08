package com.br.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat") 
public class BroadSocket {
	
	// HomeController의 loginSuccess에서 관리자 로그인 시 true
	// public static boolean adminCheck = false;
	
	public static Set<Session> setClients = Collections.synchronizedSet(new HashSet<Session>());
	
	// 클라이언트로부터 메시지 도착
	@OnMessage
	public void onMessage(String message, Session session) {
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
	}
	
	// 클라이언트의 접속이 끊어졌을 때
	@OnClose
	public void onClose(Session session) {
		setClients.remove(session);
	}
	
	
}
