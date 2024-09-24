package com.br.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.br.dto.StoreDto;

@Repository
public class StoreDaoImpl implements StoreDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<StoreDto> selectStoreList() {
		
		List<StoreDto> storeListTemp = sqlSession.selectList("StoreMapper.getAllStore");
		ArrayList<StoreDto> storeList = new ArrayList<StoreDto>();
		storeList.addAll(storeListTemp);
		
		return storeList;
	}
}
