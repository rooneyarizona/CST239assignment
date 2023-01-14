package app;

/**
 * Subclass extending Salable Product with alternative class properties and getters and setters
 * 
 * @author Alastair Sagar
 *
 */
public class Weapon extends SalableProduct {
	/**
	 * 
	 * @param name        inherited from SalableProduct
	 * @param description inherited from SalableProduct
	 * @param price       inherited from SalableProduct
	 * @param quantity    inherited from SalableProduct
	 */
	private int power;
	private String color;

	public Weapon(String name, String description, double price, int quantity, int power, String color) {
		super(name, description, price, quantity);
		this.power = power;
		this.color = color;
	}

	/**
	 * @return the power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(int power) {
		this.power = power;
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

}