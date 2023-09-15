package poly.com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
	private Integer id;
	private String name;
	private double price;
	private int qty = 1;

	public CartItem(CartItem item) {
		this.id = item.getId();
		this.name = item.getName();
		this.price = item.getPrice();
		this.qty = 1;
	}

}
