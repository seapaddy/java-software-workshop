import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Tests for Aircraft, Aeroplane and HotAirBalloon Class'
 * 
 * @author Seapaddy
 * @version 2017-11-13
 *
 */

public class Ws4Ex1Tests {
	private Aircraft aircraft1, aircraft2, aircraft3;
	private Aeroplane aeroplane1, aeroplane2;
	private HotAirBalloon hotAirBalloon1, hotAirBalloon2;
	private final static double EPSILON = 1e-6;

	@Before
	public void setUp() {
		aircraft1 = new Aircraft(100.0, 999, 200);
		aircraft2 = new Aircraft(200.0, 2000, 666);
		aircraft3 = new Aircraft(6000.0, 200, 0);

		aeroplane1 = new Aeroplane(545.0, 600, 1500, 7777);
		aeroplane2 = new Aeroplane(18000.0, 8, 2, 1200);
		
		hotAirBalloon1 = new HotAirBalloon(80.0, 222, 3, 70);
		hotAirBalloon2 = new HotAirBalloon(80.0, 282, 4, 100);
	}
	
	/**
	 * tests the getters and setters for Aircraft
	 */
	@Test
	public void test1() {
	
		//checks maxSpeed
		double expected1 = 200.0;
		double actual1 = aircraft2.getMaxSpeed();
		
		assertEquals(expected1, actual1, EPSILON);
		
		aircraft2.setMaxSpeed(2000.0);
		double expected2 = 2000.0;
		double actual2 = aircraft2.getMaxSpeed();
		
		assertEquals(expected2, actual2, EPSILON);
		
		//checks maxWeight
		double expected3 = 2000.0;
		double actual3 = aircraft2.getMaxWeight();
		
		assertEquals(expected3, actual3, EPSILON);
		
		aircraft2.setMaxWeight(100.0);
		double expected4 = 100.0;
		double actual4 = aircraft2.getMaxWeight();
		
		assertEquals(expected4, actual4, EPSILON);
		
		//checks maxPersons
		int expected5 = 666;
		int actual5 = aircraft2.getMaxPersons();
		
		assertEquals(expected5, actual5, EPSILON);
		
		aircraft2.setMaxPersons(2);
		int expected6 = 2;
		int actual6 = aircraft2.getMaxPersons();
		
		assertEquals(expected6, actual6, EPSILON);
	}
	
	/**
	 * tests the getters and setters for Aeroplane
	 */
	@Test
	public void test2() {
	
		//checks maxSpeed
		double expected1 = 18000.0;
		double actual1 = aeroplane2.getMaxSpeed();
		
		assertEquals(expected1, actual1, EPSILON);
		
		aeroplane2.setMaxSpeed(1111.0);
		double expected2 = 1111.0;
		double actual2 = aeroplane2.getMaxSpeed();
		
		assertEquals(expected2, actual2, EPSILON);
		
		//checks maxWeight
		double expected3 = 8.0;
		double actual3 = aeroplane2.getMaxWeight();
		
		assertEquals(expected3, actual3, EPSILON);
		
		aeroplane2.setMaxWeight(222.0);
		double expected4 = 222.0;
		double actual4 = aeroplane2.getMaxWeight();
		
		assertEquals(expected4, actual4, EPSILON);
		
		//checks maxPersons
		int expected5 = 2;
		int actual5 = aeroplane2.getMaxPersons();
		
		assertEquals(expected5, actual5, EPSILON);
		
		aeroplane2.setMaxPersons(0);
		int expected6 = 0;
		int actual6 = aeroplane2.getMaxPersons();
		
		assertEquals(expected6, actual6, EPSILON);
		
		//checks range
		double expected7 = 1200.0;
		double actual7 = aeroplane2.getRange();
		
		assertEquals(expected7, actual7, EPSILON);
		
		aeroplane2.setRange(40000);
		double expected8 = 40000.0;
		double actual8 = aeroplane2.getRange();
		
		assertEquals(expected8, actual8, EPSILON);
	}
	
	/**
	 * tests the getters and setters for HotAirBalloon
	 */
	@Test
	public void test3() {
	
		//checks maxSpeed
		double expected1 = 80.0;
		double actual1 = hotAirBalloon1.getMaxSpeed();
		
		assertEquals(expected1, actual1, EPSILON);
		
		hotAirBalloon1.setMaxSpeed(20.0);
		double expected2 = 20.0;
		double actual2 = hotAirBalloon1.getMaxSpeed();
		
		assertEquals(expected2, actual2, EPSILON);
		
		//checks maxWeight
		double expected3 = 222.0;
		double actual3 = hotAirBalloon1.getMaxWeight();
		
		assertEquals(expected3, actual3, EPSILON);
		
		hotAirBalloon1.setMaxWeight(777.0);
		double expected4 = 777.0;
		double actual4 = hotAirBalloon1.getMaxWeight();
		
		assertEquals(expected4, actual4, EPSILON);
		
		//checks maxPersons
		int expected5 = 3;
		int actual5 = hotAirBalloon1.getMaxPersons();
		
		assertEquals(expected5, actual5, EPSILON);
		
		hotAirBalloon1.setMaxPersons(18);
		int expected6 = 18;
		int actual6 = hotAirBalloon1.getMaxPersons();
		
		assertEquals(expected6, actual6, EPSILON);
		
		//checks gas temperature
		double expected7 = 70.0;
		double actual7 = hotAirBalloon1.getGasTemperature();
		
		assertEquals(expected7, actual7, EPSILON);
		
		hotAirBalloon1.setGasTemperature(323);
		double expected8 = 323.0;
		double actual8 = hotAirBalloon1.getGasTemperature();
		
		assertEquals(expected8, actual8, EPSILON);
	}
	
	
	/**
	 * tests the toString() method of all the objects
	 */
	@Test
	public void test4() {
		String expected1 = "The aircraft has a maximal speed of 100.0 km/h and a maximal weight of 999.0 kg."
				+ " It can carry 200 persons.";
		String actual1 = aircraft1.toString();

		assertEquals(expected1, actual1);

		String expected2 = "The aircraft has a maximal speed of 545.0 km/h and a maximal weight of 600.0 kg."
				+ " It can carry 1500 persons. It has a range of 7777.0 km.";
		String actual2 = aeroplane1.toString();

		assertEquals(expected2, actual2);

		String expected3 = "The aircraft has a maximal speed of 80.0 km/h and a maximal weight of 222.0 kg. It can carry 3 persons."
				+ " It has a gas temperature of maximally 70.0\u00B0C.";
		String actual3 = hotAirBalloon1.toString();

		assertEquals(expected3, actual3);
	}
	
	/**
	 * tests the toString() method with setters
	 */
	@Test
	public void test5() {
		String expected1 = "The aircraft has a maximal speed of 6000.0 km/h and a maximal weight of 200.0 kg."
				+ " It can carry 0 persons.";
		String actual1 = aircraft3.toString();

		assertEquals(expected1, actual1);
		aircraft3.setMaxSpeed(200);
		aircraft3.setMaxPersons(15);
		aircraft3.setMaxWeight(600);

		String expected2 = "The aircraft has a maximal speed of 200.0 km/h and a maximal weight of 600.0 kg."
				+ " It can carry 15 persons.";
		String actual2 = aircraft3.toString();

		assertEquals(expected2, actual2);
		
		String expected3 = "The aircraft has a maximal speed of 545.0 km/h and a maximal weight of 600.0 kg."
				+ " It can carry 1500 persons. It has a range of 7777.0 km.";
		String actual3 = aeroplane1.toString();

		assertEquals(expected3, actual3);
		aeroplane1.setMaxSpeed(80);
		aeroplane1.setMaxPersons(600);
		aeroplane1.setMaxWeight(200);
		aeroplane1.setRange(7);
		
		String expected4 = "The aircraft has a maximal speed of 80.0 km/h and a maximal weight of 200.0 kg."
				+ " It can carry 600 persons. It has a range of 7.0 km.";
		String actual4 = aeroplane1.toString();

		assertEquals(expected4, actual4);
		
		String expected5 = "The aircraft has a maximal speed of 80.0 km/h and a maximal weight of 282.0 kg. It can carry 4 persons."
				+ " It has a gas temperature of maximally 100.0\u00B0C.";
		String actual5 = hotAirBalloon2.toString();

		assertEquals(expected5, actual5);
		hotAirBalloon2.setMaxSpeed(18);
		hotAirBalloon2.setMaxPersons(90);
		hotAirBalloon2.setMaxWeight(0.002);
		hotAirBalloon2.setGasTemperature(80.67);
		
		String expected6 = "The aircraft has a maximal speed of 18.0 km/h and a maximal weight of 0.002 kg. It can carry 90 persons."
				+ " It has a gas temperature of maximally 80.67\u00B0C.";
		String actual6 = hotAirBalloon2.toString();

		assertEquals(expected6, actual6);
	}
	
	/**
	 * tests getters with floating point numbers
	 */
	@Test
	public void test6() {
		aircraft1.setMaxSpeed(70.232);
		aircraft1.setMaxWeight(6.67);
		
		String expected1 = "The aircraft has a maximal speed of 70.232 km/h and a maximal weight of 6.67 kg."
				+ " It can carry 200 persons.";
		String actual1 = aircraft1.toString();
		
		assertEquals(expected1, actual1);
		
		aeroplane1.setMaxSpeed(2000.273);
		aeroplane1.setMaxWeight(0.96);
		aeroplane1.setRange(700.72);
		
		String expected2 = "The aircraft has a maximal speed of 2000.273 km/h and a maximal weight of 0.96 kg."
				+ " It can carry 1500 persons. It has a range of 700.72 km.";
		String actual2 = aeroplane1.toString();

		assertEquals(expected2, actual2);
		
		hotAirBalloon2.setMaxSpeed(2.42);
		hotAirBalloon2.setMaxWeight(111.1111);
		hotAirBalloon2.setGasTemperature(99.999);
		
		String expected3 = "The aircraft has a maximal speed of 2.42 km/h and a maximal weight of 111.1111 kg. It can carry 4 persons."
				+ " It has a gas temperature of maximally 99.999\u00B0C.";
		String actual3 = hotAirBalloon2.toString();

		assertEquals(expected3, actual3);
	}

}
