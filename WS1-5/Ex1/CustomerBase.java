import java.util.ArrayList;

/**
 * CustomerBase class is the blueprint for CustomerBase Objects, which contain
 * an ArrayList of customers with goods. Methods contained within the
 * CustomerBase object calculate the average order quantity of all customers,
 * customers with a greater than average number of orders and customers whose
 * overall goods value is above the average value of all customer goods orders.
 * The average order quantity is returned as an integer value and other
 * calculations returned as ArrayList of customers with goods.
 * 
 * @author Seapaddy
 * @version 2017-11-28
 */
public class CustomerBase {
	private ArrayList<CustomerWithGoods> allCustomers;

	/**
	 * Constructor for the Customer Base Object
	 * 
	 * @param allCustomers
	 *            receives an ArrayList containing customers with goods
	 */
	public CustomerBase(ArrayList<CustomerWithGoods> allCustomers) {
		super();
		this.allCustomers = allCustomers;
	}

	/**
	 * Adds a customer with goods to the ArrayList of all customers
	 * 
	 * @param customer
	 *            receives a CustomerWithGoods object, customer
	 */
	public void addCustomer(CustomerWithGoods customer) {
		this.allCustomers.add(customer);
	}

	/**
	 * Method working out the average order quantity of all the customers. No need
	 * to return double as orders are all integers, comparing greater than so double
	 * is not needed for calculations in filterLoyal method. Searches through each
	 * customer in turn, sums Goods of all customers and returns the number of goods
	 * over the number of total customers to find the average order size.
	 * 
	 * @return the integer average order quantity of the customers
	 */
	public int averageOrderQuantity() {
		int orderQuantity = 0;

		for (CustomerWithGoods customerWithGoods : allCustomers) {
			orderQuantity += customerWithGoods.getGoods().size();
		}
		return orderQuantity / allCustomers.size();
	}

	/**
	 * Uses the average order quantity method to find the average order size of all
	 * customers. Returns all customers with greater than average orders as an
	 * ArrayList of Customers with Goods
	 * 
	 * (Only need integer values for average order as compare greater than with
	 * integer values of orders, double values are not needed in this case)
	 * 
	 * @return an ArrayList of customers with orders greater than the average order
	 *         size
	 */
	public ArrayList<CustomerWithGoods> filterLoyal() {
		ArrayList<CustomerWithGoods> loyalCustomers = new ArrayList<>();
		// uses method above to calculate the average order quantity
		int averageOrder = averageOrderQuantity();

		for (CustomerWithGoods customerWithGoods : allCustomers) {
			// if customer has above average order, added to return array
			if (customerWithGoods.getGoods().size() > averageOrder) {
				loyalCustomers.add(customerWithGoods);
			}
		}
		return loyalCustomers;
	}

	/**
	 * Method works out the average price of orders, price is integer therefore
	 * return integer as don't need greater accuracy for comparisons of goods value.
	 * Loops through all customers, sums orderTotal of each customers valueOfGoods.
	 * orderTotal will be total cost of all goods ordered by customers after loop.
	 * To find average order price, divide total cost of all goods by the number of
	 * total customers with goods
	 * 
	 * @return the integer average value of customers order values
	 */
	public int averageOrderPrice() {
		int orderTotal = 0;

		for (CustomerWithGoods customerWithGoods : allCustomers) {
			orderTotal += customerWithGoods.valueOfGoods();
		}
		return orderTotal /= allCustomers.size();
	}

	/**
	 * Uses the average order price method to find the average order price of all
	 * customers. Compares customers value of goods to average order price, if value
	 * of goods is greater, method adds the customer with goods to the return
	 * ArrayList. Returns all customers with greater than average order price as an
	 * ArrayList of Customers with Goods.
	 * 
	 * (Only need integer values for average price as compare greater than, with
	 * integer prices, double values are not needed in this case for comparison)
	 * 
	 * @return the ArrayList of customers who have spent a greater than average
	 *         amount on goods.
	 */
	public ArrayList<CustomerWithGoods> filterValued() {
		ArrayList<CustomerWithGoods> richCustomers = new ArrayList<>();
		// uses method above to calculate average order price
		int averageOrderPrice = averageOrderPrice();

		for (CustomerWithGoods customerWithGoods : allCustomers) {
			if (customerWithGoods.valueOfGoods() > averageOrderPrice) {
				richCustomers.add(customerWithGoods);
			}
		}
		return richCustomers;
	}

}
