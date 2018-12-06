import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for StarRating Class
 * 
 * @author Seapaddy
 * @version 2017-10-29
 *
 */

public class StarRatingTest {
	 @Rule public final ExpectedException exception = ExpectedException.none();

	@Test
	/**
	 * test expecting "CRAP"
	 */
	public void test1() {
		
		double rating = 1.0;
		
		String expected = "CRAP";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * test expecting "CRAP", rating in middle of the range
	 */
	public void test2() {
		
		double rating = 3.2;
		
		String expected = "CRAP";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * test expecting "OK"
	 */
	public void test3() {
		
		double rating = 4.0;
		
		String expected = "OK";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * test expecting "EXCELLENT"
	 */
	public void test4() {
		
		double rating = 4.5;
		
		String expected = "EXCELLENT";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * test expecting "[HAS ONLY ONE REVIEW]"
	 */
	public void test5() {
		
		double rating = 5.0;
		
		String expected = "[HAS ONLY ONE REVIEW]";
        String actual = StarRating.interpret(rating);
		
        assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * test for IllegalArgumentException above range
	 */
	public void test6() {
		
		double rating = 5.05;
		
		exception.expect(IllegalArgumentException.class);
        StarRating.interpret(rating);
	}
	
	@Test
	/**
	 * test for IllegalArgumentException below range
	 */
	public void test7() {
		
		double rating = -Integer.MAX_VALUE;
		
		exception.expect(IllegalArgumentException.class);
        StarRating.interpret(rating);
	}

}
