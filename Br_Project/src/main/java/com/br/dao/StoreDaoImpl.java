package com.br.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.br.dto.DrinkDto;
import com.br.dto.IcecreamDto;
import com.br.dto.SelectStoreDto;
import com.br.dto.ShowIceCreamCakeDto;
import com.br.dto.StoreDto;

@Repository
public class StoreDaoImpl implements StoreDao {
	
	@Autowired
	SqlSession sqlSession;
	
	// 필터링 전 store
	@Override
	public ArrayList<StoreDto> selectStoreList() {
		
		List<StoreDto> storeListTemp = sqlSession.selectList("StoreMapper.getAllStore");
		ArrayList<StoreDto> storeList = new ArrayList<StoreDto>();
		storeList.addAll(storeListTemp);
		
		return storeList;
	}
	
	// 필터링 후 store
	@Override
	public ArrayList<StoreDto> filteredStoreList(
			String storeTypeBrChecked,
			String storeTypeFlavor,
			String parkingChecked,
			String deliveryChecked,
			String pickupChecked,
			String hereChecked,
			String happyStationChecked,
			String blindBoxChecked,
			String sel1Selected,
			String sel2Selected,
			String storeSearched
			) {
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("storeTypeBrChecked", storeTypeBrChecked);
		hmap.put("storeTypeFlavor", storeTypeFlavor);
		hmap.put("parkingChecked", parkingChecked);
		hmap.put("deliveryChecked", deliveryChecked);
		hmap.put("pickupChecked", pickupChecked);
		hmap.put("hereChecked", hereChecked);
		hmap.put("happyStationChecked", happyStationChecked);
		hmap.put("blindBoxChecked", blindBoxChecked);
		hmap.put("sel1Selected", sel1Selected);
		hmap.put("sel2Selected", sel2Selected);
		hmap.put("storeSearched", storeSearched);
		
		List<StoreDto> filteredStoreListTemp = sqlSession.selectList("StoreMapper.getFilteredStore", hmap);
		ArrayList<StoreDto> filteredStoreList = new ArrayList<StoreDto>();
		filteredStoreList.addAll(filteredStoreListTemp);
		
		return filteredStoreList;
	}
	// 수빈
	@Override
	public ArrayList<SelectStoreDto> selectStore() {
		List<SelectStoreDto> storeTemp = sqlSession.selectList("StoreMapper.selectStores");
		ArrayList<SelectStoreDto> store = new ArrayList<SelectStoreDto>();
		store.addAll(storeTemp);
		return store;
	}
	
	@Override
	public ArrayList<DrinkDto> selectDrinksList() {
		List<DrinkDto> drinksList = sqlSession.selectList("StoreMapper.selectAllDrinks");
		return new ArrayList<DrinkDto>(drinksList);
	}
	
	@Override
	public ArrayList<IcecreamDto> selectIcecreamList() {
		
		List<IcecreamDto> icecreamListTemp = sqlSession.selectList("StoreMapper.getAllIcecream");
		ArrayList<IcecreamDto> icecreamList = new ArrayList<IcecreamDto>();
		icecreamList.addAll(icecreamListTemp);
		
		return icecreamList;
	}
	
	@Override
	public ArrayList<ShowIceCreamCakeDto> showIceCreamCake() {
		
		List<ShowIceCreamCakeDto> cakesListTemp = sqlSession.selectList("StoreMapper.selectAllCakes");
		ArrayList<ShowIceCreamCakeDto> cakesList = new ArrayList<ShowIceCreamCakeDto>();
		cakesList.addAll(cakesListTemp);
		return cakesList;
	}
}
