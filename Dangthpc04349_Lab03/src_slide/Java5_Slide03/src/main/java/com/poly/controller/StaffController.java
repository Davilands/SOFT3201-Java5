package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.bean.*;

@Controller
public class StaffController {
	@GetMapping("/staff")
	public String index(Model m) {
		Staff nv1 = new Staff();
		nv1.setTenNV("Nguyễn Văn Tèo");
		nv1.setViTri("MAN");
		nv1.setGioiTinh(true);
		m.addAttribute("nhanvien", nv1);
		return "staff";
	}
	
	@PostMapping("/staff")
	public String post(@ModelAttribute("nhanvien") Staff staff) {
		staff.setTenNV(staff.getTenNV().toUpperCase());
		staff.setMaNV(staff.getMaNV().toLowerCase());
		return "staff";
	}
}
