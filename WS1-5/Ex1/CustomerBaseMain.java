import java.util.ArrayList;
import java.util.Arrays;

/**
 * CustomerBaseMain class contains a main method to test the construction of
 * customer objects and the evaluations of those customer objects.
 * 
 * @author Seapaddy
 * @version 2017-11-28
 */
public class CustomerBaseMain {
	/**
	 * main method to define objects and test methods
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// create some good objects
		Good biscuit = new Good("Biscuit", 299);
		Good apple = new Good("Apple", 199);
		Good lemon = new Good("Lemon", 250);
		Good fish = new Good("Fish", 1005);
		Good banana = new Good("Banana", 400);
		Good lamb = new Good("Lamb", 1500);

		// define some shopping lists
		ArrayList<Good> shoppingOrder1 = new ArrayList<Good>(Arrays.asList(biscuit, apple, apple));
		ArrayList<Good> shoppingOrder2 = new ArrayList<Good>(Arrays.asList(lemon, fish));
		ArrayList<Good> shoppingOrder3 = new ArrayList<Good>(Arrays.asList(banana, lamb, apple));
		ArrayList<Good> shoppingOrder4 = new ArrayList<Good>(Arrays.asList(biscuit, lemon, banana, lamb));
		ArrayList<Good> shoppingOrder5 = new ArrayList<Good>(Arrays.asList());

		// given customers generic customer names to check code is working
		CustomerWithGoods customer1 = new CustomerWithGoods("Customer1", "", "", shoppingOrder1);
		CustomerWithGoods customer2 = new CustomerWithGoods("Customer2", "", "", shoppingOrder2);
		CustomerWithGoods customer3 = new CustomerWithGoods("Customer3", "", "", shoppingOrder3);
		CustomerWithGoods customer4 = new CustomerWithGoods("Customer4", "", "", shoppingOrder4);
		CustomerWithGoods customer5 = new CustomerWithGoods("Customer5", "", "", shoppingOrder5);

		// CustomerBase is an array list of all customers
		ArrayList<CustomerWithGoods> customers = new ArrayList<CustomerWithGoods>(
				Arrays.asList(customer1, customer2, customer3, customer4, customer5));
		CustomerBase allCustomers = new CustomerBase(
				new ArrayList<CustomerWithGoods>(Arrays.asList(customer1, customer2, customer3, customer4)));
		// adds an additional customer to allCustomers customer base
		allCustomers.addCustomer(customer5);

		// Good methods
		System.out
				.println(biscuit.toString() + " -> This has returned the String representation of the biscuit object");
		System.out.println(biscuit.getPrice() + " -> This returns the price in cents of the biscuit object");
		System.out.println();

		// CustomerWithGoods methods
		System.out.println(
				customer3.toString() + " -> This returns the String representation of the customer name with goods");
		customer3.buy(apple);
		System.out.println(customer3.toString()
				+ " -> This returns the String representation of same customer with an additional added good");
		System.out.println(customer3.valueOfGoods() + " -> This returns the total value of customer3 goods in cents");
		System.out.println();

		// CustomerBase methods
		// Loyal customers
		ArrayList<CustomerWithGoods> loyalCustomers = allCustomers.filterLoyal();
		for (CustomerWithGoods customerWithGoods : loyalCustomers) {
			System.out.print(customerWithGoods.getCustomerName() + ", ");
		}
		System.out.println(
				" -> This returns the loyal customers names who have puchased over the average number of goods");
		System.out.println("Average order quantity is " + allCustomers.averageOrderQuantity());
		for (CustomerWithGoods customerWithGoods : customers) {
			System.out.println(customerWithGoods.getCustomerName() + ": " + customerWithGoods.getGoods().size());
		}
		System.out.println();

		ArrayList<CustomerWithGoods> richCustomers = allCustomers.filterValued();
		for (CustomerWithGoods customerWithGoods : richCustomers) {
			System.out.print(customerWithGoods.getCustomerName() + ", ");
		}
		System.out.println(" -> This returns the rich customers names who have spent over the average price on goods");
		System.out.println("Average order price is \u0024" + allCustomers.averageOrderPrice() / 100 + "."
				+ allCustomers.averageOrderPrice() % 100);
		for (CustomerWithGoods customerWithGoods : customers) {
			System.out.println(customerWithGoods.getCustomerName() + ": \u0024" + customerWithGoods.valueOfGoods() / 100
					+ "." + customerWithGoods.valueOfGoods() % 100);
		}
		System.out.println();

		System.out.print("The customers whom have a value of goods above the average are: ");
		for (int i = 0; i < richCustomers.size(); i++) {
			System.out.print(richCustomers.get(i).getCustomerName());
			if (i == richCustomers.size() - 1) {
				System.out.println(".");
			} else
				System.out.print(", ");
		}
	}
}
