package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.service.WebSocketServiceImpl;

@Controller
public class WebSocketController {
	
	@Autowired
	WebSocketServiceImpl wSvc;
	
	@RequestMapping("/chat")
	public void sendRealTimeMessage() {
		
	}
	
}
