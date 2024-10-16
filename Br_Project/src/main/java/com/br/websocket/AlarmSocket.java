package com.br.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import com.br.dto.AlarmMessageDto;
import com.google.gson.Gson;


@ServerEndpoint("/alarm")
public class AlarmSocket {
	/* 원래 코드
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
	*/
	
	private static List<Session> sessionList = new ArrayList<Session>();
	
	@OnOpen
	public void handleOpen(Session session) {
		sessionList.add(session);
		checkSessionList();
		clearSessionList();
	}
	
	@OnMessage
	public void handleMessage(String msg, Session session) {
		System.out.println(msg);
		
		Gson gson = new Gson();
		
		AlarmMessageDto message = gson.fromJson(msg, AlarmMessageDto.class);
		
		if(message.getCode().equals("1")) {
			for (Session s : sessionList) {
				if(s != session) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else if (message.getCode().equals("2")) {
			sessionList.remove(session);
			for (Session s : sessionList) {
				try {
					s.getBasicRemote().sendText(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if(message.getCode().equals("3")) {
			// 보낸 사람 제외 
			for (Session s : sessionList) {
				if(s!= session) {
					try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
		
	}
	
	// 접속자를 확인하는 메서드 
	private void checkSessionList() {
		System.out.println();
		System.out.println("[Session List]");
		for (Session session : sessionList) {
			System.out.println(session.getId());
		} 
		System.out.println();
	}
	
	// 연결이 끊어진 session은 세션리스트에서 제거 
	private void clearSessionList() {
		Iterator<Session> iter = sessionList.iterator();
		
		while(iter.hasNext()) {
			if(!(iter.next()).isOpen()) {
				iter.remove();
			}
		}
	}
}
