package app;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
	private ArrayList<SalableProduct> inventory;

	public InventoryManager() {
		inventory = new ArrayList<SalableProduct>();
	}
	//Adds SalableProduct to inventory ArrayList
	public void addProduct(SalableProduct product) {
		inventory.add(product);
	}
	//Removes SalableProduct to inventory ArrayList
	public void removeProduct(SalableProduct product) {
		inventory.remove(product);
	}
	//Decreases quantity of SalableProduct object when called from ShoppingCart
	public void decreaseQuantity(SalableProduct product, int quantity) {
		if (product.equals(product)) {
			product.setQuantity(product.getQuantity() - quantity);
			System.out.println(product.getQuantity());
		}
	}
	//Increases quantity of SalableProduct object when called from ShoppingCart
	public void incraseQuantity(SalableProduct product, int quantity) {
		if (product.equals(product)) {
			product.setQuantity(product.getQuantity() + quantity);
			System.out.println(product.getQuantity());
		}
	}
	//Prints out all inventory items including name, description, quantity and price
	public void getInventory() {
		System.out.println(inventory);
	}
	//Inventory Management user menu using switch
	public void startInventoryManager() {
		Scanner scan = new Scanner(System.in);
		int choice = 0;

		System.out.println("Inventory Manager");
		
		//While loop to keep menu active until exited
		boolean inventoryMenu = true;
		while(inventoryMenu) {
		System.out.println("Please make a selection");
		System.out.println("1: Show Full Inventory");
		System.out.println("2: Go to Shopping Cart");
		System.out.println("3: Close Program");
		choice = scan.nextInt();

		
		switch (choice) {
		case 1:
			getInventory();
			break;
		case 2:
			inventoryMenu = false;
		case 3:
			inventoryMenu = false;
			
			break;
		default:
			System.out.println("Invalid selection. Please select an option");
			startInventoryManager();
			break;

		}
	}
	}

}