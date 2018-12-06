import static org.junit.Assert.*;

import java.util.function.Function;

import org.junit.Test;

/**
 * Tests for Statistics Class
 * 
 * @author Seapaddy
 * @version 2017-11-13
 *
 */
public class StatisticsTest {

	private final static double EPSILON = 1e-6;

	/**
	 * tests for x squared function
	 */
	@Test
	public void test1() {

		Function<Double, Double> f1 = x -> x * x;
		double[] a = { 1, 1, 1, 1, 1 };

		double expectedMean = 1.0;
		double actualMean = Statistics.mean(f1, a);
		assertEquals(expectedMean, actualMean, EPSILON);

		double expectedStd = 0.0;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals(expectedStd, actualStd, EPSILON);

	}

	/**
	 * tests for x + x function
	 */
	@Test
	public void test2() {

		Function<Double, Double> f1 = x -> x + x;
		double[] a = { 1, 2, 3, 4, 5 };

		double expectedMean = 6.0;
		double actualMean = Statistics.mean(f1, a);
		assertEquals(expectedMean, actualMean, EPSILON);

		double expectedStd = 2.828427125;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals(expectedStd, actualStd, EPSILON);

	}
	
	/**
	 * tests for x - x function
	 */
	@Test
	public void test3() {

		Function<Double, Double> f1 = x -> x - x;
		double[] a = { -10, -5, 0, 5, 10 };

		double expectedMean = 0.0;
		double actualMean = Statistics.mean(f1, a);
		assertEquals(expectedMean, actualMean, EPSILON);

		double expectedStd = 0.0;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals(expectedStd, actualStd, EPSILON);

	}
	
	/**
	 * tests for sin(x)
	 */
	@Test
	public void test4() {

		Function<Double, Double> f1 = x -> Math.sin(x);
		double[] a = { 0, Math.PI/2, Math.PI };

		double expectedMean = 1.0/3.0;
		double actualMean = Statistics.mean(f1, a);
		assertEquals(expectedMean, actualMean, EPSILON);

		double expectedStd = 0.4714045207;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals(expectedStd, actualStd, EPSILON);

	}
	
	/**
	 * tests for cos(x)
	 */
	@Test
	public void test5() {

		Function<Double, Double> f1 = x -> Math.cos(x);
		double[] a = { Math.PI/2, 0, -Math.PI/2 };

		double expectedMean = 1.0/3.0;
		double actualMean = Statistics.mean(f1, a);
		assertEquals(expectedMean, actualMean, EPSILON);

		double expectedStd = 0.4714045207;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals(expectedStd, actualStd, EPSILON);

	}
	
	/**
	 * tests for x to the power x
	 */
	@Test
	public void test6() {

		Function<Double, Double> f1 = x -> Math.pow(x, x);
		double[] a = { -5, -3, -1, 1, 3, 5 };

		double expectedMean = 525.3271072;
		double actualMean = Statistics.mean(f1, a);
		assertEquals(expectedMean, actualMean, EPSILON);

		double expectedStd = 1162.651036;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals(expectedStd, actualStd, EPSILON);

	}
	
	/**
	 * tests for x * -1
	 */
	@Test
	public void test7() {

		Function<Double, Double> f1 = x -> x * -1;
		double[] a = { -5, -3, -1, 1, 3, 5 };

		double expectedMean = 0.0;
		double actualMean = Statistics.mean(f1, a);
		assertEquals(expectedMean, actualMean, EPSILON);

		double expectedStd = 3.415650255;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals(expectedStd, actualStd, EPSILON);

	}
}
