import java.util.ArrayList;

/**
 * CustomerWithGoods class extends the Customer class and provides the blueprint
 * for a customer object with an additional field, goods. The goods variable is
 * an ArrayList of Good objects, that stores the goods each customer has
 * ordered.
 * 
 * @author Seapaddy
 * @version 2017-11-28
 */
public class CustomerWithGoods extends Customer {
	private ArrayList<Good> goods;

	/**
	 * Constructor for a CustomerWithGoods object
	 * 
	 * @param customerName
	 *            The customers' name
	 * @param address
	 *            The customers' address
	 * @param telephoneNumber
	 *            The customers' telephone number
	 * @param goods
	 *            The customers' goods orders
	 */
	public CustomerWithGoods(String customerName, String address, String telephoneNumber, ArrayList<Good> goods) {
		super(customerName, address, telephoneNumber);
		this.goods = goods;
	}

	/**
	 * Gets the customers goods
	 * 
	 * @return The customers ArrayList of goods
	 */
	public ArrayList<Good> getGoods() {
		return goods;
	}

	/**
	 * Adds goods to a customers' order ArrayList of goods
	 * 
	 * @param good
	 *            The good added to the customers' ArrayList of ordered goods
	 */
	public void buy(Good good) {
		this.goods.add(good);
	}

	/**
	 * Calculates the values of a customers' goods
	 * 
	 * @return The value of the goods a customer has ordered
	 */
	public int valueOfGoods() {
		int totalValue = 0;
		for (int i = 0; i < goods.size(); i++) {
			totalValue += goods.get(i).getPrice();
		}
		return totalValue;
	}

	/**
	 * @return A string representation of a customer with goods
	 */
	@Override
	public String toString() {
		return super.getCustomerName() + " has ordered: " + goods + " The goods have a total value of: \u0024"
				+ valueOfGoods()/100 + "." + valueOfGoods()%100;
	}

}
