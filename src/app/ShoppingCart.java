package app;

/**
 * @author Alastair Sagar
 *
 */
public class ShoppingCart {
	private SalableProduct product;
	/**
	 * Method which will add SalableProduct to ShoppingCart instance
	 */
	public static void purchaseProduct(SalableProduct product) {
		System.out.println("Test: You have purchased: " + product.getName());
	}
/**
 * Method which will remove SalableProduct from ShoppingCart instance
 */
	public static void cancelPurchase(SalableProduct product) {
		System.out.println("Test: You have canceled purchase of: " + product.getName());
	}

}
