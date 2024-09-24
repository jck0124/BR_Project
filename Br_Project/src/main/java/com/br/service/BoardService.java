package com.br.service;

import java.util.ArrayList;

import com.br.dto.RecipeDto;
import com.br.dto.SelectEventDto;

public interface BoardService {
	ArrayList<RecipeDto> getRecipeList();
	// 이벤트 리스트 보여주기
	ArrayList<SelectEventDto> selectEvent();
}
