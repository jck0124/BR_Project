package com.br.www;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.br.dao.BoardDao;
import com.br.dto.PlazaBoardDto;
import com.br.dto.PlazaDetailDto;
import com.br.dto.RecipeImgDto;
import com.br.dto.SelectEventDto;

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
	
	@Test
	public void testPlazaDetail() {
		PlazaDetailDto pDto = dao.selectPlazaDtoByBoardIdx(16);
		System.out.println( pDto.getShowName() );
	}
	
	
// 	// 저장된 이미지 경로
//	@Test
//	public void testSelectRecipeIdx() {
//		int a = dao.selectRecipeIdx();
//		System.out.println("recipeIdx : " + a);
//	}
	
//	@Test
//	public void testInsertRecipe() {
//		int a = dao.selectRecipeIdx();
//		System.out.println("recipeIdx : "+ a);
//		dao.insertRecipe(a, 2, "이미지테스트입니다.", "타이틀 kor", "title eng");
//	}

	
//	@Test
//	public void testRecipeImgFile() {
//	    RecipeImgDto recipeImg = dao.selectRecipeImg(90); // 레시피 ID 1의 이미지 정보 가져오기
//	    
//	    // 예상 값
//	    int expectedRecipeIdx = 90;  // 테스트할 때 맞는 recipeIdx
//	    String expectedImgUrl = "/Users/kimsueyeon/upload/105.jpg";  // 실제 저장된 imgUrl 경로
//	    
//	    // recipeIdx와 imgUrl이 정확한지 확인
//	    assertNotNull(recipeImg);  // recipeImg가 null이 아니어야 함
//	    assertEquals(expectedRecipeIdx, recipeImg.getRecipeIdx());  // recipeIdx 비교
//	    assertEquals(expectedImgUrl, recipeImg.getImgUrl());  // imgUrl 비교
//	    
//	    // 출력해서 확인할 수도 있음
//	    System.out.println("recipeIdx: " + recipeImg.getRecipeIdx());
//	    System.out.println("imgUrl: " + recipeImg.getImgUrl());
//	}

}
	
