package com.poly.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.poly.custominterface.ProductDAO;
import com.poly.entity.Product;
import com.poly.entity.*;

@Controller
public class ProductController {
	@Autowired
	ProductDAO dao;
	
	@ResponseBody
	@RequestMapping("/product/list")
	public List<Product> list(){
		Sort sort = Sort.by(Direction.DESC, "price", "id");
		return dao.findAll(sort);
	}
	
	@ResponseBody
	@RequestMapping("/product/paging")
	public Page<Product> paging(@RequestParam("pageNo") Optional<Integer> pageNo){
		Pageable pageable = PageRequest.of(pageNo.orElse(0), 3);
		return dao.findAll(pageable);
	}
	
	@RequestMapping("/product/sort")
	public String list2(Model m, @RequestParam("field")Optional<String> field,
			@RequestParam("sort") Optional<Integer> criteria) {
		int s = criteria.orElse(0);
		Sort sort;
		if(s == 0) {
			sort = Sort.by(Direction.DESC, field.orElse("price"));
			s = 1;
		}else {
			sort = Sort.by(Direction.ASC, field.orElse("price"));
			s = 0;
		}
		m.addAttribute("listProduct", dao.findAll(sort));
		m.addAttribute("sort", s);
		return "product/index";
	}
	
	@RequestMapping("/product")
	public String list(@RequestParam("page") Optional<Integer> pageNo, Model m) {
		int paging = pageNo.orElse(0);
		if(paging < 0)
			paging = 0;
		Pageable pageable = PageRequest.of(paging, 5, Sort.by("price"));
		Page<Product> page = dao.findAll(pageable);
		if(page.getTotalPages() - 1 < paging) {
			pageable = PageRequest.of(page.getTotalPages() - 1, 5, Sort.by("price"));
			page = dao.findAll(pageable);
		}
		m.addAttribute("trang", page);
		return "product/page";
	}
	
	@ResponseBody
	@RequestMapping("/product/json")
	public Page<Product> listJson(@RequestParam("page") Optional<Integer> pageNo, Model m){
		int paging = pageNo.orElse(0);
		if(paging < 0)
			paging = 0;
		Pageable pageable = PageRequest.of(paging, 5, Sort.by("id"));
		Page<Product> page = dao.findAll(pageable);
		return page;
	}
	
	@RequestMapping("/product/sort2")
	public String sort2(Model m) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(Direction.DESC, "price"));
		orders.add(new Order(Direction.ASC, "id"));
		
		Sort sort = Sort.by(orders);
		m.addAttribute("listProduct", dao.findAll(sort));
		return "product/index2";
	}
	
	@RequestMapping("/product/sort3")
	public String sort3(Model m) {
		Sort sort = Sort.by("createDate").ascending().and(
				Sort.by("price").descending().and(Sort.by("name"))
				);
		m.addAttribute("listProduct", dao.findAll(sort));
		return "product/index2";
	}
	
}
	