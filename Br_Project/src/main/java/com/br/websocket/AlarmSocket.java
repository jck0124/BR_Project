package com.br.websocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.br.dto.AlarmMessageDto;
import com.google.gson.Gson;


@ServerEndpoint("/alarm")
public class AlarmSocket {
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
