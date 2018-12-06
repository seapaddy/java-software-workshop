import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**Tests for Employee class
 * tests name, hourly salary and hours worked setters and getters
 * tests toString()
 * tests hourSalaryIncrease()
 * tests monthlySalary(tax percentage)
 * 
 * @author Seapaddy
 * @version 2017-10-16
 */

public class EmployeeTest {
	private Employee employee1;
	private final static double EPSILON = 1e-6;
	
	@Before
	/**
	 * initialises the employee object
	 */
	public void setup() {
		employee1 = new Employee("John Wall", 20190.47, 70);
	}
	
	@Test
	/**
	 * test the getter and setter work
	 * do this by testing initial then check changes
	 */
	public void test1() {
		assertEquals("John Wall", employee1.getName());
		assertEquals(20190.47, employee1.getHourlySalary(), EPSILON);
		assertEquals(70, employee1.getNumberOfHours());
		
		employee1.setName("Kevin Durant");
		employee1.setHourlySalary(20);
		employee1.setNumberOfHours(100);
		
		assertEquals("Kevin Durant", employee1.getName());
		assertEquals(20, employee1.getHourlySalary(), EPSILON);
		assertEquals(100, employee1.getNumberOfHours());
		
	}
	
	@Test
	/**
	 * test toString()
	 */
	public void test2() {
		String expected = "John Wall has an hourly salary of 20190.47 £ and has worked last month for 70 hours.";
		
		assertEquals(expected, employee1.toString());
		
	}
	
	@Test
	/**
	 * test set hourlysalary and hours worked
	 * test monthlysalary with 7.5 percent tax
	 */
	public void test3() {
		employee1.setHourlySalary(21.5);
		employee1.setNumberOfHours(79);

		String expected = "John Wall has an hourly salary of 21.5 \u00a3 and has worked last month for 79 hours.";

		assertEquals(expected, employee1.toString());

		assertEquals(1528.65, employee1.monthlySalary(10), EPSILON);
		
	}
	
	@Test
	/**
	 * test case for all setters setting to 0
	 */
	public void test4() {
		employee1.setHourlySalary(0);
		employee1.setNumberOfHours(0);
		
		String expected = "John Wall has an hourly salary of 0.0 \u00a3 and has worked last month for 0 hours.";
		assertEquals(expected, employee1.toString());

		assertEquals(0, employee1.getHourlySalary(), EPSILON);		
		assertEquals(0, employee1.monthlySalary(10), EPSILON);
		assertEquals("John Wall", employee1.getName());
		
	}
	
	@Test
	/**
	 * test increase in hourly salary
	 */
	public void test5() {
		employee1.setHourlySalary(10);

		assertEquals(10, employee1.getHourlySalary(), EPSILON);
		
		employee1.increaseSalary(22.5);
		
		assertEquals(12.25, employee1.getHourlySalary(), EPSILON);
		
	}
	
	@Test
	/**
	 * test reassignment and salary increase
	 */
	public void test6() {
		employee1 = new Employee("Tony", 20.2, 12);
		
		employee1.setHourlySalary(32);
		employee1.setNumberOfHours(10);
		
		employee1.increaseSalary(32.7);
		assertEquals(42.464, employee1.getHourlySalary(), EPSILON);
		assertEquals(424.64, employee1.monthlySalary(0), EPSILON);
		
	}

}
