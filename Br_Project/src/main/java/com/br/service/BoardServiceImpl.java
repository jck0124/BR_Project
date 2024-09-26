package com.br.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dao.BoardDao;
import com.br.dto.RecipeDto;
import com.br.dto.SelectEventDto;

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
	
	// event 게시판 보여주기
	@Override
	public Map<String,Object> selectEvent(int pageNum) {
		// 무한스크롤
//			System.out.println(pageNum);
//			
		ArrayList<SelectEventDto> selectEvent = new ArrayList<SelectEventDto>();
		selectEvent = bDao.selectEvent(pageNum);
//			
//			JSONArray array = new JSONArray();
//			for(SelectEventDto dto : selectEvent) {
//				JSONObject obj = new JSONObject();
//				obj.put("img", dto.getImg());
//				obj.put("topLetter", dto.getTopLetter());
//				obj.put("title", dto.getTitle());
//				obj.put("period", dto.getPeriod());
//				array.add(obj);
//			}
//			response.setContentType("application/json; charset=utf-8");
//			
		
		// 페이지 네이션
		int startNum, endNum;
		int lastPageNum = bDao.getLastPageNumber();
		endNum = (pageNum/5+1)*5 - (pageNum%5==0 ? 5 : 0);
		if(endNum > lastPageNum) {
			endNum = lastPageNum;
		}
		startNum = endNum -4;
		
		Map<String,Object> result = new HashMap<>();
		result.put("selectEvent", selectEvent);
		result.put("startNum", startNum);
		result.put("endNum", endNum);
		result.put("lastPageNum", lastPageNum);
		
		return result;
	}
	
	  public void createEvent(String type, String title, String period, String imagePath) {
	        Map<String, Object> eventInfo = new HashMap<>();
	        eventInfo.put("type", type);
	        eventInfo.put("title", title);
	        eventInfo.put("period", period);
	        eventInfo.put("imagePath", imagePath);
	
	        // Mapper를 통해 이벤트 정보 삽입
	        //eventMapper.insertEvent(eventInfo);
	    }

}
