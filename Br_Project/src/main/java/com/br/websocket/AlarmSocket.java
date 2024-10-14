package com.br.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/alarm")
public class AlarmSocket {
	// session = 연결 상태, synchronizedSet = 동기화된 set, set = 중복x, 순서x
	// client 가 올 때 마다 setClients 가 증가한다. 
	public static Set<Session> setClients = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnMessage // 클라이언트로부터 메시지가 도착했을 때 
	public void onMessage(String message, Session session) {
		synchronized(setClients) {
			for(Session client:setClients) {
				if(!client.equals(session)) {
					try {
						client.getBasicRemote().sendText(message);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	// 밑에 두개는 안 나올 것 같음
	@OnOpen // 새로운 클라이언트(session)가 서버로 접속했을 때
	public void onOpen(Session session) {
		setClients.add(session);
	}
	
	@OnClose // 클라인트(session)의 접속이 끊어졌을 때
	public void onClose(Session session) {
		setClients.remove(session);
	}
}
