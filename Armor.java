package app;

/**
 * Subclass extending Salable Product with alternative class properties and
 * getters and setters
 * 
 * @author Alastair Sagar
 *
 */

public class Armor extends SalableProduct {
	/**
	 * 
	 * @param name        inherited from SalableProduct
	 * @param description inherited from SalableProduct
	 * @param price       inherited from SalableProduct
	 * @param quantity    inherited from SalableProduct
	 * @param durability  - unique to Armor class
	 * @param protection  - unique to Armor class
	 * @param color       - unique to Armor class
	 */
	private int durability;
	private int protection;
	private String color;

	/**
	 * Default constructor
	 */
	public Armor() {

	}

	/**
	 * Armor Constructor with all class properties
	 */
	public Armor(String name, String description, double price, int quantity, String color, int durability,
			int protection) {
		super(name, description, price, quantity);
		this.durability = durability;
		this.color = color;
		this.protection = protection;

	}

	/**
	 * @return the durability
	 */
	public int getDurability() {
		return durability;
	}

	/**
	 * @param durability the durability to set
	 */
	public void setDurability(int durability) {
		this.durability = durability;
	}

	/**
	 * @return the protection
	 */
	public int getProtection() {
		return protection;
	}

	/**
	 * @param protection the protection to set
	 */
	public void setProtection(int protection) {
		this.protection = protection;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Overrides toString method to include all Armor class properties
	 */
	@Override
	public String toString() {
		return "Product Info: \n[Product Name:" + super.getName() + ", \nDescription:" + super.getDescription()
				+ ", \nPrice: $" + super.getPrice() + ", \nDurability:" + durability + ", \nProtection:" + protection
				+ ", \nColor:" + color + ",\nQuantity:" + super.getQuantity() + "]\n";

	}

	@Override
	public int compareTo(SalableProduct o) {
		
		return 0;
	}

	

	
}