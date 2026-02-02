package com.zeus.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String name;
	private Integer price;
	private String description;
	private String url;
	
	//화면에서 파일을 받아야 한다.
	private MultipartFile picture;
}
