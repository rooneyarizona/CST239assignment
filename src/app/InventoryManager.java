package app;

/**
 * @author Alastair Sagar
 *
 */
public class InventoryManager {
	/**
	 * InventoryManager properties
	 */
	private SalableProduct products;
	private int quantity = 0;

	/**
	 * Method to check the quantity of each InventoryManager object associated with
	 * Salable Product and total category Inventory
	 */
	public void checkQuantity() {
		System.out.println("Total Inventory Quantity: " + quantity);
		//FIXME: Implement a checkQuantity for all inventory but also each SalableProduct instance
	}
	/**
	 * 
	 * @param Method to check individual product quantity available. This will develop in future milestones
	 */
	public void checkQuantity(SalableProduct product) {
		System.out.println("Total quantity for this item is: +" + product.getQuantity());
	}

	/**
	 * @param Method to add SalableProduct object to InventoryManager and increase
	 *               quantity
	 */
	public void addProduct(SalableProduct product) {
		SalableProduct testProduct = product;
		System.out.println("Testing addProduct()\n" + testProduct);
		quantity++;
	}
}
