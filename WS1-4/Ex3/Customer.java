/**
 * The Class Customer implements the interface Sortable. The Class consists of the
 * fields name, totalMoneySpent and address.
 * 
 * The class consists of a constructor, a toString method as well as
 * compareValue method (returns the totalMoneySpent by the customers)
 * 
 * @author Seapaddy
 * @version 2017-11-03
 */
public class Customer implements Sortable {
	private String name;
	private double totalMoneySpent;
	private String address;

	/**
	 * Constructor for the Customer Class
	 * @param name The name of the customer
	 * @param totalMoneySpent The total money spent by the customer
	 * @param address The address of the customer
	 */
	public Customer(String name, double totalMoneySpent, String address) {
		super();
		this.name = name;
		this.totalMoneySpent = totalMoneySpent;
		this.address = address;
	}

	/**
	 * @return A string representation of the customer
	 */
	@Override
	public String toString() {
		return "Customer [name=" + name + ", totalMoneySpent=" + totalMoneySpent + ", address=" + address + "]";
	}

	/**
	 * compareValue method returns the total money spent by the Customer
	 * @return total money spent by customer
	 */
	public double compareValue() {
		return totalMoneySpent;
	}

}
