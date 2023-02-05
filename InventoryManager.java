package app;
/**
 * Inventory Manager including methods to control invoked inventory from main method
 * 
 * 
 * @author Alastair Sagar
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryManager {
	// Generic List type Salable Product
	private List<SalableProduct> inventory;
		
	public InventoryManager() {
		this.inventory = new ArrayList<>();
		}

	// Add all inventory json inventory using Collections
	public void addProducts(List<SalableProduct> products) {
		inventory.addAll(products);
	}

	public void addProduct(SalableProduct product) {
		inventory.add(product);
	}

	// Removes SalableProduct to inventory ArrayList
	public void removeProduct(SalableProduct product) {
		inventory.remove(product);
	}

	// Outputs inventory in ascending order
	public synchronized void getInventory() {
		Collections.sort(inventory, new NameSort());
		for (SalableProduct inventory : inventory) {
			System.out.println("There are " + inventory.getQuantity() + " " + inventory.getName() + "s that cost $"
					+ inventory.getPrice() + " each");
		}
		System.out.println();
	}

	// Output inventory in descending order
	public void getInventoryDescending() {
		Collections.sort(inventory, new NameDescending());
		for (SalableProduct inventory : inventory) {
			System.out.println("There are " + inventory.getQuantity() + " " + inventory.getName() + "s that cost $"
					+ inventory.getPrice() + " each");
		}
		System.out.println();
	}

	// Output inventory by price in ascending order
	public void inventoryPrice() {
		Collections.sort(inventory, new PriceSort());
		for (SalableProduct inventory : inventory) {
			System.out.println("Product Name: " + inventory.getName() + " | Price: $" + inventory.getPrice() + ".");

		}
	}

	// Output inventory by price in descending order
	public void inventoryPriceDescending() {
		Collections.sort(inventory, new PriceDescending());
		for (SalableProduct inventory : inventory) {
			System.out.println("Product Name: " + inventory.getName() + " | Price: $" + inventory.getPrice() + ".");

		}
	}

	public List<SalableProduct> getInventoryList() {
		return inventory;

	}

	public synchronized void addProduct(String jsonString) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(jsonString);

			if (jsonNode.has("power")) {
				Weapon weapon = mapper.treeToValue(jsonNode, Weapon.class);
				this.inventory.add(weapon);
			} else if (jsonNode.has("durability")) {
				Armor armor = mapper.treeToValue(jsonNode, Armor.class);
				this.inventory.add(armor);
			} else if (jsonNode.has("boost")) {
				Health health = mapper.treeToValue(jsonNode, Health.class);
				this.inventory.add(health);
			}

		} catch (IOException e) {
			System.out.println("Error Adding JSON Object. Please contact Alastair Sagar");
			System.exit(1);
		}
	}

	

	// Inventory Management user menu using switch
	public void startInventoryManager() {

		int choice = 0;

		System.out.println("Inventory Manager");

		// While loop to keep menu active until exited
		Scanner scan = new Scanner(System.in);
		boolean inventoryMenu = true;
		while (inventoryMenu) {
			System.out.println("Please make a selection");
			System.out.println("1: Show Full Inventory by Name");
			System.out.println("2: Show Full Inventory by Price");
			System.out.println("3: Go to Shopping Cart");

			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Do you want to sort name (1) ascending or (2) descending?");
				int input = scan.nextInt();
				if (input == 1) {
					getInventory();
				} else if (input == 2) {
					getInventoryDescending();
				}
				System.out.println();
				break;
			case 2:
				System.out.println("Do you want to sort (1) ascending or (2) descending?");
				int inputPrice = scan.nextInt();
				if (inputPrice == 1) {
					inventoryPrice();
				} else if (inputPrice == 2) {
					inventoryPriceDescending();
				}
				System.out.println();
				break;
			case 3:
				inventoryMenu = false;
				scan.close();

				break;
			default:
				System.out.println("Invalid selection. Please select an option");
				startInventoryManager();
				break;

			}
		}
	}
}