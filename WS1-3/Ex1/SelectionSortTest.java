import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for SelectionSort Class
 * 
 * @author Seapaddy
 * @version 2017-10-29
 *
 */

public class SelectionSortTest {

	@Test
	/**
	 * tests an array with multiple same integers
	 */
	public void test1() {
		int[] array = {0, 7, 8, 12, 1, 7, 0, 2};
		
		int[] expected = {0, 0, 1, 2, 7, 7, 8, 12};
		int[] actual = SelectionSort.selectionSort(array);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests an array starting in decreasing numbers
	 */
	public void test2() {
		int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		
		int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] actual = SelectionSort.selectionSort(array);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests an array with only one element
	 */
	public void test3() {
		int[] array = {77};
		
		int[] expected = {77};
		int[] actual = SelectionSort.selectionSort(array);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests an empty array
	 */
	public void test4() {
		int[] array = {};
		
		int[] expected = {};
		int[] actual = SelectionSort.selectionSort(array);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests an array with negative numbers
	 */
	public void test5() {
		int[] array = {18, 0, -45, -2, -6, 7, -23, 12, 18, 102, 1, 7, 12, -90};
		
		int[] expected = {-90, -45, -23, -6, -2, 0, 1, 7, 7, 12, 12, 18, 18, 102};
		int[] actual = SelectionSort.selectionSort(array);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests an array with max and min values
	 */
	public void test6() {
		int[] array = {Integer.MAX_VALUE, -77, 22, -16, 0, 0, Integer.MAX_VALUE/2, 0, 0, -20, Integer.MIN_VALUE};
		
		int[] expected = {Integer.MIN_VALUE, -77, -20, -16, 0, 0, 0, 0, 22, Integer.MAX_VALUE/2, Integer.MAX_VALUE};
		int[] actual = SelectionSort.selectionSort(array);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests an array with all the same values
	 */
	public void test7() {
		int[] array = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		
		int[] expected = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		int[] actual = SelectionSort.selectionSort(array);
		
		assertArrayEquals(expected, actual);
	}
	
	
	

}
