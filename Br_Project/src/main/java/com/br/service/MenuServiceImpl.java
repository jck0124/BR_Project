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
	// 특정 페이지 번호의 음료 페이지(페이지네이션)
	// 파라미터: 현재 페이지(pageNum)
	@Override
	public DrinkPaginationDto getPaginationDrinksList(int pageNum) {
		
		// 전체 페이지 수
		int totalPageNum = 1;
		// 음료 리스트 
		ArrayList<DrinkDto> drinkList = mDao.selectDrinksList();
		// 특정 페이지의 음료 리스트
		ArrayList<DrinkDto> paginationDrinkList = new ArrayList<DrinkDto>();
		
		if( drinkList.size()%10 != 0) {
			totalPageNum = drinkList.size()/10 + 1;
		} else {
			totalPageNum = drinkList.size()/10;
		}
		
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
	
	// 특정 idx의 음료 상세 페이지
	// 파라미터: 음료idx(drinksIdx)
	@Override
	public DrinkDetailDto getDrinkDetail(int drinksIdx) {
		
		DrinkDto dDto = mDao.selectDrinkByIdx(drinksIdx);
		ArrayList<DrinkDetailMenuDto> drinkDetailMenuList = mDao.selectDrinkDetailMenuList(drinksIdx);

		return new DrinkDetailDto(dDto, drinkDetailMenuList);
	}
	
	// 수연
	// 특정 페이지 번호의 아이스크림 페이지(페이지네이션)
	// 파라미터: 현재 페이지(pageNum)
	@Override
	public Map<String, Object> getIcecreamList(int pageNum) {
		
		ArrayList<IcecreamDto> icecreamList = new ArrayList<IcecreamDto>();
		icecreamList = mDao.selectIcecreamList(pageNum);
		
		int startNum,  endNum;
		int lastPageNum;
	    
	    lastPageNum = mDao.getIcecreamLastPageNumber();
	    endNum = (pageNum/5 + 1)*5 - (pageNum%5==0 ? 5 : 0);

	 	if(endNum > lastPageNum)
	 		endNum = lastPageNum;
	 	startNum = endNum - 4;
	 	
	 	Map<String, Object> list = new HashMap<>();
	 	list.put("icecreamList", icecreamList);
	 	list.put("startNum", startNum);
	 	list.put("endNum", endNum);
	 	list.put("lastPageNum", lastPageNum);
	 	
		return list;
	}
	
	// 특정 idx의 아이스크림 상세 페이지
	// 파라미터: 아이스크림idx(icecreamIdx)
	@Override
	public IcecreamDto getIcecreamDetail(int icecreamIdx) {
		
		IcecreamDto icecreamDetail = new IcecreamDto();
		icecreamDetail = mDao.selectIcecreamDetail(icecreamIdx);
		
		return icecreamDetail;
	}
		
	// 특정 idx의 아이스크림 재료
	// 파라미터: 아이스크림idx(icecreamIdx)
	@Override
	public ArrayList<IcecreamIngredientDto> getIngredient(int icecreamIdx) {
		
		ArrayList<IcecreamIngredientDto> ingredientList = new ArrayList<IcecreamIngredientDto>();
		ingredientList = mDao.selectIngredientList(icecreamIdx);
		
		return ingredientList;
	}
	
	// 수빈
	// 특정 페이지 번호의 아이스크림케이크 페이지(페이지네이션)
	// 파라미터: 현재 페이지(pageNum)
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
	
	// 특정 idx의 아이스크림케이크 상세 페이지
	// 변경 필요
	// 파라미터: 
	@Override
	public ShowIceCreamCakeDetailDto showIceCreamCakeDetail(int cakeIdx) {
		
		ShowIceCreamCakeDetailDto cakeDetail = new ShowIceCreamCakeDetailDto();
		cakeDetail = mDao.showIceCreamCakeDetail(cakeIdx);
		
		return cakeDetail;
	}

}
