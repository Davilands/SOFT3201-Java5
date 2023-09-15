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

import com.poly.entity.Student2;

import jakarta.validation.Valid;
@Controller
public class StudentController2 {
	@GetMapping("/student/form2")
	public String index(Model m) {
		Student2 entity = new Student2();
		m.addAttribute("student", entity);
		return "student2";
	}
	
	@PostMapping("/student/save2")
	public String save(Model m, @Valid 
			@ModelAttribute("student") Student2 entity,
			BindingResult rs) {
		if(rs.hasErrors()) 
			m.addAttribute("message", "Vui lòng nhập đúng form");
		else
			m.addAttribute("message", "Form đúng định dạng");
		return "student2";
	}
	
	@ModelAttribute("gender2")
	public Map<Boolean, String> getGender(){
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Male");
		map.put(false, "Female");
		return map;
	}
	
	@ModelAttribute("faculty")
	public List<String> faculty(){
		List<String> list = new ArrayList<>();
		list.add("CNTT");
		list.add("MAR");
		list.add("ECO");
		return list;
	}
	
	@ModelAttribute("hobbies")
	public Map<String, String> hobbies(){
		Map<String, String> map = new HashMap<>();
		map.put("LIST", "Listen Music");
		map.put("GAME", "Play Game");
		map.put("READ", "Read Book");
		return map;
	}
}
