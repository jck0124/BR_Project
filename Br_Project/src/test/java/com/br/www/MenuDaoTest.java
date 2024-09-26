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
public class MenuDaoTest {	// 제일 먼저 해야 하는 것 : 테스트!!!
	@Autowired
	MenuDao dao;
	
	@Test
	public void  testMenuDao() throws Exception{
		System.out.println(dao != null);
	}
	
	
	@Test
	public void testGetMenuList() {
		ArrayList<DrinkDto> menuList = dao.selectDrinksList();
		for(DrinkDto dto : menuList) {
			System.out.println(dto.getName());
		}
	}
	
	
	@Test
	public void testGetMenuByIdx() {
		DrinkDto dto = dao.selectDrinkByIdx(30);
		System.out.println(dto.getName());
		System.out.println(dto.getDescription());
	}
	
	
	// 아이스크림 케이크 리스트 이름 테스트
	@Test
	public void testConnect() {
		ArrayList<ShowIceCreamCakeDto> menuList = dao.showIceCreamCake(0);
		for(ShowIceCreamCakeDto dto : menuList) {
			System.out.println(dto.getBackgroundColor());
		}
	}
	
	@Test
	public void testCakeDetail() {
		ShowIceCreamCakeDetailDto cakeDetail = dao.showIceCreamCakeDetail("해피 버스데이");
		System.out.println(cakeDetail.getKorName());
	}
	
	@Test
	public void ingredientTest() {
		ArrayList<IcecreamIngredientDto> dtoList = dao.selectIngredientList(6);
		System.out.println(dtoList.size());
	}
	
}

















