package com.br.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dao.BoardDao;
import com.br.dto.RecipeDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao bDao;
	
	@Override
	public ArrayList<RecipeDto> getRecipeList() {
		ArrayList<RecipeDto> recipeList = new ArrayList<RecipeDto>();
		
		// 메서드 실행시 트랜잭션 관리
		recipeList = bDao.selectRecipeList();
		
		return recipeList;
	}

}
