package app;
/**
 * 
 * @author Alastair Sagar
 *A child class of SalableProduct for Health products
 */
public class Health extends SalableProduct {
	/**
	 * 
	 * @param name inherited from SalableProduct 
	 * @param description inherited from SalableProduct
	 * @param price inherited from SalableProduct
	 * @param quantity inherited from SalableProduct
	 */
	public Health(String name, String description, double price, int quantity) {
		super(name, description, price, quantity);
		/**
		 * Health Constructor
		 */
	}
}