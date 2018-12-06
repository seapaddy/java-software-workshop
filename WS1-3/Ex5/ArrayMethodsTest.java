import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
/**
 * Tests for ArrayMethods Class
 * 
 * @author Seapaddy
 * @version 2017-10-29
 *
 */
public class ArrayMethodsTest {
	@Rule public final ExpectedException exception = ExpectedException.none();
	 
	// margin for error
	private final static double EPSILON = 1e-6; 
	
	@Test
	/**
	 * Test checking all methods
	 */
	public void test1() {

		double[][] array = {{8, 12, -1.7}, {0.34, -22.8, 0}};

		double expectedMin = -22.8;
		double expectedMax = 12;
		double expectedMean = -0.6933333333;
		double expectedMedium = 0.17;

		assertEquals(expectedMin, ArrayMethods.min(array), EPSILON);
		assertEquals(expectedMax, ArrayMethods.max(array), EPSILON);
		assertEquals(expectedMean, ArrayMethods.mean(array), EPSILON);
		assertEquals(expectedMedium, ArrayMethods.median(array), EPSILON);
	}
	
	@Test
	/**
	 * Test checking array of all same number
	 */
	public void test2() {

		double[][] array = {{1, 1, 1}, {1, 1, 1}};

		double expectedMin = 1;
		double expectedMax = 1;
		double expectedMean = 1;
		double expectedMedium = 1;

		assertEquals(expectedMin, ArrayMethods.min(array), EPSILON);
		assertEquals(expectedMax, ArrayMethods.max(array), EPSILON);
		assertEquals(expectedMean, ArrayMethods.mean(array), EPSILON);
		assertEquals(expectedMedium, ArrayMethods.median(array), EPSILON);
	}
	
	@Test
	/**
	 * Test checking array with different row lengths
	 */
	public void test3() {

		double[][] array = {{18, 16}, {-7, 6, 8, 15, -3}};

		double expectedMin = -7;
		double expectedMax = 18;
		double expectedMean = 7.571428571;
		double expectedMedium = 8;

		assertEquals(expectedMin, ArrayMethods.min(array), EPSILON);
		assertEquals(expectedMax, ArrayMethods.max(array), EPSILON);
		assertEquals(expectedMean, ArrayMethods.mean(array), EPSILON);
		assertEquals(expectedMedium, ArrayMethods.median(array), EPSILON);
	}
	
	@Test
	/**
	 * Test checking empty array
	 * expect IllegalArgumentException
	 */
	public void test4() {

		double[][] array = {{}};

		exception.expect(IllegalArgumentException.class);
		ArrayMethods.median(array);
	}
	
	@Test
	/**
	 * Test checking large two dimensional array
	 */
	public void test5() {

		double[][] array = {{8, 11, 12}, {-2, -4, -16}, {7, 9, -3}, {}, {8, 12}, {9}};

		double expectedMin = -16;
		double expectedMax = 12;
		double expectedMean = 4.25;
		double expectedMedium = 8;

		assertEquals(expectedMin, ArrayMethods.min(array), EPSILON);
		assertEquals(expectedMax, ArrayMethods.max(array), EPSILON);
		assertEquals(expectedMean, ArrayMethods.mean(array), EPSILON);
		assertEquals(expectedMedium, ArrayMethods.median(array), EPSILON);
	}
	
	@Test
	/**
	 * Test checking one dimensional array
	 */
	public void test6() {

		double[][] array = {{10, 20, 30, 40}};

		double expectedMin = 10;
		double expectedMax = 40;
		double expectedMean = 25;
		double expectedMedium = 25;

		assertEquals(expectedMin, ArrayMethods.min(array), EPSILON);
		assertEquals(expectedMax, ArrayMethods.max(array), EPSILON);
		assertEquals(expectedMean, ArrayMethods.mean(array), EPSILON);
		assertEquals(expectedMedium, ArrayMethods.median(array), EPSILON);
	}

}
