package com.br.dao;

import java.util.ArrayList;

import com.br.dto.RecipeDto;
import com.br.dto.SelectEventDto;

public interface BoardDao {
	ArrayList<RecipeDto> selectRecipeList();	//모든 레시피 목록
	
	// 이벤트 목록 
	public ArrayList<SelectEventDto> selectEvent();
}
