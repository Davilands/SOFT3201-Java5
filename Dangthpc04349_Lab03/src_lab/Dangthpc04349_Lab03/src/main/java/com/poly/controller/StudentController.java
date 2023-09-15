package com.poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.entity.Student;
@Controller
public class StudentController {
	@GetMapping("/student/form")
	public String index(Model m) {
		Student entity = new Student();
		m.addAttribute("student", entity);
		return "student";
	}
	
	@PostMapping("/student/save")
	public String save(Model model, @ModelAttribute("student") Student entity) {
		entity.setName(entity.getName().toUpperCase());
		return "student";
	}
	
	@ModelAttribute("gender")
	public Map<Boolean, String> gender(){
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
