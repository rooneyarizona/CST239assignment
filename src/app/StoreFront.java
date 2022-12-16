package app;

/**
 * @author Alastair Sagar
 *
 */
public class StoreFront {
/**
 * Main driver method
 * @param args
 */
	public static void main(String[] args) {
		//Welcome message for store front
		System.out.println("Welcome to Store Front");
		System.out.println();

		//Creating instances of SalableProducts
		SalableProduct productOne = new SalableProduct("Test Product A", "This is the first product", 22.00, 20);
		SalableProduct productTwo = new SalableProduct("Test Product B", "This is the second product", 33.00, 70);
		SalableProduct productThree = new SalableProduct("Test Product C", "This is the third product", 44.00, 55);

		//Creating instance of InventoryManager
		InventoryManager categoryOne = new InventoryManager();
		
		//Creating ShoppingCart instance
		ShoppingCart cart = new ShoppingCart();

		//Testing initialization and toString() method
		System.out.println("Testing Constructor Intialization:\n" + productOne.toString());
		System.out.println();

		//Testing addProduct() method
		categoryOne.addProduct(productOne);
		System.out.println();

		//Testing checkQuantity() method
		categoryOne.checkQuantity();
		System.out.println();

		//Adding second SalableProduct to InventoryManager class object
		categoryOne.addProduct(productTwo);
		System.out.println();

		//Testing checkQuantity() will update
		categoryOne.checkQuantity();
		System.out.println();

		//Creating second InventoryManager object
		InventoryManager categoryTwo = new InventoryManager();

		//Tests to check each InventoryManager objects update in turn
		categoryTwo.addProduct(productThree);
		System.out.println();
		categoryTwo.checkQuantity();
		categoryOne.checkQuantity();
		categoryTwo.checkQuantity();
		System.out.println();
		//Testing product specific quantity
		categoryOne.checkQuantity(productOne);
		//Testing Shopping Cart Methods
		cart.purchaseProduct(productOne);
		cart.cancelPurchase(productOne);

	}

}
