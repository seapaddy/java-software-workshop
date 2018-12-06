import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**Tests for Complex class
 * tests real and imaginary part getters
 * tests toString()
 * tests complex additions
 * tests complex multiplications
 * 
 * @author Seapaddy
 * @version 2017-10-16
 */

public class ComplexTest {
	private Complex complex1, complex2, complex3, complex4, complex5;
	private final static double EPSILON = 1e-6;
	
	@Before
	/**
	 * initialise 5 complex objects
	 */
	public void setup() {
		complex1 = new Complex(2, 4);
		complex2 = new Complex(0, 0);
		complex3 = new Complex(15, 7);
		complex4 = new Complex(4, 18);
		complex5 = new Complex(11, 17);
	}
	
	@Test
	/**
	 * test complex getters
	 */
	public void test1() {
		assertEquals(2.0, complex1.getRealPart(), EPSILON);
		assertEquals(4.0, complex1.getImaginaryPart(), EPSILON);
		
		assertEquals(0.0, complex2.getRealPart(), EPSILON);
		assertEquals(0.0, complex2.getImaginaryPart(), EPSILON);
		
		assertEquals(11.0, complex5.getRealPart(), EPSILON);
		assertEquals(17.0, complex5.getImaginaryPart(), EPSILON);
	}
	
	@Test
	/**
	 * test complex addition
	 */
	public void test2() {
		Complex complexAddition = complex3.add(complex5);
		
		assertEquals(26.0, complexAddition.getRealPart(), EPSILON);
		assertEquals(24.0, complexAddition.getImaginaryPart(), EPSILON);
		
		assertEquals(15.0, complex3.getRealPart(), EPSILON);
		assertEquals(7.0, complex3.getImaginaryPart(), EPSILON);
		
		assertEquals(11.0, complex5.getRealPart(), EPSILON);
		assertEquals(17.0, complex5.getImaginaryPart(), EPSILON);
		
		String expected = "26.0 + 24.0i";
		assertEquals(expected, complexAddition.toString());	
	}
	
	@Test
	/**
	 * test complex addition with one complex having both 0 real and imaginary
	 */
	public void test3() {
		Complex complexAddition = complex2.add(complex4);
		
		assertEquals(4.0, complexAddition.getRealPart(), EPSILON);
		assertEquals(18.0, complexAddition.getImaginaryPart(), EPSILON);
		
		assertEquals(0.0, complex2.getRealPart(), EPSILON);
		assertEquals(0.0, complex2.getImaginaryPart(), EPSILON);
		
		assertEquals(4.0, complex4.getRealPart(), EPSILON);
		assertEquals(18.0, complex4.getImaginaryPart(), EPSILON);
		
		String expected = "4.0 + 18.0i";
		assertEquals(expected, complexAddition.toString());	
	}
	
	@Test
	/**
	 * test complex multiplication
	 */
	public void test4() {
		Complex complexMultiplication = complex1.multiply(complex4);
		
		assertEquals(-64.0, complexMultiplication.getRealPart(), EPSILON);
		assertEquals(52.0, complexMultiplication.getImaginaryPart(), EPSILON);
		
		String expected = "-64.0 + 52.0i";
		assertEquals(expected, complexMultiplication.toString());
	}
	
	@Test
	/**
	 * test complex multiplication with one complex having both 0 real and imaginary parts
	 */
	public void test5() {
		Complex complexMultiplication = complex5.multiply(complex2);
		
		assertEquals(0.0, complexMultiplication.getRealPart(), EPSILON);
		assertEquals(0.0, complexMultiplication.getImaginaryPart(), EPSILON);
		
		String expected = "0.0 + 0.0i";
		assertEquals(expected, complexMultiplication.toString());
		
	}
	
	@Test
	/**
	 * test complex multiplication, both complex numbers having double digits
	 */
	public void test6() {
		Complex complexMultiplication = complex5.multiply(complex4);
		
		assertEquals(-262.0, complexMultiplication.getRealPart(), EPSILON);
		assertEquals(266.0, complexMultiplication.getImaginaryPart(), EPSILON);
		
		String expected = "-262.0 + 266.0i";
		assertEquals(expected, complexMultiplication.toString());
		
	}

}
