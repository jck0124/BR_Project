package com.br.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.dto.PlazaPaginationDto;
import com.br.service.BoardServiceImpl;

@Controller
public class BoardController {
	@Autowired
	BoardServiceImpl bSvc;
	@Autowired
	private ServletContext servletContext;
	
////	수연 업로드 패스: 임시
//	@Resource(name = "uploadPath")
//	private String uploadPath;
	// 찬균
	@RequestMapping("/br_plaza")
	public String brPlaza(
			@RequestParam(value = "orderType", required = false, defaultValue = "latest") String orderType,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			Model model) {
		
		PlazaPaginationDto pDto = bSvc.palzaPagination(orderType, pageNum);
		model.addAttribute("boardList", pDto.getBoardList());
		model.addAttribute("orderType", orderType);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPageNum", pDto.getTotalPageNum());
		
		return "br_play/br_plaza";
	}
	
	@RequestMapping("/br_plaza_write")
	public String brPlazaWrite(HttpSession session) {
		
		if( session.getAttribute("loginId")!= null  ) {
			return "br_play/br_plaza_write";
		} else {
			return "etc/error";
		}
	}
	
	@RequestMapping("/br_plaza_insert_write")
	public String brPlazaInsert(
			@RequestParam(value = "writer_id") String writerId,
			@RequestParam(value = "writer_name") String writerName,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "agreement") String agreement) {
		
		bSvc.insertPlazaBoard(title, content, writerId, writerName, agreement);
		return "redirect:/br_plaza";
	}
	
	@RequestMapping("/br_plaza_detail")
	public String brPlazaDetail(Model model) {
		
		return "br_play/br_plaza_detail";
	}
	
	
	//수연
	@RequestMapping("/br_recipe")
	public String brRecipe(Model model) {
		
		if(bSvc.getRecipeList() != null) {
			model.addAttribute("recipeList", bSvc.getRecipeList());
		}
		return "br_play/br_recipe";
	}

	// insert recipe
	@RequestMapping("/insert_recipe")
	public String recipe(
			@RequestParam int categoryIdx, 
			@RequestParam String imgUrl, 
			@RequestParam String titleKor, 
			@RequestParam String titleEng,
			HttpServletRequest request) {
		
		int recipeIdx = bSvc.getRecipeIdx();
		
		System.out.println("recipeIdx: " + recipeIdx);
		System.out.println("categoryIdx: " + categoryIdx);
	    System.out.println("titleKor: " + titleKor);
	    System.out.println("titleEng: " + titleEng);
	    System.out.println("imgUrl: " + imgUrl);
		
		bSvc.insertRecipe(recipeIdx, categoryIdx, imgUrl, titleKor, titleEng);
		return "manager/manager";
	}
	
	//수빈
	@RequestMapping("/event")
	public String event(HttpServletRequest request, Model model) {
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) { }
		
		Map<String, Object> result = bSvc.selectEvent(pageNum);
		
		if(result != null) {
			model.addAttribute("selectEvent", result.get("selectEvent"));
			model.addAttribute("startNum", result.get("startNum"));
			model.addAttribute("endNum", result.get("endNum"));
			model.addAttribute("lastPageNum", result.get("lastPageNum"));
		}
		
		model.addAttribute("pageNum", pageNum);
		
		return "br_play/event";
	}
	
	// 매니저 board 업로드
	@RequestMapping("/manager")
	public String manager() {
		
		return "manager/manager";
	}
	
	// Post 방식으로 파일 업로드 처리 
	@PostMapping("/uploadEvent")
	public String handleFileUpload(
		@RequestParam("topLetter") String topLetter,
		@RequestParam("title") String title,
		@RequestParam("period") String period,
		@RequestParam("img") MultipartFile file,
		RedirectAttributes redirectAttributes,
		HttpServletRequest request) {
		
		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "파일을 선택해주세요.");
			return "redirect:/manager";
		}
		
		try {
            // 파일 저장 로직
			// String uploadDir = "C:/uploads/";
			String uploadDir = servletContext.getRealPath("/resources/uploads/");
			File directory = new File(uploadDir);
			if (!directory.exists()) {
			    directory.mkdirs(); // 디렉토리 생성
			}
            Path path = Paths.get(uploadDir + file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            
            // 데이터베이스에 이벤트 정보 삽입
            String imgPath = uploadDir + file.getOriginalFilename(); // 저장한 이미지 경로
            bSvc.insertEvent(imgPath, topLetter, title, period); // 서비스 호출
            
            // 성공 메시지 추가
            redirectAttributes.addFlashAttribute("message", "파일 업로드 성공: " + file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "파일 업로드 실패.");
        }

        return "redirect:/manager";
	}
}
