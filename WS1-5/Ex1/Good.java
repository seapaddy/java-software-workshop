/**
 * Good class is the blueprint for a Good object. Each Good has a name and a
 * price. The idea of these objects is that they are goods that can be ordered
 * by customers.
 * 
 * @author Seapaddy
 * @version 2017-11-28
 */
public class Good {
	private String name;
	private int price;

	/**
	 * Constructor for a Good object
	 * 
	 * @param name
	 *            The name of the good
	 * @param price
	 *            The price of the good in cents
	 */
	public Good(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	/**
	 * Gets the price of a good, in cents
	 * 
	 * @return The price of the good
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return A string representation of the Good object
	 */
	@Override
	public String toString() {
		return name + ": \u0024" + price / 100 + "." + price % 100;
	}

}
