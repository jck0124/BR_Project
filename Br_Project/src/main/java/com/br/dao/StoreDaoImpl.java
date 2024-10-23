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
	
	// 수연
	// 매장 리스트 - 필터링 전
	@Override
	public ArrayList<StoreDto> selectStoreList() {
		List<StoreDto> storeListTemp = sqlSession.selectList("StoreMapper.getAllStore");
		ArrayList<StoreDto> storeList = new ArrayList<StoreDto>();
		storeList.addAll(storeListTemp);
		
		return storeList;
	}
	
	// 매장 리스트 - 필터링 후
	// 파라미터: HashMap<String, Object> hmap - 매장 타입(storeTypeBrChecked) / 매장 타입(storeTypeFlavor) / 주차(parkingChecked) / 배달(deliveryChecked) / 픽업(pickupChecked) 
	// 취식여부(hereChecked) / 해피스테이션(happyStationChecked) / 가챠머신(blindBoxChecked) / 도/시(sel1Selected) / 구/군(sel2Selected) / 매장명(storeSearched)
	@Override
	public ArrayList<StoreDto> filteredStoreList(HashMap<String, Object> hmap) {
		List<StoreDto> filteredStoreListTemp = sqlSession.selectList("StoreMapper.getFilteredStore", hmap);
		
		return new ArrayList<>(filteredStoreListTemp);
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
