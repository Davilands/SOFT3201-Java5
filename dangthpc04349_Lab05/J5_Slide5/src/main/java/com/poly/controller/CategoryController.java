package com.poly.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.custominterface.CategoryDAO;
import com.poly.entity.Category;

@Controller
@Transactional
public class CategoryController {
	@Autowired
	CategoryDAO repoCate;
	
	@ResponseBody
	@GetMapping("/category/list")
	public List<Category> list(){
		Category cate = repoCate.findById("1000").get();
		cate.setName("Điện không lạnh");
		repoCate.saveAndFlush(cate);
		
		return repoCate.findAll();
	}
	
	@ResponseBody
	@GetMapping("/pager/list")
	public Page<Category> list(@RequestParam("pageNo") Optional<Integer> pageNo){
		Pageable pageable = PageRequest.of(pageNo.orElse(0), 3);
		Page<Category> page = repoCate.findAll(pageable);
		return page;
	}
}
