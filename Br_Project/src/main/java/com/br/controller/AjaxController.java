package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.dto.PlazaBoardDto;
import com.br.service.BoardServiceImpl;

@RestController
public class AjaxController {
	
	@Autowired
	BoardServiceImpl bSvc;
	
	@RequestMapping(value = "/api/plaza", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PlazaBoardDto> getPlazaBoardList(
			@RequestParam("pageNum") int pageNum ) {
		
		return bSvc.plazaInfiniteScroll(pageNum); 
	}
	
}
