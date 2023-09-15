package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.service.ShoppingCartServiceImpl;
import com.poly.utils.DB;
import com.poly.entity.*;

@Controller
public class ShoppingCartController {
	@Autowired
	ShoppingCartServiceImpl cart;
	
	@GetMapping("/cart/view")
	public String view(Model model) {
		model.addAttribute("cart", cart);
		return "cart/index";
	}
	
	@GetMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Integer id) {
		Item entity = new Item();
		entity = DB.items.get(id);
		cart.add(id, entity);
		return "redirect:/cart/view";
	}
	
	@GetMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/cart/view";
	}
	
	@GetMapping("/cart/update/{id}")
	public String remove(@PathVariable("id") Integer id, @RequestParam("qty") Integer qty) {
		cart.update(id, qty);
		return "redirect:/cart/view";
	}
	
	@GetMapping("/cart/clear")
	public String clear() {
		cart.clear();
		return "redirect:/cart/view";
	}
}
