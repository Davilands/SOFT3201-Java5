package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.custominterface.AccountDAO;
import com.poly.entity.Account;

@Controller
public class CrudController {
	@Autowired
	AccountDAO dao;
	
	@RequestMapping("/account/index")
	public String index(Model m) {
		m.addAttribute("account", new Account());
		return "account/index";
	}
	
	@RequestMapping("/account/edit/{username}")
	public String edit (@PathVariable("username") String username, Model m) {
		m.addAttribute("account", dao.getById(username));
		return "account/index";
	}
	
	@RequestMapping("/account/update")
	public String edit (RedirectAttributes attrRedirect, Model m, @ModelAttribute("account") Account item,
			@RequestParam("photo_file") MultipartFile photofile) {
		if(dao.existsById(item.getUsername())) {
			if(!photofile.isEmpty())
				item.setPhoto(photofile.getOriginalFilename());
			if(item.getPhoto() == null)
				item.setPhoto("");
			dao.saveAndFlush(item);
			attrRedirect.addAttribute("message", "Cập nhật thành công!");
			return "redirect:/account/index";
		}else {
			attrRedirect.addAttribute("message", "Cập nhật thất bại!");
		}
		return "redirect:/account/index";
	}
	
	@RequestMapping("/account/create")
	public String create (@ModelAttribute("account") Account item, RedirectAttributes attrRedirect, Model m, 
			@RequestParam("photo_file") MultipartFile photofile) {
		if(!dao.existsById(item.getUsername())) {
			if(photofile.isEmpty())
				item.setPhoto("");
			else
				item.setPhoto(photofile.getOriginalFilename());
			dao.saveAndFlush(item);
			attrRedirect.addAttribute("message", "Thêm tài khoản thành công!");
		}else {
			attrRedirect.addAttribute("message", "Tài khoản đã tồn tại!");
		}
		return "redirect:/account/index";
	}
	
	@RequestMapping("/account/delete/{username}")
	public String delete (@PathVariable("username") String username, Model m, RedirectAttributes params) {
		if(dao.existsById(username)) {
			dao.deleteById(username);
			params.addAttribute("message", "Xóa tài khoản thành công!");
			return "redirect:/account/index";
		}else {
			params.addAttribute("message", "Tài khoản không tồn tại!");
		}
		return "redirect:/account/index";
	}
	
	@ModelAttribute("listAccount")
	public List<Account> list(){
		return dao.findAll();
	}
}
