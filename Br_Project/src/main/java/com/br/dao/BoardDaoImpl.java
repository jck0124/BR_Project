package com.br.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.br.dto.PlazaBoardDto;
import com.br.dto.PlazaDetailDto;
import com.br.dto.RecipeDto;
import com.br.dto.RecipeImgDto;
import com.br.dto.SelectEventDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SqlSession sqlSession;
	
	// 찬균
	// 게시판(배라광장) 리스트 최신순
	@Override
	public ArrayList<PlazaBoardDto> selectPlazaBoardListOrderByLatest() {
		List<PlazaBoardDto> plazaBoardList = sqlSession.selectList("BoardMapper.selectPlazaBoardList");
		
		return new ArrayList<PlazaBoardDto>(plazaBoardList);
	}
	
	// 게시판(배라광장) 리스트 추천순 
	@Override
	public ArrayList<PlazaBoardDto> selectPlazaBoardListOrderByLikes() {
		List<PlazaBoardDto> plazaBoardList = sqlSession.selectList("selectPlazaBoardListOrderByLikes");
		
		return new ArrayList<PlazaBoardDto>(plazaBoardList);
	}
	
	// 게시판(배라광장) 게시글 작성
	// 파라미터: 제목(title) / 내용(content) / 작성자 아이디(writerId) / 작성자 이름(writerName) / 이름(showName)
	@Override
	public void insertPlaza(String title, String content, String writerId, String writerName, char showName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("title", title);
		paramMap.put("content", content);
		paramMap.put("writerId", writerId);
		paramMap.put("writerName", writerName);
		paramMap.put("showName", showName);
		
		sqlSession.insert("BoardMapper.insertPlaza", paramMap);
	}
	
	// 게시판(배라광장) 게시글 추천
	// 파라미터: 게시글 idx(boardIdx)
	@Override
	public void updatePlazaLikes(int boardIdx) {
		sqlSession.update("BoardMapper.updatePlazaLikes", boardIdx);
	}
	
	// 게시판(배라광장) 
	// 파라미터: 게시글 idx(boardIdx)
	@Override
	public PlazaDetailDto selectPlazaDtoByBoardIdx(int boardIdx) {
		return sqlSession.selectOne("BoardMapper.selectPlazaDetailDtoByBoardIdx", boardIdx);
	}
	
	
	// 수연
	// 게시판(레시피) 리스트
	@Override
	public ArrayList<RecipeDto> selectRecipeList() {
		List<RecipeDto> recipeListTemp = sqlSession.selectList("BoardMapper.getAllRecipe");
		ArrayList<RecipeDto> recipeList = new ArrayList<RecipeDto>();
		
		recipeList.addAll(recipeListTemp);
		
		return recipeList;
	}
	
	// 게시판(신규) 레시피 idx
	@Override
	public int selectRecipeIdx() {
		int recipeIdx = sqlSession.selectOne("BoardMapper.selectRecipeIdx");
		
		return recipeIdx;
	}

	// 게시판(레시피) 등록
	// 파라미터: 레시피 idx(recipeIdx) / 카테고리 idx(categoryIdx) / 이미지 URL(imgUrl) / 타이틀(한글)(titleKor) / 타이틀(영어)(titleEng)
	@Override
	public void insertRecipe(int recipeIdx, int categoryIdx, String imgUrl, String titleKor, String titleEng) {
		
		int InsertRecipeIdx = selectRecipeIdx();
		
		System.out.println("recipeIdx"+ InsertRecipeIdx);
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("insertRecipeIdx", InsertRecipeIdx);
		hmap.put("categoryIdx", categoryIdx);
		hmap.put("imgUrl", imgUrl);
		hmap.put("titleKor", titleKor);
		hmap.put("titleEng", titleEng);
		
		sqlSession.insert("BoardMapper.insertRecipeInfo", hmap);
	}
	
	// 게시판(레시피) 이미지
	// 파라미터: 레시피 idx(recipeIdx)
	@Override
	public RecipeImgDto selectRecipeImg(int recipeIdx) {
		return sqlSession.selectOne("BoardMapper.imgFile", recipeIdx);
	}
	
	//수빈

	// event 게시판 보여주기
	@Override
	public ArrayList<SelectEventDto> selectEvent(int pageNum) {
		int endNum = pageNum * 5;
		int startNum = endNum -4;
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("endNum", endNum);
		hmap.put("startNum", startNum);
		
		List<SelectEventDto> eventsTemp = sqlSession.selectList("BoardMapper.selectEvent", hmap);
		ArrayList<SelectEventDto> events = new ArrayList<SelectEventDto>();
		events.addAll(eventsTemp);
		return events;
	}
	
	// event 페이지네이션
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
