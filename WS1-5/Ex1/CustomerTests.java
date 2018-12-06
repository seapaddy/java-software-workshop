import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CustomerTests {
	private Good item1, item2, item3, item4, item5;
	private CustomerWithGoods customer1, customer2, customer3, customer4, customer5;
	private ArrayList<Good> emptyOrder, orderList1, orderList2, orderList3, orderList4;
	private CustomerBase allCustomers;

	@Before
	public void setUp() {
		item1 = new Good("item1", 100);
		item2 = new Good("item2", 200);
		item3 = new Good("item3", 500);
		item4 = new Good("item4", 1000);
		item5 = new Good("item5", 2000);

		emptyOrder = new ArrayList<Good>();
		orderList1 = new ArrayList<Good>(Arrays.asList(item1, item2, item3));
		orderList2 = new ArrayList<Good>(Arrays.asList(item4, item5));
		orderList3 = new ArrayList<Good>(Arrays.asList(item1, item3, item5));
		orderList4 = new ArrayList<Good>(Arrays.asList(item4));

		customer1 = new CustomerWithGoods("customer1", "", "", emptyOrder);
		customer2 = new CustomerWithGoods("customer2", "", "", orderList1);
		customer3 = new CustomerWithGoods("customer3", "", "", orderList2);
		customer4 = new CustomerWithGoods("customer4", "", "", orderList3);
		customer5 = new CustomerWithGoods("customer5", "", "", orderList4);

		allCustomers = new CustomerBase(
				new ArrayList<CustomerWithGoods>(Arrays.asList(customer1, customer2, customer3, customer4, customer5)));

	}

	/**
	 * test the addition of goods to orders of customers within customerWithGoods
	 * objects. Also tests the toString method of customer with goods objects.
	 */
	@Test
	public void test1() {
		String expected1 = "customer1 has ordered: [] The goods have a total value of: \u00240.0";
		String actual1 = customer1.toString();

		assertEquals(expected1, actual1);

		customer1.buy(item4);

		String expected2 = "customer1 has ordered: [item4: \u002410.0] The goods have a total value of: \u002410.0";
		String actual2 = customer1.toString();

		assertEquals(expected2, actual2);
	}

	/**
	 * tests getGoods returns an ArrayList of goods, empty if customer has ordered
	 * no goods
	 */
	@Test
	public void test2() {
		ArrayList<Good> expected1 = new ArrayList<Good>(Arrays.asList(item1, item3, item5));
		ArrayList<Good> actual1 = customer4.getGoods();

		assertEquals(expected1, actual1);

		ArrayList<Good> expected2 = new ArrayList<Good>();
		ArrayList<Good> actual2 = customer1.getGoods();

		assertEquals(expected2, actual2);
	}

	/**
	 * tests valueOfGoods method, should return the total value of the customers
	 * goods in cents
	 */
	@Test
	public void test3() {
		int expected = 800;
		int actual = customer2.valueOfGoods();

		assertEquals(expected, actual);
	}

	/**
	 * test goods object. toString method of the good objects, should return a
	 * String representation with the goods name and price in dollars. getPrice
	 * should return the price of the good
	 */
	@Test
	public void test4() {
		String expected1 = "item1: \u00241.0";
		String actual1 = item1.toString();

		assertEquals(expected1, actual1);

		int expected2 = 2000;
		int actual2 = item5.getPrice();

		assertEquals(expected2, actual2);
	}

	/**
	 * test filterLoyal method returns all loyal customers with greater than average
	 * order quantity
	 */
	@Test
	public void test5() {
		ArrayList<CustomerWithGoods> expected = new ArrayList<CustomerWithGoods>(
				Arrays.asList(customer2, customer3, customer4));
		ArrayList<CustomerWithGoods> actual = allCustomers.filterLoyal();

		assertEquals(expected, actual);
	}

	/**
	 * test filteredValue method returns all rich customers with greater than
	 * average order price
	 */
	@Test
	public void test6() {
		ArrayList<CustomerWithGoods> expected = new ArrayList<CustomerWithGoods>(Arrays.asList(customer3, customer4));
		ArrayList<CustomerWithGoods> actual = allCustomers.filterValued();

		assertEquals(expected, actual);
	}
}
