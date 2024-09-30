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
public class BoardDaoTest {
	@Autowired
	BoardDao dao;
	
	@Test
	public void testEvent() {
		ArrayList<SelectEventDto> selectEvent = dao.selectEvent(0);
		for(SelectEventDto dto : selectEvent) {
			System.out.println(dto.getTitle());
		}
	}
	
	@Test
	public void testPlaza() {
		ArrayList<PlazaBoardDto> boardList = dao.selectPlazaBoardListOrderByLatest();
		System.out.println(boardList.size());
		
	}
	
	@Test
	public void testInsertPlaza() {
		dao.insertPlaza("테스트제목", "테스트내용", "아이디", "이름", 'T');
	}
	
	

}
