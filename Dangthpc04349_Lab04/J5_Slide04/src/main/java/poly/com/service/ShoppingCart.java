package poly.com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import poly.com.DAO.DB;
import poly.com.custom_interface.ShoppingCartServive;
import poly.com.entity.CartItem;

@SessionScope
@Service("giohang")
public class ShoppingCart implements ShoppingCartServive {
	Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();

	@Override
	public List<CartItem> getItems() {
		ArrayList<CartItem> ds = new ArrayList<CartItem>();
		for (Integer key : map.keySet()) {
			ds.add(map.get(key));
		}
		return ds;
	}

	@Override
	public void add(int id) {
		CartItem item = map.get(id);
		if (item == null) {
			item = new CartItem(DB.items.get(id));
			item.setQty(1);
		} else
			item.setQty(item.getQty());
		map.put(id, item);
	}

	@Override
	public void remove(int id) {
		if (map.containsKey(id)) {
			map.remove(id);
		}

	}

	@Override
	public void update(int id, int qty) {
		CartItem item = map.get(id);
		if (item != null) {
			item.setQty(qty);
			map.put(id, item);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return map.keySet().size();
	}

	@Override
	public double getAmount() {
		Double tongtien = 0.0;
		CartItem item = null;
		for (Integer id : map.keySet()) {
			item = map.get(id);
			tongtien += item.getPrice() * item.getQty();
		}
		return tongtien;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		map.clear();
	}

}
