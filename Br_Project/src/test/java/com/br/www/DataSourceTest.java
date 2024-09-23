package com.br.www;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class DataSourceTest {
	@Autowired
	DataSource ds;
	
	@Test
	public void testConnect() {
		
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			if(conn != null) {
				System.out.println("DB 접속");
			} else {
				System.out.println("DB 접속 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}
	
	
}

















