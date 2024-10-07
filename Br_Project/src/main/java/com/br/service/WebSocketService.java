package com.br.service;

import javax.websocket.Session;

public interface WebSocketService {
	
	// 클라이언트로부터 메시지 도착
	public void onMessage(String message, Session session);
	
	// 새로운 클라이언트가 서버로 접속
	public void onOpen(Session session);
	
	// 클라이언트의 접속이 끊어졌을 때
	public void onClose(Session session);
	
	
}
