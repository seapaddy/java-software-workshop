import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**Tests for Distance class
 * tests name, date of Birth, registration number and membership type getters
 * 
 * @author Seapaddy
 * @version 2017-10-16
 */

public class DistanceTest {
	private Distance distance1, distance2;
	private final static double EPSILON = 1e-6;
	
	@Before
	/**
	 * initialises the distance object to 24km
	 */
	public void setup() {
		distance1 = new Distance(24);
		distance2 = new Distance(0);
	}
	
	@Test
	/**
	 * tests kilometre getter for distance1 object initialised at 24km
	 * allows for error of 0.000001
	 */
	public void test1() {
		double expected = 24.0;
		assertEquals(expected, distance1.getKilometres(), EPSILON);
	}
	
	@Test
	/**
	 * tests miles getter for distance1 object initialised at 24km
	 * allows for error of 0.000001
	 */
	public void test2() {
		double expected = 14.9129456796;
		assertEquals(expected, distance1.getMiles(), EPSILON);
	}
	
	@Test
	/**
	 * tests metres getter for re-initialised distance1
	 * allows for error of 0.000001
	 */
	public void test3() {
		distance1 = new Distance(5);
		double expected = 5000;
		assertEquals(expected, distance1.getMetres(), EPSILON);
	}
	
	@Test
	/**
	 * tests yards getter for distance1 object initialised at 24km
	 * allows for error of 0.000001
	 */
	public void test4() {
		double expected = 26246.7843961;
		assertEquals(expected, distance1.getYards(), EPSILON);
	}
	
	@Test
	/**
	 * tests all getters for 0km
	 * allows for error of 0.000001
	 */
	public void test5() {
		double expected = 0;
		assertEquals(expected, distance2.getKilometres(), EPSILON);
		assertEquals(expected, distance2.getMiles(), EPSILON);
		assertEquals(expected, distance2.getMetres(), EPSILON);
		assertEquals(expected, distance2.getYards(), EPSILON);
	}
	
	@Test
	/**
	 * tests all getters for re-initialised distance2
	 * allows for error of 0.000001
	 */
	public void test6() {
		distance2 = new Distance(0.2);
		
		assertEquals(0.2, distance2.getKilometres(), EPSILON);
		assertEquals(0.12427454733, distance2.getMiles(), EPSILON);
		assertEquals(200, distance2.getMetres(), EPSILON);
		assertEquals(218.723203301, distance2.getYards(), EPSILON);
	}
}
