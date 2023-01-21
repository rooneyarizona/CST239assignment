package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Main driver method to invoke inventory from json file and user menu
 * integrating shopping cart and inventory manager
 * 
 * @author Alastair Sagar
 *
 */
public class StoreFront {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// Instance of InventoryManager created
		InventoryManager im = new InventoryManager();
		// Instance of ShoppingCart created
		ShoppingCart cart = new ShoppingCart();

		// Initializes store inventory from JSON file.
		ArrayList<SalableProduct> inventory = new ArrayList<SalableProduct>();
		final String jsonFile = "inventory.json";
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File(jsonFile);
			JsonNode rootNode = mapper.readTree(file);

			for (JsonNode node : rootNode) {
				if (node.has("power")) {
					Weapon weapon = mapper.treeToValue(node, Weapon.class);
					inventory.add(weapon);
				} else if (node.has("durability")) {
					Armor armor = mapper.treeToValue(node, Armor.class);
					inventory.add(armor);
				} else if (node.has("boost")) {
					Health health = mapper.treeToValue(node, Health.class);
					inventory.add(health);
				}
			}
		} catch (IOException e) {

			System.out.println("There is an error with file input. Please contact Alastair Sagar!");
			System.exit(1);
		}
		//iterates through inventory to add SalableProducts to InventoryManager ArrayList
		for (SalableProduct product : inventory) {
			im.addProduct(product);
		}
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		int quantity = 1;
		// Displays the name of the Store Front and a Welcome Message to the console.
		boolean menu = true;
		while (menu) {
			System.out.println("Welcome to the GCU Game Store!\n");
			System.out.println("What would you like to do?");
			System.out.println("1. Inventory Manager\n2. Shopping Cart\n3. Close Program");

			choice = scan.nextInt();
		//Executes a desired Store Front action based on keyboard entry from the User.
			switch (choice) {
			case 1:// Starts Inventory Manager Menu
				im.startInventoryManager();
			case 2:// Starts Shopping Cart Menu
				boolean cartMenu = true;
				while (cartMenu) {
		//Displays a list of actions for the User to interact with the Store Front
		//Displays appropriate detailed feedback and error messages to the User through the console.
				System.out.println("What would you like to do?\n");
				System.out.println("1: Make Purchase");
				System.out.println("2: Cancel Purchase");
				System.out.println("3: Show Shopping Cart Items");
				System.out.println("4: Empty Shopping Cart");
				System.out.println("5: Go to Inventory Manager");
				System.out.println("6: Close Program");

				int startCart = 0;
				startCart = scan.nextInt();

				switch (startCart) {
				case 1:
				System.out.println("Which Item Would you like to add?");
				System.out.println("1. Gun\n2: Sword\n3: Helmet\n4: Shield\n5: Health");
				int cartAdd = scan.nextInt();
				System.out.println("How many do you want to buy?");
				quantity = scan.nextInt();
				//Adds items to Shopping Cart if user input matches SalableProduct identifier
					if (cartAdd == 1) {
						cart.addItem(inventory.get(0), quantity);
					}
					if (cartAdd == 2) {
						cart.addItem(inventory.get(1), quantity);
					}
					if (cartAdd == 3) {
						cart.addItem(inventory.get(2), quantity);
					}
					if (cartAdd == 4) {
						cart.addItem(inventory.get(3), quantity);
					}
					if (cartAdd == 5) {
						cart.addItem(inventory.get(4), quantity);
					}
					break;
					case 2:// Removes items to Shopping Cart if user input matches SalableProduct
							// identifier
						cart.printCart();
						System.out.println("Which item would you like to remove?\n");
						System.out.println("1. Gun\n2: Sword\n3: Helmet\n4: Shield\n5: Health");
						int cartRemove = scan.nextInt();
						System.out.println("How many do you want to remove?");
						int quantityRemove = scan.nextInt();
						if (cartRemove == 1) {
							cart.removeItem(inventory.get(0), quantityRemove);
						}
						if (cartRemove == 2) {
							cart.removeItem(inventory.get(1), quantityRemove);
						}
						if (cartRemove == 3) {
							cart.removeItem(inventory.get(2), quantityRemove);
						}
						if (cartRemove == 4) {
							cart.removeItem(inventory.get(3), quantityRemove);
						}
						if (cartRemove == 5) {
							cart.removeItem(inventory.get(4), quantityRemove);
						}
						break;
					case 3:// Will print all items in cart ArrayList
						cart.printCart();
						break;
					case 4:// Empty Shopping Cart contents
						cart.emptyCart();
						break;
					case 5:
						im.startInventoryManager();
						cartMenu = false;
						break;
					case 6:// Stops cart menu loop to close program
						cartMenu = false;
						menu = false;
						break;
					}
				}

			case 3:// Stops Store Menu loop to close program
				System.out.println("Thank you and have a nice day!");
				menu = false;
				break;

			default:
				//Error message for incorrect input
				System.out.println("Invalid selection. Please select an option");
				break;

			}

		}

	}
}