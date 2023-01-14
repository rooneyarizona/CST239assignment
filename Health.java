package app;

/**
 * Subclass extending Salable Product with alternative class properties and getters and setters
 * 
 * @author Alastair Sagar
 *
 */
public class Health extends SalableProduct {
	/**
	 * 
	 * @param name        inherited from SalableProduct
	 * @param description inherited from SalableProduct
	 * @param price       inherited from SalableProduct
	 * @param quantity    inherited from SalableProduct
	 */
	private int boost;

	public Health(String name, String description, double price, int quantity, int boost) {
		super(name, description, price, quantity);
		this.boost = boost;
		/**
		 * Health Constructor
		 */
	}
	/**
	 * @return the boost
	 */
	public int getBoost() {
		return boost;
	}

	/**
	 * @param boost the boost to set
	 */
	public void setBoost(int boost) {
		this.boost = boost;
	}

}