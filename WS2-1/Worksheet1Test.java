import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author SeaPaddy This class contains the test cases for Worksheet1
 *         solutions.
 */

public class Worksheet1Test {
	private List<Integer> empty;

	@Before
	public void setUp() {
		empty = new List<Integer>();
	}

	/*
	 * check raise to power 0, slow power function
	 */
	@Test
	public void test1() {
		int m = 4;
		int n = 0;

		int expected = 1;
		int actual = Worksheet1.power(m, n);

		assertEquals(expected, actual);
	}

	/*
	 * check multiple recursions, slow power function
	 */
	@Test
	public void test2() {
		int m = 4;
		int n = 4;

		int expected = 256;
		int actual = Worksheet1.power(m, n);

		assertEquals(expected, actual);
	}

	/*
	 * check raise to power 0, fast power function
	 */
	@Test
	public void test3() {
		int m = 4;
		int n = 0;

		int expected = 1;
		int actual = Worksheet1.fastPower(m, n);

		assertEquals(expected, actual);
	}

	/*
	 * check multiple recursions, fast power function
	 */
	@Test
	public void test4() {
		int m = 4;
		int n = 4;

		int expected = 256;
		int actual = Worksheet1.fastPower(m, n);

		assertEquals(expected, actual);
	}

	/*
	 * checks negative -> positive, positive -> negative, and 0 all in one list
	 */
	@Test
	public void test5() {
		List<Integer> positive = new List<Integer>(2, new List<Integer>(-3, new List<Integer>(0, new List<Integer>())));
		List<Integer> expectedList = new List<Integer>(-2,
				new List<Integer>(3, new List<Integer>(0, new List<Integer>())));

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.negateAll(positive));

		assertEquals(expected, actual);
	}

	/*
	 * checks negate function for an empty list
	 */
	@Test
	public void test6() {
		List<Integer> expectedList = new List<Integer>();

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.negateAll(empty));

		assertEquals(expected, actual);
	}

	/*
	 * checks find function with x at start of list, also checks finds first
	 * occurrence as multiple x in list
	 */
	@Test
	public void test7() {
		List<Integer> listFind = new List<Integer>(3, new List<Integer>(2, new List<Integer>(3, new List<Integer>())));

		int expected = 0;
		int actual = Worksheet1.find(3, listFind);

		assertEquals(expected, actual);
	}

	/*
	 * checks find function with x in middle of list
	 */
	@Test
	public void test8() {
		List<Integer> listFind = new List<Integer>(3, new List<Integer>(2, new List<Integer>(3, new List<Integer>())));

		int expected = 1;
		int actual = Worksheet1.find(2, listFind);

		assertEquals(expected, actual);
	}

	/*
	 * checks find function with x at end of list
	 */
	@Test
	public void test9() {
		List<Integer> listFind = new List<Integer>(3, new List<Integer>(2, new List<Integer>(-3, new List<Integer>())));

		int expected = 2;
		int actual = Worksheet1.find(-3, listFind);

		assertEquals(expected, actual);
	}

	/*
	 * check empty list is all positive
	 */
	@Test
	public void test10() {
		boolean expected = true;
		boolean actual = Worksheet1.allPositive(empty);

		assertEquals(expected, actual);
	}

	/*
	 * check positive
	 */
	@Test
	public void test11() {
		List<Integer> positive = new List<Integer>(2, new List<Integer>());

		boolean expected = true;
		boolean actual = Worksheet1.allPositive(positive);

		assertEquals(expected, actual);
	}

	/*
	 * check negative
	 */
	@Test
	public void test12() {
		List<Integer> negative = new List<Integer>(-2, new List<Integer>());

		boolean expected = false;
		boolean actual = Worksheet1.allPositive(negative);

		assertEquals(expected, actual);
	}

	/*
	 * check zero
	 */
	@Test
	public void test13() {
		List<Integer> zero = new List<Integer>(0, new List<Integer>());

		boolean expected = true;
		boolean actual = Worksheet1.allPositive(zero);

		assertEquals(expected, actual);
	}

	/*
	 * check empty list input
	 */
	@Test
	public void test14() {
		List<Integer> expectedList = new List<Integer>();

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.positives(empty));

		assertEquals(expected, actual);
	}

	/*
	 * check all positive to new list
	 */
	@Test
	public void test15() {
		List<Integer> positive = new List<Integer>(2, new List<Integer>(5, new List<Integer>(3, new List<Integer>())));
		List<Integer> expectedList = new List<Integer>(2,
				new List<Integer>(5, new List<Integer>(3, new List<Integer>())));

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.positives(positive));

		assertEquals(expected, actual);
	}

	/*
	 * check negative at start, middle and end of input list
	 */
	@Test
	public void test16() {
		List<Integer> mixed = new List<Integer>(-2, new List<Integer>(3,
				new List<Integer>(-6, new List<Integer>(7, new List<Integer>(-1, new List<Integer>())))));
		List<Integer> expectedList = new List<Integer>(3, new List<Integer>(7, new List<Integer>()));

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.positives(mixed));

		assertEquals(expected, actual);
	}

	/*
	 * check all negative produces empty list
	 */
	@Test
	public void test17() {
		List<Integer> negative = new List<Integer>(-3,
				new List<Integer>(-1, new List<Integer>(-7, new List<Integer>())));
		List<Integer> expectedList = new List<Integer>();

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.positives(negative));

		assertEquals(expected, actual);
	}

	/*
	 * check zero
	 */
	@Test
	public void test18() {
		List<Integer> zero = new List<Integer>(0, new List<Integer>());
		List<Integer> expectedList = new List<Integer>(0, new List<Integer>());

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.positives(zero));

		assertEquals(expected, actual);
	}

	/*
	 * check empty list is sorted in ascending order
	 */
	@Test
	public void test19() {
		boolean expected = true;
		boolean actual = Worksheet1.sorted(empty);

		assertEquals(expected, actual);
	}

	/*
	 * check singleton list is sorted in ascending order
	 */
	@Test
	public void test20() {
		List<Integer> singleton = new List<Integer>(4, new List<Integer>());

		boolean expected = true;
		boolean actual = Worksheet1.sorted(singleton);

		assertEquals(expected, actual);
	}

	/*
	 * check multiple elements are sorted in ascending order
	 */
	@Test
	public void test21() {
		List<Integer> mixed = new List<Integer>(2, new List<Integer>(3, new List<Integer>()));

		boolean expected = true;
		boolean actual = Worksheet1.sorted(mixed);

		assertEquals(expected, actual);
	}

	/*
	 * check multiple elements are not sorted in ascending order
	 */
	@Test
	public void test22() {
		List<Integer> mixed = new List<Integer>(3, new List<Integer>(2, new List<Integer>()));

		boolean expected = false;
		boolean actual = Worksheet1.sorted(mixed);

		assertEquals(expected, actual);
	}

	/*
	 * check sort function accepts duplicates
	 */
	@Test
	public void test23() {
		List<Integer> mixed = new List<Integer>(2,
				new List<Integer>(3, new List<Integer>(3, new List<Integer>(4, new List<Integer>()))));

		boolean expected = true;
		boolean actual = Worksheet1.sorted(mixed);

		assertEquals(expected, actual);
	}

	/*
	 * check merge a then b lists
	 */
	@Test
	public void test24() {
		List<Integer> a = new List<Integer>(2, new List<Integer>(3, new List<Integer>()));
		List<Integer> b = new List<Integer>(4, new List<Integer>(5, new List<Integer>()));

		List<Integer> expectedList = new List<Integer>(2,
				new List<Integer>(3, new List<Integer>(4, new List<Integer>(5, new List<Integer>()))));

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.merge(a, b));

		assertEquals(expected, actual);
	}

	/*
	 * check merge b then a lists
	 */
	@Test
	public void test25() {
		List<Integer> a = new List<Integer>(2, new List<Integer>(3, new List<Integer>()));
		List<Integer> b = new List<Integer>(4, new List<Integer>(5, new List<Integer>()));

		List<Integer> expectedList = new List<Integer>(2,
				new List<Integer>(3, new List<Integer>(4, new List<Integer>(5, new List<Integer>()))));

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.merge(b, a));

		assertEquals(expected, actual);
	}

	/*
	 * check merge empty list
	 */
	@Test
	public void test26() {
		List<Integer> a = new List<Integer>(2, new List<Integer>(3, new List<Integer>()));

		List<Integer> expectedList = new List<Integer>(2, new List<Integer>(3, new List<Integer>()));

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.merge(empty, a));

		assertEquals(expected, actual);
	}

	/*
	 * check merge duplicates in list, duplicates in returned list
	 */
	@Test
	public void test27() {
		List<Integer> a = new List<Integer>(2,
				new List<Integer>(3, new List<Integer>(3, new List<Integer>(4, new List<Integer>()))));
		List<Integer> b = new List<Integer>(2,
				new List<Integer>(3, new List<Integer>(3, new List<Integer>(4, new List<Integer>()))));

		List<Integer> expectedList = new List<Integer>(2,
				new List<Integer>(2, new List<Integer>(3, new List<Integer>(3, new List<Integer>(3,
						new List<Integer>(3, new List<Integer>(4, new List<Integer>(4, new List<Integer>()))))))));

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.merge(a, b));

		assertEquals(expected, actual);
	}

	/*
	 * check empty list
	 */
	@Test
	public void test28() {
		List<Integer> expectedList = new List<Integer>();

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.removeDuplicates(empty));

		assertEquals(expected, actual);
	}

	/*
	 * check no duplicates in input list
	 */
	@Test
	public void test29() {
		List<Integer> mixed = new List<Integer>(2, new List<Integer>(3, new List<Integer>(4, new List<Integer>())));
		List<Integer> expectedList = new List<Integer>(2,
				new List<Integer>(3, new List<Integer>(4, new List<Integer>())));

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.removeDuplicates(mixed));

		assertEquals(expected, actual);
	}

	/*
	 * check all duplicates in input list
	 */
	@Test
	public void test30() {
		List<Integer> allDuplicates = new List<Integer>(2,
				new List<Integer>(2, new List<Integer>(2, new List<Integer>())));
		List<Integer> expectedList = new List<Integer>(2, new List<Integer>());

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.removeDuplicates(allDuplicates));

		assertEquals(expected, actual);
	}

	/*
	 * check middle elements duplicate removal
	 */
	@Test
	public void test31() {
		List<Integer> middle = new List<Integer>(2, new List<Integer>(3,
				new List<Integer>(3, new List<Integer>(3, new List<Integer>(4, new List<Integer>())))));
		List<Integer> expectedList = new List<Integer>(2,
				new List<Integer>(3, new List<Integer>(4, new List<Integer>())));

		boolean expected = true;
		boolean actual = List.equals(expectedList, Worksheet1.removeDuplicates(middle));

		assertEquals(expected, actual);
	}
}
