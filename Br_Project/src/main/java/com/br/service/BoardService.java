package com.br.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.br.dto.PlazaBoardDto;
import com.br.dto.PlazaPaginationDto;
import com.br.dto.RecipeDto;

public interface BoardService {
	
	// 배라광장
	PlazaPaginationDto palzaPagination(String orderType, int pageNum);
	
	// 배라광장 게시글 작성
	void insertPlazaBoard(String title, String content, String writerId, String writerName, String showName);
	
	// 배라광장 추천 버튼
	void increaseLikes(int boardIdx);
	
	
	// 레시피 리스트
	ArrayList<RecipeDto> getRecipeList();
	//레시피 insert
	void insertRecipe(int recipeIdx, int categoryIdx, String imgUrl, String titleKor, String titleEng);
	
	// 이벤트 리스트 보여주기
	Map<String,Object> selectEvent(int pageNum);
	// event insert
	void insertEvent(String imgPath, String topLetter, String title, String period);
	
}
