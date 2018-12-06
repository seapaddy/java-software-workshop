import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for Car and Customer Class' Tests for Sortable and Sorting Interfaces
 * 
 * @author Seapaddy
 * @version 2017-11-13
 *
 */
public class Ws4Ex3Tests {

	public static final double EPSILON = 1e-6;

	private Sortable sort1, sort2, sort3, sort4, sort5, sort6;

	/**
	 * test for compareValue() for Car
	 */
	@Test
	public void test1() {

		sort1 = new Car(223.6, "KN02 GDJ", "Aston Martin");

		double expected = 223.6;
		double actual = sort1.compareValue();

		assertEquals(expected, actual, EPSILON);
	}

	/**
	 * test toString method for Car
	 */
	@Test
	public void test2() {

		sort2 = new Car(100.3, "IJ15 HKI", "Vauxhall");

		String expected = "Car [maxSpeed=100.3, carNumber=IJ15 HKI, make=Vauxhall]";
		String actual = sort2.toString();

		assertEquals(expected, actual);
	}

	/**
	 * test for compareValue() for Customer
	 */
	@Test
	public void test3() {

		sort3 = new Customer("Indigo", 112.12, "Birmingham");

		double expected = 112.12;
		double actual = sort3.compareValue();

		assertEquals(expected, actual, EPSILON);
	}

	/**
	 * test toString method for Customer
	 */
	@Test
	public void test4() {

		sort4 = new Customer("David", 20.02, "Egypt");

		String expected = "Customer [name=David, totalMoneySpent=20.02, address=Egypt]";
		String actual = sort4.toString();

		assertEquals(expected, actual);
	}

	/**
	 * test quicksort for an array a of Cars
	 */
	@Test
	public void test5() {

		sort1 = new Car(120.2, "HG09 JIE", "Ford");
		sort2 = new Car(80.7, "WK75 JDI", "Peugeot");
		sort3 = new Car(62.3, "PW63 QPM", "Tesla");

		Sortable[] a = { sort1, sort2, sort3 };

		Sortable[] expected = { sort3, sort2, sort1 };
		Sortable[] actual = Sorting.quickSort(a);

		assertArrayEquals(expected, actual);
	}

	/**
	 * test quicksort for an array a of Customers
	 */
	@Test
	public void test6() {

		sort4 = new Customer("Tony", 6.21, "Newcastle");
		sort5 = new Customer("Emile", 290.70, "London");
		sort6 = new Customer("Kate", 0.0, "Amazonian Rainforest");

		Sortable[] a = { sort4, sort5, sort6 };

		Sortable[] expected = { sort6, sort4, sort5 };
		Sortable[] actual = Sorting.quickSort(a);

		assertArrayEquals(expected, actual);
	}

	/**
	 * test quicksort for an array a of Cars and Customers
	 */
	@Test
	public void test7() {

		sort1 = new Car(120.2, "HG09 JIE", "Ford");
		sort2 = new Car(80.7, "WK75 JDI", "Peugeot");
		sort3 = new Car(62.3, "PW63 QPM", "Tesla");
		sort4 = new Customer("Tony", 6.21, "Newcastle");
		sort5 = new Customer("Emile", 290.70, "London");
		sort6 = new Customer("Kate", 0.0, "Amazonian Rainforest");

		Sortable[] a = { sort1, sort2, sort3, sort4, sort5, sort6 };

		Sortable[] expected = { sort6, sort4, sort3, sort2, sort1, sort5 };
		Sortable[] actual = Sorting.quickSort(a);

		assertArrayEquals(expected, actual);
	}

	/**
	 * test quicksort for part of array a of Cars and Customers
	 */
	@Test
	public void test8() {

		sort1 = new Car(120.2, "HG09 JIE", "Ford");
		sort2 = new Car(80.7, "WK75 JDI", "Peugeot");
		sort3 = new Car(62.3, "PW63 QPM", "Tesla");
		sort4 = new Customer("Tony", 6.21, "Newcastle");
		sort5 = new Customer("Emile", 290.70, "London");
		sort6 = new Customer("Kate", 0.0, "Amazonian Rainforest");

		Sortable[] a = { sort1, sort2, sort3, sort4, sort5, sort6 };

		Sortable[] expected = { sort1, sort2, sort4, sort3, sort5, sort6 };
		Sortable[] actual = Sorting.quickSort(a, 2, 3);

		assertArrayEquals(expected, actual);
	}

}
