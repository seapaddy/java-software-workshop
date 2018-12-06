import java.util.ArrayList;

/**
 * The class Contains method allIntegersWith returns an ArrayList of integers
 * that contain a determined digit between two selected integers.
 * 
 * It receives three integers, from, to and containedDigit. from is the starting
 * integer in the range (inclusively), to is the final integer in the range
 * (exclusively), containedDigit is the digit that must be present for an
 * integer to be added to the return ArrayList (list).
 * 
 * @author Seapaddy
 * @version 2017-10-26, last changed 2017-11-02
 */

public class Contains {
	/**
	 * allIntegersWith method produces an arrayList containing integers with a
	 * determined digit, uses modulus of 10 to find currentNumber's single digits,
	 * then divides currentNumber by 10 to reduce the digits in the number, repeats
	 * until currentNumber is equal to 0. If looking for containedDigit 0, method
	 * checks when i = 0, as currentNumber = 0 would exit the while loop.
	 * 
	 * @param from
	 *            Is the starting integer, inclusive
	 * @param to
	 *            Is the final integer, exclusive
	 * @param containedDigit
	 *            Is the digit needed for an integer to be added to the array
	 * @return Returns the ArrayList of integers, list, containing the determined
	 *         digit within the range from-to
	 */
	public static ArrayList<Integer> allIntegersWith(int from, int to, int containedDigit) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = from; i < to; i++) {
			// Math.abs fix for negative numbers
			int currentNumber = Math.abs(i);
			while (currentNumber != 0) {
				if (currentNumber % 10 == containedDigit) {
					list.add(i);
					// breaks out of while loop if true
					break;
				}
				currentNumber /= 10;
			}
			if (i == 0 && i == containedDigit) {
				list.add(i);
			}
		}
		return list;
	}
}
