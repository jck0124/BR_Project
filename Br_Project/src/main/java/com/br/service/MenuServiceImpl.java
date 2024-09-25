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
	@Override
	public ArrayList<IcecreamDto> getIcecreamList() {
		
		ArrayList<IcecreamDto> icecreamList = new ArrayList<IcecreamDto>();
		icecreamList = mDao.selectIcecreamList();
		
		return icecreamList;
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
