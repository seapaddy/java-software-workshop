/**
 * The class SelectionSort contains a simple sorting method selectionSort,
 * selectionSort receives a one dimensional array, and returns an array
 * containing the same elements sorted numerically. SelectionSort considers each
 * element in an array, starting from the first array[0], checks all elements
 * after considered element in array and selects the smallest element, it then
 * swaps the smallest element with the element under consideration. The next
 * element in the array is then under consideration, once selectionSort has
 * considered every element in the array it returns the sorted array.
 * 
 * @author Seapaddy
 * @version 2017-10-26, last changed 2017-10-29
 */
public class SelectionSort {
	/**
	 * selectionSort receives a one dimensional array, sorts the array into
	 * numerical order and returns the new array
	 * 
	 * @param numbers
	 *            The integer array selectionSort receives
	 * @return Returns the sorted array
	 */
	public static int[] selectionSort(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			// initialise lowest to element under consideration
			int lowestElement = i;
			for (int j = i; j < numbers.length; j++) {
				if (numbers[j] < numbers[lowestElement]) {
					lowestElement = j;
				}
			}
			int temp = numbers[i];
			numbers[i] = numbers[lowestElement];
			numbers[lowestElement] = temp;
		}
		return numbers;
	}
}
