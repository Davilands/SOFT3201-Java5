package com.poly.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.bean.*;

import jakarta.servlet.ServletContext;
@Controller
public class UploadController {
	@Autowired
	ServletContext app;
	
	@GetMapping("/upload")
	public String index(Model m) {
		staff2 staff = new staff2();
		m.addAttribute("staff", staff);
		return "upload";
	}
	
	@PostMapping("/upload")
	public String uploadProcessing (Model m, @ModelAttribute("staff") staff2 staff,
			@RequestParam("hinhnv") Optional<MultipartFile> ophinhanh) {
		if(ophinhanh.isPresent()) {
			MultipartFile hinhanh = ophinhanh.get();
			if(!hinhanh.isEmpty()) {
				String filename = hinhanh.getOriginalFilename();
				File pathUpload = new File(app.getRealPath("/hinhanh/" +filename));
				try {
					hinhanh.transferTo(pathUpload);
					staff.setImage("/hinhanh/" +filename);
					while(app.getResourceAsStream("/hinhanh/" +filename) == null);
					m.addAttribute("message", "Upload thành công");
				} catch (IllegalStateException | IOException e) {
					m.addAttribute("message", "Upload thất bại");
				}
			}
		}
		return "upload";
	}
	
	@ModelAttribute("vitri")
	public Map<String, String> getPositions(){
		Map<String, String> ps = new HashMap<>();
		ps.put("CEO", "Chief Executive Officer");
		ps.put("DIR", "Director");
		ps.put("MAN", "Manager");
		ps.put("EMP", "Employee");
		ps.put("JAN", "Janitor");
		return ps;
	}
	
	@ModelAttribute("sothich")
	public List<String> getHobbies(){
		List<String> hbs = new ArrayList<>();
		hbs.add("Nghe nhạc");
		hbs.add("Xem phim");
		hbs.add("Chơi game");
		hbs.add("Đọc sách");
		hbs.add("Lập trình");
		hbs.add("Khác");
		return hbs;
	}
	
	@ModelAttribute("nationalitiles")
	public List<Country> getCountrys(){
		List<Country> cts = new ArrayList<>();
		cts.add(new Country("VN", "Việt Nam"));
		cts.add(new Country("US", "United States"));
		cts.add(new Country("SG", "Singapor"));
		cts.add(new Country("UK", "Vương quốc Anh"));
		return cts;
	}
}
