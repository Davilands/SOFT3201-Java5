package com.poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.bean.*;

import jakarta.validation.Valid;
@Controller
public class Staff3Controller {
	@GetMapping("/staff3")
	public String index(Model m) {
		m.addAttribute("staff", new staff3());
		return "staff3";
	}
	
	@PostMapping("/staff3")
	public String process(Model m, @Valid 
			@ModelAttribute("staff") staff3 staff,
			BindingResult rs) {
		if(rs.hasErrors()) 
			m.addAttribute("message", "Một số trường hợp không đúng quy định");
		else
			m.addAttribute("message", "Tất cả các trường hợp đều hợp lệ");
		return "staff3";
	}
	
	@ModelAttribute("positions")
	public Map<String, String> getPositions(){
		Map<String, String> ps = new HashMap<>();
		ps.put("CEO", "Chief Executive Officer");
		ps.put("DIR", "Director");
		ps.put("MAN", "Manager");
		ps.put("EMP", "Employee");
		return ps;
	}
	
	@ModelAttribute("hobbies")
	public List<String> getHobbies(){
		List<String> hbs = new ArrayList<>();
		hbs.add("Xem phim");
		hbs.add("Chơi game");
		hbs.add("Đọc sách");
		hbs.add("Khác");
		return hbs;
	}
	
	@ModelAttribute("genders")
	public Map<Integer, String> getGenders(){
		Map<Integer, String> ps = new HashMap<>();
		ps.put(0, "Nam");
		ps.put(1, "Nữ");
		return ps;
	}
}
