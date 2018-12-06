/**
 * @author SeaPaddy
 * 
 *         This class contains the solution for Worksheet1
 */

public class Worksheet1 {

	// Exercise 1
	/**
	 * Calculates the value of m raised to the power of n
	 * 
	 * @param m
	 *            is a positive integer
	 * @param n
	 *            is a positive integer
	 * @return the integer value of m raised to the power of n
	 */
	public static int power(int m, int n) {
		if (n == 0) {
			return 1;
		} else {
			return m * power(m, n - 1);
		}
	}

	/**
	 * Calculates the value of m raised to the power of n in log(n) time
	 * 
	 * @param m
	 *            is a positive integer
	 * @param n
	 *            is a positive integer
	 * @return the integer value of m raised to the power of n
	 */
	public static int fastPower(int m, int n) {
		if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			return power(m * m, n / 2);
		} else {
			return m * power(m, n - 1);
		}
	}

	// Exercise 2
	/**
	 * Negates all the elements of a and returns them in a new list
	 * 
	 * @param a
	 *            list of integer elements
	 * @return a list containing all elements from list a with sign negated
	 */
	public static List<Integer> negateAll(List<Integer> a) {
		if (a.isEmpty()) {
			return new List<Integer>();
		} else {
			return new List<Integer>(-a.getHead(), negateAll(a.getTail()));
		}
	}

	// Exercise 3
	/**
	 * Finds the position of the first occurrence of x in the list a, throws an
	 * IllegalArgumentException() if x is not contained within the list a
	 * 
	 * @param x
	 *            is an integer assumed to be in List a
	 * @param a
	 *            list of integer elements
	 * @return the position of the first occurrence of x in the list a
	 */
	public static int find(int x, List<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalArgumentException("Element x doesn't feature in list a");
		} else if (a.getHead() == x) {
			return 0;
		} else {
			return 1 + find(x, a.getTail());
		}
	}

	// Exercise 4
	/**
	 * Determines whether all elements in list a are positive integers,(ie. >= 0)
	 * 
	 * @param a
	 *            list of integer elements
	 * @return true if all the elements in list a are positive (>= 0), false if not
	 */
	public static boolean allPositive(List<Integer> a) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getHead() < 0) {
			return false;
		} else {
			return allPositive(a.getTail());
		}
	}

	// Exercise 5
	/**
	 * Creates a list containing all the positive integer elements (>= 0) in list a
	 * 
	 * @param a
	 *            list of integer elements
	 * @return a list containing all the positive integer elements of list a
	 */
	public static List<Integer> positives(List<Integer> a) {
		if (a.isEmpty()) {
			return new List<Integer>();
		} else if (a.getHead() >= 0) {
			return new List<Integer>(a.getHead(), positives(a.getTail()));
		} else {
			return positives(a.getTail());
		}
	}

	// Exercise 6
	/**
	 * Checks whether a list of integer elements a is sorted in ascending order
	 * 
	 * @param a
	 *            list of integer elements
	 * @return true if the integer elements in list a are in ascending order, false
	 *         if not
	 */
	public static boolean sorted(List<Integer> a) {
		if (a.isEmpty() || a.getTail().isEmpty()) {
			return true;
		} else if (a.getHead() <= a.getTail().getHead()) {
			return sorted(a.getTail());
		} else {
			return false;
		}
	}

	// Exercise 7
	/**
	 * Concatenate two lists of integer elements
	 * 
	 * @param a
	 *            list of integer elements in ascending order
	 * @param b
	 *            list of integer elements in ascending order
	 * @return a list containing all elements of lists a and b in ascending order
	 */
	public static List<Integer> merge(List<Integer> a, List<Integer> b) {
		if (a.isEmpty()) {
			return b;
		} else if (b.isEmpty()) {
			return a;
		} else if (a.getHead() <= b.getHead()) {
			return new List<Integer>(a.getHead(), merge(a.getTail(), b));
		} else {
			return new List<Integer>(b.getHead(), merge(a, b.getTail()));
		}
	}

	// Exercise 8
	/**
	 * removes the duplicate values in a list of integer elements
	 * 
	 * @param a
	 *            list of integer elements in ascending order
	 * @return a list containing all integer values in list a with no duplicates
	 */
	static List<Integer> removeDuplicates(List<Integer> a) {
		if (a.isEmpty()) {
			return new List<Integer>();
		} else if (a.getTail().isEmpty()) {
			return new List<Integer>(a.getHead(), new List<Integer>());
		} else if (a.getHead() == a.getTail().getHead()) {
			return removeDuplicates(a.getTail());
		} else {
			return new List<Integer>(a.getHead(), removeDuplicates(a.getTail()));
		}
	}
}
