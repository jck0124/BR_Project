package com.br.dao;

import java.util.ArrayList;

import com.br.dto.DrinkDetailMenuDto;
import com.br.dto.DrinkDto;
import com.br.dto.IcecreamDto;
import com.br.dto.IcecreamIngredientDto;
import com.br.dto.ShowIceCreamCakeDetailDto;
import com.br.dto.ShowIceCreamCakeDto;

public interface MenuDao {
	
	// 음료 리스트
	ArrayList<DrinkDto> selectDrinksList();
	
	// 특정 idx의 음료 정보 
	// 파라미터: 음료idx(drinksIdx)
	DrinkDto selectDrinkByIdx(int drinksIdx);
	
	// 특정 idx 음료의 옵션 리스트
	// 파라미터: 음료idx(drinksIdx)
	ArrayList<DrinkDetailMenuDto> selectDrinkDetailMenuList(int drinksIdx);
	
	// 수연
	// 아이스크림 리스트 페이지네이션
	// 파라미터: 현재 페이지(pageNum)
	ArrayList<IcecreamDto> selectIcecreamList(int pageNum);
	
	// 아이스크림 마지막 페이지 번호
	int getIcecreamLastPageNumber();
	
	// 특정 idx의 아이스크림
	// 파라미터: 아이스크림idx(icecreamIdx)
	IcecreamDto selectIcecreamDetail(int icecreamIdx); 
	
	// 특정 idx의 아이스크림 재료
	// 파라미터: 아이스크림idx(icecreamIdx)
	ArrayList<IcecreamIngredientDto> selectIngredientList(int icecreamIdx);
	
	// 수빈
	// 아이스크림케이크 리스트 페이지네이션
	// 파라미터: 현재 페이지(pageNum)
	ArrayList<ShowIceCreamCakeDto> showIceCreamCake(int pageNum);
	
	// 아이스크림케이크 마지막 페이지 번호
	int getLastPageNumber();
	
	// 특정 idx의 아이스크림케이크
	// 파라미터: 아이스크림케이크idx(cakeIdx)
	ShowIceCreamCakeDetailDto showIceCreamCakeDetail(int cakeIdx);
	
}
