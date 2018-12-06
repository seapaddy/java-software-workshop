import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**Tests for Film class
 * tests title, year and length getter
 * tests length setter
 * tests toString()
 * 
 * @author Seapaddy
 * @version 2017-10-16
 */
public class FilmTest {
	private Film film1, film2, film3;
	
	@Before
	/**
	 * initialises the objects
	 */
	public void setup() {
		film1 = new Film("Monsters Life", 2020, 87);
		film2 = new Film("", 1104, 42);
		film3 = new Film("Roosters", 0024, 26);
	}
	
	@Test
	/**
	 * tests film initialisation
	 */
	public void test1() {
		
		assertEquals("", film2.getTitle());
		assertEquals(1104, film2.getYear());
		assertEquals(42, film2.getLength());
	}
	
	@Test
	/**
	 * tests film length getter and setter
	 */
	public void test2() {
		assertEquals(87, film1.getLength());
		
		film1.setLength(50);
		
		assertEquals("Monsters Life", film1.getTitle());
		assertEquals(2020, film1.getYear());
		assertEquals(50, film1.getLength());
	}

	@Test
	/**
	 * tests film duplicate set length
	 */
	public void test3() {
		film1.setLength(20);
		
		assertEquals("Monsters Life", film1.getTitle());
		assertEquals(2020, film1.getYear());
		assertEquals(20, film1.getLength());
		
		film1.setLength(100000000);
		
		assertEquals("Monsters Life", film1.getTitle());
		assertEquals(2020, film1.getYear());
		assertEquals(100000000, film1.getLength());
	}
	
	@Test
	/**
	 * tests toString()
	 */
	public void test4() {
		film1.setLength(0);
		
		String expected = "Film [title=Monsters Life, year=2020, length=0]";
		assertEquals(expected, film1.toString());
	}
	
	@Test
	/**
	 * tests a film with one word name
	 */
	public void test5() {
		film3.setLength(80);
		
		assertEquals("Roosters", film3.getTitle());
		assertEquals(0024, film3.getYear());
		assertEquals(80, film3.getLength());
	}
	
	@Test
	/**
	 * tests multiple film objects in one test
	 * also test length set to 0
	 */
	public void test6() {
		
		assertEquals("Roosters", film3.getTitle());
		assertEquals(0024, film3.getYear());
		assertEquals(26, film3.getLength());
		
		assertEquals("Monsters Life", film1.getTitle());
		assertEquals(2020, film1.getYear());
		assertEquals(87, film1.getLength());
		
		assertEquals("", film2.getTitle());
		assertEquals(1104, film2.getYear());
		assertEquals(42, film2.getLength());
		
		film3.setLength(0);
		
		assertEquals("Roosters", film3.getTitle());
		assertEquals(0024, film3.getYear());
		assertEquals(0, film3.getLength());
	}
	
}
