package com.br.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSocketServiceImpl implements WebSocketService {
	
	public static Set<Session> setClients = Collections.synchronizedSet(new HashSet<Session>());
	
	
	// 클라이언트로부터 메시지 도착
	@Override
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("메시지 : " + message);
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
	@Override
	@OnOpen
	public void onOpen(Session session) {
		setClients.add(session);
		System.out.println("새로운 클라이언트 : " + setClients.size() + "명");
	}
	
	// 클라이언트의 접속이 끊어졌을 때
	@Override
	@OnClose
	public void onClose(Session session) {
		setClients.remove(session);
		System.out.println("클라이언트 나감 : " + setClients.size() + "명");
	}
	
	
}
