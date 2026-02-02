package com.zeus.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Item;
import com.zeus.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.zeus.mapper")
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	// application.properties 에서 upload.path에 저장된 경로를 로딩한다.
	@Value("${upload.path}")
	private String uploadPath;

	@GetMapping("/createForm")
	public String itemCreateForm() {
		log.info("/createForm");
		return "item/createForm";
	}

	@PostMapping("/create")
	public String itemCreate(Item item, Model model) throws IOException, Exception {
		log.info("/create item = " + item.toString());

		// 1. 파일 업로드 한 것을 가져와라
		MultipartFile file = item.getPicture();

		// 2. 파일 정보를 출력한다.
		log.info("originalName: " + file.getOriginalFilename());
		log.info("size: " + file.getSize());
		log.info("contentType: " + file.getContentType());

		// 3. 파일을 외장하드에 저장
		String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
		
		// 4. 저장된 파일 경로를 item 객체에 저장한다
		item.setUrl(createdFileName);
		
		// 5. 테이블에 상품화면정보를 저장
		int count = itemService.create(item);
		
		if(count > 0) {
			model.addAttribute("message", "%s 상품등록이 성공하였습니다.".formatted(file.getOriginalFilename()));
			return "item/success";
		}
		model.addAttribute("message", "%s 상품등록에 실패하였습니다.".formatted(file.getOriginalFilename()));
		return "item/failed";
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		// 절대 중복되지 않는 문자열 생성 (uid = 862d7b48-2bcf-4003-afd3-21e53b05f02e)
		UUID uid = UUID.randomUUID();

		// createdFileName = 862d7b48-2bcf-4003-afd3-21e53b05f02e_image.jpg
		String createdFileName = uid.toString() + "_" + originalName;

		// D:/upload/862d7b48-2bcf-4003-afd3-21e53b05f02e_image.jpg
		File target = new File(uploadPath, createdFileName);

		// (파일내용 값이 있는 바이트배열) byte[] fileData 을
		// D:/upload/862d7b48-2bcf-4003-afd3-21e53b05f02e_image.jpg에 복사진행
		FileCopyUtils.copy(fileData, target);
		return createdFileName;
	}

}
