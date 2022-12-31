package app;

/**
 * Class for Salable Product including getters and setters for each property.
 * Superclass for Armor, Health and Weapon
 * 
 * @author Alastair Sagar
 *
 */

public abstract class SalableProduct {
	// Class properties
	private String name;
	private String description;
	private double price;
	private int quantity;

	/**
	 * Constructor for SalableProduct
	 * 
	 * @param name
	 * @param description
	 * @param price
	 * @param quantity
	 */
	public SalableProduct(String name, String description, double price, int quantity) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * @return getter for name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name setter for the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return getter for description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param setter for the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return getter for price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param setter for the price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return getter for quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param setter for the quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// toString method to convert object to String format
	@Override
	public String toString() {
		return "Product Info: \n[Product Name:" + name + ", \nDescription:" + description + ", \nPrice: $" + price
				+ ", \nQuantity:" + quantity + "]";
	}
	/**
	 * Override equals method method so objects can be compared.
	 */
	@Override
	 public boolean equals(Object obj) {
	      if (this == obj)
	         return true;
	      if (obj == null)
	         return false;
	      if (getClass() != obj.getClass())
	         return false;
	      SalableProduct other = (SalableProduct) obj;
	      return (this.name == other.name && this.quantity == other.quantity);
	      
	   }

}
