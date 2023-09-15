package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	@GetMapping("home/index")
	public String index() {
		return "admin/home/index";
	}
	
	@GetMapping("home/about")
	public String about() {
		return "admin/home/about";
	}
}
