package app;

/**
 * Subclass extending Salable Product with alternative class properties and
 * getters and setters
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
	 * @param boost       - unique to Health class
	 */
	private int boost;

	/**
	 * Default constructor
	 */
	public Health() {
	}

	public Health(String name, String description, double price, int quantity, int boost) {
		super(name, description, price, quantity);
		this.boost = boost;
		/**
		 * Health Constructor with class properties
		 */
	}

	/**
	 * @return Getter to return the boost
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

	/**
	 * Override toString method to include Health class properties
	 */
	@Override
	public String toString() {
		return "Product Info: \n[Product Name:" + super.getName() + ", \nDescription:" + super.getDescription()
				+ ", \nPrice: $" + super.getPrice() + ", \nBoost:" + boost + ", \nQuantity:" + super.getQuantity()
				+ "]\n";

	}

	@Override
	public int compareTo(SalableProduct o) {
		
		return 0;
	}

	
}