package com.br.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dao.MenuDao;
import com.br.dto.DrinkDetailDto;
import com.br.dto.DrinkDetailMenuDto;
import com.br.dto.DrinkDto;
import com.br.dto.DrinkPaginationDto;
import com.br.dto.IcecreamDto;
import com.br.dto.IcecreamIngredientDto;
import com.br.dto.ShowIceCreamCakeDetailDto;
import com.br.dto.ShowIceCreamCakeDto;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao mDao;
	
	// 찬균
	@Override
	public DrinkPaginationDto getPaginationDrinksList(int pageNum) {
		
		int totalPageNum = 1;
		ArrayList<DrinkDto> drinkList = mDao.selectDrinksList();
		
		if( drinkList.size()%10 != 0) {
			totalPageNum = drinkList.size()/10 + 1;
		} else {
			totalPageNum = drinkList.size()/10;
		}
		
		ArrayList<DrinkDto> paginationDrinkList = new ArrayList<DrinkDto>();
		
		
		if(pageNum != totalPageNum) {
			for(int i = (pageNum - 1)*10; i <= (pageNum*10 - 1); i++) {
				paginationDrinkList.add( drinkList.get(i) );
			}
		} else {
			for(int i = (pageNum - 1)*10; i < drinkList.size(); i++) {
				paginationDrinkList.add( drinkList.get(i) );
			}
		}
		
		DrinkPaginationDto dDto = new DrinkPaginationDto();
		dDto.setTotalPageNum(totalPageNum);
		dDto.setDrinkList(paginationDrinkList);
		
		return dDto;
	}
	
	@Override
	public DrinkDetailDto getDrinkDetail(int drinksIDx) {
		
		DrinkDto dDto = mDao.selectDrinkByIdx(drinksIDx);
		ArrayList<DrinkDetailMenuDto> drinkDetailMenuList = mDao.selectDrinkDetailMenuList(drinksIDx);

		return new DrinkDetailDto(dDto, drinkDetailMenuList);
	}
	
	// 수연
	// 아이스크림 리스트
	@Override
	public Map<String, Object> getIcecreamList(int pageNum) {
		
		ArrayList<IcecreamDto> icecreamList = new ArrayList<IcecreamDto>();
		icecreamList = mDao.selectIcecreamList(pageNum);
		
		
		int startNum,  endNum;
		int lastPageNum;
	    
	    lastPageNum = mDao.getIcecreamLastPageNumber();
	    System.out.println("lastPageNum: "+ lastPageNum);
	    endNum = (pageNum/5 + 1)*5 - (pageNum%5==0 ? 5 : 0);

	 	if(endNum > lastPageNum)
	 		endNum = lastPageNum;
	 	startNum = endNum - 4;
	 	System.out.println("startNum: " + startNum);
	 	
	 	Map<String, Object> list = new HashMap<>();
	 	list.put("icecreamList", icecreamList);
	 	list.put("startNum", startNum);
	 	list.put("endNum", endNum);
	 	list.put("lastPageNum", lastPageNum);
	 	
		return list;
	}
	
	// 아이스크림 라스트 페이지 넘버
	
	// 아이스크림 상세페이지
		@Override
		public IcecreamDto getIcecreamDetail(int icecreamIdx) {
			IcecreamDto icecreamDetail = new IcecreamDto();
			icecreamDetail = mDao.selectIcecreamDetail(icecreamIdx);
			
			return icecreamDetail;
		}
		
	// 아이스크림 재료
		@Override
		public ArrayList<IcecreamIngredientDto> getIngredient(int icecreamIdx) {
			ArrayList<IcecreamIngredientDto> ingredientList = new ArrayList<IcecreamIngredientDto>();
			ingredientList = mDao.selectIngredientList(icecreamIdx);
			
			return ingredientList;
		}
	
	// 수빈
	@Override
	public Map<String, Object> showIceCreamCake(int pageNum) {
		ArrayList<ShowIceCreamCakeDto> cakesList = mDao.showIceCreamCake(pageNum);
		
		int startNum,endNum;
		int lastPageNum;
		lastPageNum = mDao.getLastPageNumber();
		endNum = (pageNum/5+1)*5 - (pageNum%5==0 ? 5 : 0);
		if(endNum > lastPageNum) {
			endNum = lastPageNum;
		}
		startNum = endNum -4;
		
		Map<String, Object> result = new HashMap<>();
		result.put("cakesList", cakesList);
		result.put("startNum", startNum);
		result.put("endNum", endNum);
		result.put("lastPageNum", lastPageNum);
		return result;
	}
	
	// 아이스크림 케이크 상세정보
	@Override
	public ShowIceCreamCakeDetailDto showIceCreamCakeDetail(String korName) {
		ShowIceCreamCakeDetailDto cakeDetail = new ShowIceCreamCakeDetailDto();
		cakeDetail = mDao.showIceCreamCakeDetail(korName);
		return cakeDetail;
	}

}
