package com.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please select file");
		}
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());	
		
		try {
			boolean f = fileUploadHelper.uploadFile(file);
			if(f) {
				return  ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("images/").path(file.getOriginalFilename()).toUriString());
			}
			
		}catch (Exception e) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is not able to upload");
		}
		return ResponseEntity.ok("working");
	}
}
