import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**Tests for ClubMember class
 * tests name, date of Birth, registration number and membership type getters
 * tests toString()
 * 
 * @author Seapaddy
 * @version 2017-10-16
 */

public class ClubMemberTest {

	private ClubMember member1;
	
	@Before
	/**
	 * initialises the objects
	 */
	public void setup() {
		member1 = new ClubMember("Harry", "31 July 1980", "146789", "Bronze");
	}
	
	
	@Test
	/**
	 * tests initialisation
	 */
	public void test1() {
		
		assertEquals("Harry", member1.getName());
		assertEquals("31 July 1980", member1.getDateOfBirth());
		assertEquals("146789", member1.getRegistrationNumber());
		assertEquals("Bronze", member1.getMembershipType());
	}
	
	@Test
	/**
	 * tests toString()
	 */
	public void test2() {
		
		String expected = "[Harry, 31 July 1980, ID: 146789, Bronze]";
		assertEquals(expected, member1.toString());
	}
	
	@Test
	/**
	 * re-initialise member1
	 */
	public void test3() {
		
		member1 = new ClubMember("James", "April 13, 1968", "007", "Gold");
		String expected = "[James, April 13, 1968, ID: 007, Gold]";
		assertEquals(expected, member1.toString());
	}
	
	@Test
	/**
	 * test 1 value in the object
	 */
	public void test4() {
		
		assertEquals("146789", member1.getRegistrationNumber());
	}
	
	@Test
	/**
	 * different re-initialise test
	 */
	public void test5() {
		
		member1 = new ClubMember("Harry", "31 July 1980", "67837269", "VIP");
		String expected = "[Harry, 31 July 1980, ID: 67837269, VIP]";
		assertEquals(expected, member1.toString());
	}
	
	@Test
	/**
	 * different initialise as same object
	 */
	public void test6() {
		
		member1 = new ClubMember("Harry", "31 July 1980", "146789", "Bronze");
		String expected = "[Harry, 31 July 1980, ID: 146789, Bronze]";
		assertEquals(expected, member1.toString());
	}
}
