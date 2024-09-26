package com.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	//수빈
	@RequestMapping("/loginPage")
	public String login() {
		return "etc/log_in";
	}
	
	@RequestMapping("/errorPage")
	public String error() {
		return "etc/error";
	}
	
}
