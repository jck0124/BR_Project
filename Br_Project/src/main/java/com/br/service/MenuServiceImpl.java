package com.br.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dao.MenuDao;
import com.br.dto.DrinkDetailDto;
import com.br.dto.DrinkDetailMenuDto;
import com.br.dto.DrinkDto;
import com.br.dto.IcecreamDto;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao mDao;
	
	// 찬균
	@Override
	public ArrayList<DrinkDto> getDrinksList() {
		
		ArrayList<DrinkDto> drinkList = mDao.selectDrinksList();
		return drinkList;
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
	
}
