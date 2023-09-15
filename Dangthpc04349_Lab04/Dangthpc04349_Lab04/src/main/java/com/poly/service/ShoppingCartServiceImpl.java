package com.poly.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.poly.entity.*;
import com.poly.utils.ShoppingCartService;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	public static Map<Integer, Item> map = new HashMap<>();
	

	@Override
	public void add(Integer id, Item entity) {
		if(map.get(id) != null) {
			this.update(id, entity.getQty() + 1);
		}else {
			map.put(id, entity);
		}
		
	}
	
	@Override
	public void remove(Integer id) {
		map.remove(id);
	}
	
	@Override
	public void clear() {
		map.clear();
	}
	
	@Override
	public Collection<Item> getItems(){
		return map.values();
	}
	
	@Override
	public int getCount() {
		int count = 0;
		Set<Integer> set = map.keySet();
		for(Integer i : set) {
			count++;
		}
		return count;
 	}
	
	@Override
	public double getAmount() {
		double amount = 0;
		Set<Integer> set = map.keySet();
		for(Integer i : set) {
			amount += map.get(i).getPrice();
		}
		return amount;
 	}


	@Override
	public void update(Integer id, int qty) {
		// TODO Auto-generated method stub
		
	}
	
}