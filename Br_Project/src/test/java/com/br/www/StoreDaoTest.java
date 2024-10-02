package com.br.www;
import java.util.ArrayList;

import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.br.dao.*;
import com.br.dto.*;

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
	
	
	
	

}
