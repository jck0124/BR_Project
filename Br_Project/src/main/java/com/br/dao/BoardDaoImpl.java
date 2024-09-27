package com.br.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.br.dto.PlazaBoardDto;
import com.br.dto.RecipeDto;
import com.br.dto.SelectEventDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SqlSession sqlSession;
	
	// 찬균
	@Override
	public ArrayList<PlazaBoardDto> selectPlazaBoardList() {
		List<PlazaBoardDto> plazaBoardList = sqlSession.selectList("BoardMapper.selectPlazaBoardList");
		return new ArrayList<PlazaBoardDto>(plazaBoardList);
	}
	
	
	
	// 수연
	@Override
	public ArrayList<RecipeDto> selectRecipeList() {
		
		List<RecipeDto> recipeListTemp = sqlSession.selectList("BoardMapper.getAllRecipe");
		ArrayList<RecipeDto> recipeList = new ArrayList<RecipeDto>();
		recipeList.addAll(recipeListTemp);
		
		return recipeList;
	}
	
	
	//수빈
	
	// event 게시판 보여주기
	@Override
	public ArrayList<SelectEventDto> selectEvent(int pageNum) {
		int endNum = pageNum * 4;
		int startNum = endNum -3;
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("endNum", endNum);
		hmap.put("startNum", startNum);
		
		List<SelectEventDto> eventsTemp = sqlSession.selectList("BoardMapper.selectEvent", hmap);
		ArrayList<SelectEventDto> events = new ArrayList<SelectEventDto>();
		events.addAll(eventsTemp);
		return events;
	}
	
	// evnet 페이지네이션
	@Override
	public int getLastPageNumber() {
		int countRet = sqlSession.selectOne("BoardMapper.selectLastPageNumber");
		return countRet/4 + (countRet%4>0 ? 1 : 0);
	}

	// event insert
	@Override
	public void insertEvent(String img, String topLetter, String title, String period) {
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("img", img);
		hmap.put("topLetter", topLetter);
		hmap.put("title", title);
		hmap.put("period", period);
		
		sqlSession.insert("BoardMapper.insertEvent", hmap);
		
	}
	
}
