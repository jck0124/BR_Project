package com.br.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.br.dto.PlazaBoardDto;
import com.br.dto.PlazaPaginationDto;
import com.br.dto.RecipeDto;

public interface BoardService {
	
	List<PlazaBoardDto> plazaInfiniteScroll(int pageNum);
	PlazaPaginationDto getPalzaPaginationDto(int pageNum);
	
	ArrayList<RecipeDto> getRecipeList();
	// 이벤트 리스트 보여주기
	Map<String,Object> selectEvent(int pageNum);
	// event insert
	void insertEvent(String imgPath, String topLetter, String title, String period);
	
}
