package com.br.www;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.br.dao.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDaoTest {
	
	@Autowired
	MemberDao mDao;
	
	@Test
	public void adminCheckTest() {
		System.out.println(mDao.adminCheck("admin"));
	}
	
}
