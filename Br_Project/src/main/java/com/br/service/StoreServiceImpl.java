package com.br.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.dao.StoreDao;
import com.br.dto.DrinkDto;
import com.br.dto.IcecreamDto;
import com.br.dto.SelectStoreDto;
import com.br.dto.ShowIceCreamCakeDto;
import com.br.dto.StoreDto;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreDao sDao;
	
	@Override
	public ArrayList<StoreDto> getStoreList() {
		ArrayList<StoreDto> storeList = new ArrayList<StoreDto>();
	
		storeList = sDao.selectStoreList();
		
		return storeList;
	}

	@Override
	public ArrayList<SelectStoreDto> getStore() {
		ArrayList<SelectStoreDto> selectStore = new ArrayList<SelectStoreDto>();
		selectStore = sDao.selectStore();
		return selectStore;
	}
	
	// order_list 전체 상품정보
	@Override
	public Map<String, Object> getProducts() {
		Map<String, Object> products = new HashMap<>();
		
		ArrayList<DrinkDto> drinks = sDao.selectDrinksList();
		ArrayList<IcecreamDto> icecreams = sDao.selectIcecreamList();
		ArrayList<ShowIceCreamCakeDto> iceCreamCakes = sDao.showIceCreamCake();
		
		products.put("drinks", drinks);
		products.put("icecreams", icecreams);
		products.put("iceCreamCakes", iceCreamCakes);
		
		return products;
	}

	
}
