package com.br.www;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.br.dao.MenuDaoImpl;
import com.br.dto.DrinkDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DaoTest {
	@Autowired
	MenuDaoImpl mDao;
	
	@Test
	public void testGetMenuList() {
		ArrayList<DrinkDto> menuList = mDao.selectDrinksList();
		for(DrinkDto dto : menuList) {
			System.out.println(dto.getName());
		}
	}
	
	
	@Test
	public void testGetMenuByIdx() {
		DrinkDto dto = mDao.selectDrinkByIdx(30);
		System.out.println(dto.getName());
		System.out.println(dto.getDescription());
	}
	
	
	
}

















