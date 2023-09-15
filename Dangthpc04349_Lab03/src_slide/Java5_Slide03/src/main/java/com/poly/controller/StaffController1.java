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

import com.poly.bean.*;
@Controller
public class StaffController1 {
	@GetMapping("/staff1")
	public String index(Model m) {
		Staff1 staff = new Staff1();
		staff.setPosition("MAN");
		staff.setCountry(new Country("SG", ""));
		m.addAttribute("staff", staff);
		return "staff1";
	}
	
	@PostMapping("/staff1")
	public String post (@ModelAttribute("staff") Staff1 staff) {
		staff.setTennv(staff.getTennv().toUpperCase());
		staff.setManv(staff.getManv().toLowerCase());
		return "staff1";
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
	
	@ModelAttribute("quocgia")
	public List<Country> getCountrys(){
		List<Country> cts = new ArrayList<>();
		cts.add(new Country("VN", "Việt Nam"));
		cts.add(new Country("US", "United States"));
		cts.add(new Country("SG", "Singapor"));
		return cts;
	}
}
