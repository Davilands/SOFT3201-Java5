package poly.com.custom_interface;

import java.util.List;

import poly.com.entity.CartItem;

public interface ShoppingCartServive {
	List<CartItem> getItems();

	void add(int id);

	void remove(int id);

	void update(int id, int qty);

	void clear();

	int getCount();

	double getAmount();
}
