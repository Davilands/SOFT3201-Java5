package poly.com.DAO;

import java.util.HashMap;
import java.util.Map;

import poly.com.entity.CartItem;

public class DB {
	public static Map<Integer, CartItem> items = new HashMap<>();
	static {
		items.put(1, new CartItem(1, "Samsung", 10.0, 0));
		items.put(2, new CartItem(2, "Nokia 2021", 20.50, 0));
		items.put(3, new CartItem(3, "IPhone 20", 90.49, 0));
		items.put(4, new CartItem(4, "Motorola", 15.55, 0));
		items.put(5, new CartItem(5, "Seamen", 8.99, 0));
		items.put(6, new CartItem(6, "Sony M1", 9.99, 0));
		items.put(7, new CartItem(6, "VSmart", 5.99, 0));
	}
}
