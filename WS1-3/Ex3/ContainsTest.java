import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
/**
 * Tests for Contains Class
 * 
 * @author Seapaddy
 * @version 2017-10-29, last changed 2017-11-02
 *
 */

public class ContainsTest {

	@Test
	/**
	 * Test checking positive integers
	 */
	public void test1() {

        ArrayList<Integer> expected = new ArrayList<Integer>
            (Arrays.asList(18, 28, 38));
        ArrayList<Integer> actual = Contains.allIntegersWith(15, 40, 8);
			
        assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * Test checking negative integers
	 */
	public void test2() {

        ArrayList<Integer> expected = new ArrayList<Integer>
            (Arrays.asList(-38, -28, -18));
        ArrayList<Integer> actual = Contains.allIntegersWith(-40, -15, 8);
			
        assertEquals(expected, actual);
	}
	
	 @Test
	 /**
	  * Test checking three digit numbers 
	  */
	 public void test3() {

		 ArrayList<Integer> expected = new ArrayList<Integer>
		 	(Arrays.asList(100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 120, 130, 
		 			140, 150, 160, 170, 180, 190, 200, 201, 202, 203, 204, 205, 206, 207,
		 			208, 209, 210, 220, 230, 240));
		 ArrayList<Integer> actual = Contains.allIntegersWith(99, 250, 0);
			
		 assertEquals(expected, actual);
			
	 }
	 
	 @Test
		/**
		 * Test checking inclusive intial and exclusive final
		 */
		public void test4() {

	        ArrayList<Integer> expected = new ArrayList<Integer>
	            (Arrays.asList(1, 10));
	        ArrayList<Integer> actual = Contains.allIntegersWith(1, 11, 1);
				
	        assertEquals(expected, actual);
		}
	 
	 @Test
		/**
		 * Test checking negative to positive
		 */
		public void test5() {

	        ArrayList<Integer> expected = new ArrayList<Integer>
	            (Arrays.asList(-7, 7));
	        ArrayList<Integer> actual = Contains.allIntegersWith(-9, 13, 7);
				
	        assertEquals(expected, actual);
		}
	 
	 @Test
		/**
		 * Test checking above 1000
		 */
		public void test6() {

	        ArrayList<Integer> expected = new ArrayList<Integer>
	            (Arrays.asList(8800, 8801, 8802, 8803, 8804, 8805, 8806, 8807, 8808, 8809, 
	            		8810, 8811, 8812, 8813, 8814, 8815, 8816, 8817, 8818, 8819, 
	            		8820, 8821));
	        ArrayList<Integer> actual = Contains.allIntegersWith(8800, 8822, 8);
				
	        assertEquals(expected, actual);
		}
	 
	 @Test
		/**
		 * Test checking crossover at 0
		 */
		public void test7() {

	        ArrayList<Integer> expected = new ArrayList<Integer>
	            (Arrays.asList(0));
	        ArrayList<Integer> actual = Contains.allIntegersWith(-9, 9, 0);
				
	        assertEquals(expected, actual);
		}

}
