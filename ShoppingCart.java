package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * This class is to allow the user to make and cancel purchases
 * 
 * @author Alastair Sagar
 *
 */
public class ShoppingCart {
	//Generic List 
	private ArrayList<SalableProduct> cart;

	public ShoppingCart() {
		this.cart = new ArrayList<>();
	}

	// Adds product to cart ArrayList and adjusts quantity using equals method
	public void addItem(SalableProduct product, int quantity) {
		cart.add(product);
		if (product.getName().equals(product.getName())) {
			product.setQuantity(product.getQuantity() - quantity);
			System.out.println(quantity + " " + product.getName() + "(s) have been added to your Shopping Cart");
		}
	}

	// Removes product from cart ArrayList and adjusts quantity using equals method
	public void removeItem(SalableProduct product, int quantity) {
		cart.remove(product);
		if (product.getName().equals(product.getName())) {
			product.setQuantity(product.getQuantity() + quantity);
			System.out.println(quantity + " " + product.getName() + "(s) have been removed from your Shopping Cart");
		}
	}

	// Clear all items in the shopping cart
	public void emptyCart() {
		cart.clear();
		printCart();
	}
	//Returns ShoppingCart List
	public List<SalableProduct> getCart() {
	    return cart;
	}

	// Method to loop through Cart ArrayList to display items that have been added
	public void printCart() {
		System.out.println("Your shopping cart has the following items:");
		// Will sort array list in alphabetical order
		Collections.sort(cart, new NameSort());
		for (SalableProduct products : cart) {
			System.out.println(products.getName());
		}
		System.out.println();
	}

}
