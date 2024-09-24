package com.br.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.dto.DrinkDetailDto;
import com.br.service.BoardServiceImpl;
import com.br.service.MenuServiceImpl;
import com.br.service.StoreServiceImpl;


@Controller
public class HomeController {
	//수빈
	@RequestMapping("/login")
	public String login() {
		return "etc/log_in";
	}
}
