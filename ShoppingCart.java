package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is to allow the user to make and cancel purchases
 * 
 * @author Alastair Sagar
 *
 */
public class ShoppingCart {

	private ArrayList<SalableProduct> cart;

	public ShoppingCart() {

		this.cart = new ArrayList<>();
	}
	//Adds product to cart ArrayList and adjusts quantity using equals method override
	public void addItem(SalableProduct product, int quantity) {
		cart.add(product);
		if (product.equals(product)) {
			product.setQuantity(product.getQuantity() - quantity);
			System.out.println(quantity + " " + product.getName() + "(s) have been added to your Shopping Cart");
		}
	}
	//Removes product from cart ArrayList and adjusts quantity using equals method override
	public void removeItem(SalableProduct product, int quantity) {
		cart.remove(product);
		if (product.equals(product)) {
			product.setQuantity(product.getQuantity() + quantity);
			System.out.println(quantity + " " + product.getName() + "(s) have been removed from your Shopping Cart");
		}
	}
	
	//Method to loop through Cart ArrayList to display items that have been added
	public void printCart() {
		System.out.println("Your shopping cart has the following items:");
		for (SalableProduct carts : cart) {
			System.out.println(carts.getName());
					}
		System.out.println();
	}

}
