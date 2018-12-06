/**
 * Class ArrayMethods contains 4 methods, getMin returns the minimum value
 * within a two dimensional array, getMax returns the maximum value within a two
 * dimensional array, mean returns the mean value of a two dimensional array,
 * median returns the middle value within a two dimensional array
 * 
 * all methods throw IllegalArgumentException(), in case of incorrect input
 * 
 * @author Seapaddy
 * @version 2017-10-26, last changed 2017-10-29
 */
public class ArrayMethods {
	/**
	 * min method finds the minimum values within the array, a
	 * 
	 * @param a
	 *            Two dimensional array received by method
	 * @return Returns the minimal value within the array, a
	 */
	public static double min(double[][] a) {
		try {
			double min = a[0][0];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					if (min > a[i][j]) {
						min = a[i][j];
					}
				}
			}
			return min;
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
	}

	/**
	 * max method finds the minimum values within the array, a
	 * 
	 * @param a
	 *            Two dimensional array received by method
	 * @return Returns the maximum value within the array, a
	 */
	public static double max(double[][] a) {
		try {
			double max = a[0][0];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					if (max < a[i][j]) {
						max = a[i][j];
					}
				}
			}
			return max;
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
	}

	/**
	 * calculates the mean values of a two dimensional array, sum calculates the
	 * summed value of all the elements in array, elementCount counts the total
	 * number of elements, sum/elementCount equals the mean value of the array
	 * 
	 * @param a
	 *            Two dimensional array received by method
	 * @return Returns the mean value of the array, a
	 */
	public static double mean(double[][] a) {
		try {
			double sum = 0;
			int elementCount = 0;
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					sum += a[i][j];
					elementCount++;
				}
			}
			return sum / elementCount;
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
	}

	/**
	 * calculates the median value of two dimensional array, a
	 * 
	 * first counts total elements in two dimensional array (elementCount), creates
	 * a new one dimensional array (sort[]) of length elementCount, sort contains
	 * all the elements in two dimensional array, simple selection sort algorithm
	 * used (Exercise 1 Worksheet 3) to sort the one dimensional array into
	 * numerical order
	 * 
	 * now sort array is in numerical order, median is the middle element for arrays
	 * with an odd length (median = sort.length / 2)
	 * 
	 * for arrays with an even length, median = mean of middle two elements, to
	 * determine even array.length use modulus 2, if even take mean of (array/2) and
	 * ((array/2)-1) elements
	 * 
	 * @param a
	 *            Two dimensional array received by method
	 * @return Returns the median of array, a
	 */
	public static double median(double[][] a) {
		try {
			int elementCount = 0;
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					elementCount++;
				}
			}
			double[] sort = new double[elementCount];
			int index = 0;
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					sort[index++] = a[i][j];
				}
			}
			for (int i = 0; i < sort.length; i++) {
				int lowest = i;
				for (int j = i; j < sort.length; j++) {
					if (sort[j] < sort[lowest]) {
						lowest = j;
					}
				}
				double temp = sort[i];
				sort[i] = sort[lowest];
				sort[lowest] = temp;
			}
			// checks if the array is odd or even length
			if (sort.length % 2 == 0) {
				// if even returns the mean of the two middle values
				return (sort[elementCount / 2] + sort[(elementCount / 2 - 1)]) / 2;
			} else {
				// if odd returns the middle element of the array
				return sort[elementCount / 2];
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
	}
}
