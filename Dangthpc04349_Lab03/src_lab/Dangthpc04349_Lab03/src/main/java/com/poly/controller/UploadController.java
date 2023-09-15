package com.poly.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Controller
public class UploadController {
	@Autowired
	ServletContext app;

	@GetMapping("/upload/form")
	public String index() {
		return "upload";
	}

	@PostMapping("/upload/save")
	public String save(Model model, @RequestParam("file") MultipartFile file) {
		String uploadRootPath = app.getRealPath("upload");
		File uploadRootDir = new File(uploadRootPath);
		if (uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		try {
			String fileName = file.getOriginalFilename();
			File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(file.getBytes());
			stream.close();
			model.addAttribute("name", fileName);
			model.addAttribute("size", file.getSize());
			model.addAttribute("type", file.getContentType());
		} catch (Exception e) {
			model.addAttribute("message", "Lỗi upload file");
			return "upload";
		}
		return "inforFile";
	}
}