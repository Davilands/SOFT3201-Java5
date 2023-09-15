package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.service.CookieService;
import com.poly.service.ParamService;
import com.poly.service.SessionService;

@Controller
public class AccountController {
	@Autowired
	ParamService paramService;
	
	@Autowired
	CookieService cookieService;
	
	@Autowired
	SessionService sessionService;
	
	@GetMapping("/account/login")
	public String login1(Model model) {
		String user = cookieService.getValue("user");
		if(user != null) {
			String pass = cookieService.getValue("pass");
			model.addAttribute("user", user);
			model.addAttribute("pass", pass);
		}
		return "login";
	}
	
	@PostMapping("/account/login")
	public String login2(Model model) {
		String username = paramService.getString("username", "");
		String password = paramService.getString("password", "");
		boolean remember = paramService.getBoolean("remember", false);
		
		if(username.equals("poly") && password.equals("123")) {
			sessionService.set("username", username);
			if(remember) {
				cookieService.add("user", username, 10);
				cookieService.add("pass", username, 10);
			}else {
				cookieService.delete("user");
				cookieService.delete("pass");
			}
			return "infor";
		}
		else {
			model.addAttribute("message", "Sai thông tin");
		}
		return "login";
	}
}
