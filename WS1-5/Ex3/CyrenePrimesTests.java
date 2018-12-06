import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for CyrenePrimes object
 * 
 * @author Seapaddy
 * @version 2017-11-29
 */
public class CyrenePrimesTests {

	/**
	 * test for prime numbers in array under 10
	 */
	@Test
	public void test1() {
		int[] expected = { 2, 3, 5, 7 };
		int[] actual = CyrenePrimes.sieve(10);

		assertArrayEquals(expected, actual);

	}

	/**
	 * test for checks correct number of primes calculated below 1,000
	 */
	@Test
	public void test2() {
		int expected = 168;
		int actual = CyrenePrimes.sieve(1000).length;

		assertEquals(expected, actual);
	}

	/**
	 * test for checks correct number of primes calculated below 10,000
	 */
	@Test
	public void test3() {
		int expected = 1229;
		int actual = CyrenePrimes.sieve(10000).length;

		assertEquals(expected, actual);
	}

	/**
	 * test for checks correct number of primes calculated below 100,000
	 */
	@Test
	public void test4() {
		int expected = 9592;
		int actual = CyrenePrimes.sieve(100000).length;

		assertEquals(expected, actual);
	}

	/**
	 * test for checks correct number of primes calculated below 100,000,000
	 */
	@Test
	public void test5() {
		int expected = 5761455;
		int actual = CyrenePrimes.sieve(100000000).length;

		assertEquals(expected, actual);
	}

	/**
	 * test for checks correct number of primes calculated between 0 and 1
	 */
	@Test
	public void test6() {
		int expected = 0;
		int actual = CyrenePrimes.sieve(1).length;

		assertEquals(expected, actual);
	}

	/**
	 * check includes all primes including final prime if prime is max number
	 */
	@Test
	public void test7() {
		int[] expected = { 2, 3, 5, 7, 11, 13, 17 };
		int[] actual = CyrenePrimes.sieve(17);

		assertArrayEquals(expected, actual);
	}
	
	/**
	 * test for max value of 0
	 */
	@Test
	public void test8() {
		int expected = 0;
		int actual = CyrenePrimes.sieve(0).length;

		assertEquals(expected, actual);
	}

}
