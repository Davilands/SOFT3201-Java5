package com.poly.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {
	@GetMapping("/index")
	public String index() {
		return "home/index";
	}

	@GetMapping("/about")
	public String about() {
		return "home/about";
	}

	
	@GetMapping("/abcxyz")
	public String abc_xyz() {
		return "abc/index";
	}
	
	@Autowired
	private MessageSource messageSource;
	@ResponseBody
	@RequestMapping("/gethome")
	public String index(HttpServletRequest request) {
		String message = messageSource.getMessage("lo.mn.home", null, "default message", request.getLocale());
		// model.addAttribute("message", message);
		return message;
	}
}
