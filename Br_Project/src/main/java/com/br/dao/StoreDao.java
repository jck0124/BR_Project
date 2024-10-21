package com.br.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.br.dto.*;

public interface StoreDao {
	// 매장 목록 - 필터링 전
	ArrayList<StoreDto> selectStoreList();	
	
	// 매장 목록 - 필터링 후
	// 파라미터: HashMap<String, Object> hmap - 매장 타입(storeTypeBrChecked) / 매장 타입(storeTypeFlavor) / 주차(parkingChecked) / 배달(deliveryChecked) / 픽업(pickupChecked) 
	// 취식여부(hereChecked) / 해피스테이션(happyStationChecked) / 가챠머신(blindBoxChecked) / 도/시(sel1Selected) / 구/군(sel2Selected) / 매장명(storeSearched)
	ArrayList<StoreDto> filteredStoreList(HashMap<String, Object> hmap);
	
	//매장 목록 (최종본)
	ArrayList<SelectStoreDto> selectStore(); 
	
	// 음료 리스트 SELECT
	ArrayList<DrinkDto> selectDrinksList();
	
	// 아이스크림 리스트
	ArrayList<IcecreamDto> selectIcecreamList();
	
	// 아이스크림 케이크 리스트
	ArrayList<ShowIceCreamCakeDto> showIceCreamCake();
}
