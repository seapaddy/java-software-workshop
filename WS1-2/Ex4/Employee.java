/**	The class Employee which creates Employee objects
 *	Each Employee object has 3 parameters, employees name, hourly salary and number of hours worked per month
 *	
 *	Employee class has 3 getters, to return the employee name, hourly salary and number of hours worked per month
 *	Employee class has 3 setters, to set the employee name, hourly salary and number of hours worked per month
 * 	Employee class has a toString() method to print an objects attributes
 * 
 * 	monthlySalary function takes a parameter taxRate and returns employees monthly salary minus tax per month
 * 	increaseSalary function takes parameter percentage and sets employees new salary accordingly
 *
 *	@author Seapaddy
 *	@version 2017-10-05, last changed 2017-10-18
 */

public class Employee {
	private String name;
	private double hourlySalary;
	private int numberOfHours;
	
	/**
	 * Constructor for the Employee class, initialises an employee objects attributes
	 * 
	 * @param name The name of the employee
	 * @param hourlySalary The hourly salary of the employee
	 * @param numberOfHours The number of hours worked per month of the employee
	 */
	public Employee(String name, double hourlySalary, int numberOfHours) {
		this.name = name;
		this.hourlySalary = hourlySalary;
		this.numberOfHours = numberOfHours;
	}

	/**
	 * Returns the name of the Employee object
	 * 
	 * @return Returns the name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name parameter of the Employee object, to String name
	 * 
	 * @param name Sets Employee objects name parameter to name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the hourly salary of the Employee object
	 * 
	 * @return Returns the hourly salary of the employee
	 */
	public double getHourlySalary() {
		return hourlySalary;
	}

	/**
	 * Sets the hourly salary parameter of the Employee object, to double hourlySalary
	 * 
	 * @param hourlySalary Sets Employee objects hourly salary parameter to hourlySalary
	 */
	public void setHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	/**
	 * Returns the number of hours worked per month parameter of the employee object
	 * 
	 * @return Returns the number of hours worked per month of the employee
	 */
	public int getNumberOfHours() {
		return numberOfHours;
	}

	/**
	 * Sets the number of hours worked per month parameter of the Employee object, to int numberOfHours
	 * 
	 * @param numberOfHours Sets Employee objects number of hours worked per month parameter to numberOfHours
	 */
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	/**
	 * @return Returns the employee objects attributes to a readable string
	 */
	@Override
	public String toString() {
		return name + " has an hourly salary of " + hourlySalary + " \u00a3 and has worked last month for " + numberOfHours + " hours.";
	}
	
	/**
	 * Computes the monthly salary minus tax of the employee object
	 * 
	 * @param taxRate The percentage of tax per earnings of the employee
	 * @return Returns the monthly salary minus tax of the employee
	 */
	public double monthlySalary(double taxRate) {
		return this.hourlySalary * this.numberOfHours * (1.0 - taxRate/100.0);
	}
	
	/**
	 * Computes the change in employees hourly salary, and writes new hourly salary to employee object
	 * 
	 * @param percentage The percentage change of the employees hourly salary
	 */
	public void increaseSalary(double percentage) {
		this.hourlySalary *= (percentage/100.0)+1.0;
	}
}
