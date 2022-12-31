package app;

import java.util.Scanner;

/**
 * @author Alastair Sagar Main driver method
 * 
 */
public class StoreFront {
	/**
	 * Main driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Instance of InventoryManager created
		InventoryManager im = new InventoryManager();
		//Instance of ShoppingCart created
		ShoppingCart cart = new ShoppingCart();
		Scanner scan = new Scanner(System.in);
		//SalableProduct child class instances created for each product
		Weapon gun = new Weapon("Gun", "This is a gun", 250.00, 100);
		Weapon sword = new Weapon("Sword", "Medieval Sword", 1000.00, 25);
		Armor shield = new Armor("Shield", "Protect against most weapons", 99.00, 10);
		Armor helmet = new Armor("Helmet", "wear on head for protection", 59.00, 7);
		Health health = new Health("Health", "Increase health by 20%", 30.00, 100);
		//Products added to inventory manager ArrayList
		im.addProduct(sword);
		im.addProduct(shield);
		im.addProduct(helmet);
		im.addProduct(health);
		im.addProduct(gun);
		
		
		int choice = 0;
		int quantity = 1;
		//User Menu to navigate to Inventory Manager and Shopping Cart
		boolean menu = true;
		while(menu) {
System.out.println("Welcome to the GCU Store!\n");
System.out.println("What would you like to do?");
System.out.println("1. Inventory Manager\n2. Shopping Cart\n3. Close Program");

choice =scan.nextInt();

switch (choice) {
case 1://Starts Inventory Manager Menu
	im.startInventoryManager();
	
case 2://Starts Shopping Cart Menu
boolean cartMenu = true;
	
	while(cartMenu) {
	
	System.out.println("What would you like to do?\n");
	System.out.println("1: Make Purchase");
	System.out.println("2: Cancel Purchase");
	System.out.println("3: Show Shopping Cart Items");
	System.out.println("4: Go to Inventory Manager");
	System.out.println("5: Close Program");
	
	int startCart = 0;
	startCart= scan.nextInt();
	
	switch (startCart) {
	case 1:
		System.out.println("Which Item Would you like to add?");
		System.out.println("1. Gun\n2: Sword\n3: Helmet\n4: Shield\n5: Health");
		int cartAdd = scan.nextInt();
		System.out.println("How many do you want to buy?");
		quantity = scan.nextInt();
		//Adds items to Shopping Cart if user input matches SalableProduct identifier
		if(cartAdd == 1) {
			cart.addItem(gun, quantity);}
		if(cartAdd ==2) {
			cart.addItem(sword, quantity);}
		if(cartAdd ==3) {
			cart.addItem(helmet, quantity);}
		if(cartAdd == 4) {
			cart.addItem(shield, quantity);}
		if(cartAdd == 5) {
			cart.addItem(health, quantity);}			
		break;
	case 2://Removes items to Shopping Cart if user input matches SalableProduct identifier
		cart.printCart();
		System.out.println("Which item would you like to remove?\n");
		System.out.println("1. Gun\n2: Sword\n3: Helmet\n4: Shield\n5: Health");
		int cartRemove = scan.nextInt();
		//Adds items to Shopping Cart if user input matches SalableProduct identifier
		if(cartRemove == 1) {
			cart.removeItem(gun, quantity);}
		if(cartRemove ==2) {
			cart.removeItem(sword, quantity);}
		if(cartRemove ==3) {
			cart.removeItem(helmet, quantity);}
		if(cartRemove == 4) {
			cart.removeItem(shield, quantity);}
		if(cartRemove == 5) {
			cart.removeItem(health, quantity);}			
		break;
	case 3://Will print all items in cart ArrayList
		cart.printCart();
		 break;
	case 4:
		im.startInventoryManager();
		cartMenu = false;
		break;
	case 5://Stops cart menu loop to close program
		cartMenu = false;
		menu = false;
		break;
		}
	}

case 3://Stops Store Menu loop to close program
	System.out.println("Thank you and have a nice day!");
	menu = false;
	break;
	
default:
	System.out.println("Invalid selection. Please select an option");
	break;

}
		
}
	
}
}

