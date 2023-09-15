package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.custominterface.CategoryDAO;
import com.poly.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Controller
@Transactional
public class CategoryControllerSimpleJPA {
	@Autowired
	EntityManager em;
	
	@Autowired
	CategoryDAO dao;
	
	@ResponseBody
	@GetMapping("/category/list/simplejpa")
	public List<Category> list(){
		SimpleJpaRepository<Category, String> simple = 
				new SimpleJpaRepository<Category, String>(Category.class, em);
		return simple.findAll();
	}
	
	@GetMapping("/category/list/view")
	public String getCategoryView(Model m){
		SimpleJpaRepository<Category, String> simple = 
				new SimpleJpaRepository<Category, String>(Category.class, em);
		m.addAttribute("list", simple.findAll());
		return "category/index";
	}
	
	@GetMapping("/category/dao/view")
	public String getCategoryDaoView(Model m){
		
		m.addAttribute("list", dao.findAll());
		return "category/index";
	}
}
