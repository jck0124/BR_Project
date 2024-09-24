package com.br.dao;

import java.util.ArrayList;

import com.br.dto.StoreDto;

public interface StoreDao {
	ArrayList<StoreDto> selectStoreList();	// 모든 매장 목록
}
