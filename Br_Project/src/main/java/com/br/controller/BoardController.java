package com.br.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.dto.PlazaPaginationDto;
import com.br.dto.RecipeDto;
import com.br.dto.RecipeImgDto;
import com.br.service.BoardServiceImpl;

@Controller
public class BoardController {
	@Autowired
	BoardServiceImpl bSvc;
	
	@Autowired
	private ServletContext servletContext;
	
//	수연 업로드 패스: 임시
	@Resource(name = "recipeUploadPath")
	private String recipeUploadPath;

	private static final Logger logger = Logger.getLogger(BoardController.class);
	
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
	// 레시피 리스트
	@RequestMapping("/br_recipe")
	public String brRecipe(Model model) {
		List<RecipeDto> recipeList = bSvc.getRecipeList();
		
		if(recipeList != null) {
			model.addAttribute("recipeList", recipeList);
		}
		return "br_play/br_recipe";
	}
	
	// 레시피 이미지 파일 출력
	@RequestMapping("/br_recipe/img")
	// 바이트 배열 형태로 이미지 반환
	public ResponseEntity<byte[]> getRecipeImg(@RequestParam(required = false) Integer recipeIdx) {
	    RecipeImgDto recipeImg = bSvc.getRecipeImg(recipeIdx);
//	    int testRecipeIdx = 90;
	    
	    if (recipeImg != null) {
	        byte[] imageBytes = null;
	        
			try {
				// Path객체에 해당하는 파일을 읽어와서 모든 내용을 바이트 배열로 반환
				imageBytes = Files.readAllBytes(Paths.get(recipeImg.getImgUrl()));
			} catch (IOException e) {
				e.printStackTrace();
				// 상태 코드500: 서버에서 요청을 처리하는 동안 예기치 않은 오류가 발생했음을 반환
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
			}
	        return ResponseEntity.ok()
	                             .contentType(MediaType.IMAGE_JPEG) // 응답의 컨텐츠 타입: JPEG(이미지 유형에 맞게 설정)
	                             .body(imageBytes);	// 읽어온 이미지 바이트(내용)
	    }
	    return ResponseEntity.notFound().build(); // 이미지가 없을 경우 404 반환
	}

	
	// 파일 업로드
	@ResponseBody
	@RequestMapping(value="file", method = RequestMethod.POST)
	public String fileUpload(MultipartFile file) throws Exception {
		logger.info("/request/file");
		logger.info("uploadPath : "+ recipeUploadPath);
		
		if (file.isEmpty()) {
			return "FAIL";
		}
		
		logger.info("originalFileName : " + file.getOriginalFilename());
		logger.info("size : " + file.getSize());
		logger.info("contentType : " + file.getContentType());
		
		// 파일 데이터
		byte[] fileData = file.getBytes();
		
		// 파일 업로드
		String filePath = recipeUploadPath;
		String fileName = file.getOriginalFilename();
		File uploadFile = new File(filePath, fileName);
		
		// 파일 업로드 (저장)
		FileCopyUtils.copy(fileData, uploadFile); 
		// FileCopyUtils.copy(파일 데이터, 파일 객체);
		// : 내부적으로 InputStream, OutputStream을 이용하여 입력받은 파일을 출력한다.
		
		// 저장된 파일의 경로를 반환
	    return uploadFile.getAbsolutePath(); // 경로 반환
	}
	

	// 레시피 insert
	@RequestMapping("/insert_recipe")
	public String recipe(
			@RequestParam int categoryIdx, 
			// imgUrl을 파일 경로로 변경
			@RequestParam("imgUrl") MultipartFile imgPath,
			@RequestParam String titleKor, 
			@RequestParam String titleEng,
			HttpServletRequest request) {
		
		String imgUrl;
		 // 이미지 파일 업로드
	    try {
	        imgUrl = fileUpload(imgPath); // 파일 업로드 메소드 호출
	    } catch (Exception e) {
	        // 오류 처리
	        return "redirect:/error"; // 오류 페이지로 리다이렉트
	    }
		
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
			String uploadDir = "C:/uploads/";
			// String uploadDir = servletContext.getRealPath("/resources/uploads/");
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
