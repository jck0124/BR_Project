package com.br.www;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.br.dao.StoreDao;
import com.br.dto.SelectStoreDto;
import com.br.dto.StoreDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class StoreDaoTest {
	@Autowired
	 StoreDao dao;
	
	@Test
	public void storeTest() {
		ArrayList<SelectStoreDto> selectEvent = dao.selectStore();
		for(SelectStoreDto dto : selectEvent) {
			System.out.println(dto.getStoreName());
		}
	}
	
	@Test
	public void storeFilteredTest() {
		HashMap<String, Object> hmap = new HashMap<>();
		hmap.put("storeTypeBrChecked", false);
		hmap.put("storeTypeFlavor", false);
		hmap.put("parkingChecked", false);
		hmap.put("deliveryChecked", false);
		hmap.put("pickupChecked", false);
		hmap.put("hereChecked", false);
		hmap.put("happyStationChecked", false);
		hmap.put("blindBoxChecked", false);
		hmap.put("sel1Selected", "서울");
		hmap.put("sel2Selected", "강남");
		hmap.put("storeSearched", "강남");
		System.out.println("여기?8");
		
		ArrayList<StoreDto> selectStore = dao.filteredStoreList(hmap);
		for(StoreDto dto : selectStore) {
			System.out.println(dto.getStoreName());
		}
	}
	
	

}
