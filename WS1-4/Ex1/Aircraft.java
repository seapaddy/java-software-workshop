/**
 * The class Aircraft consists of the fields maxSpeed, maxWeight and maxPersons.
 * The class consists of a constructor, getters and setters for the field
 * variables and a toString method.
 * 
 * @author Seapaddy
 * @version 2017-11-03
 */
public class Aircraft {
	private double maxSpeed;
	private double maxWeight;
	private int maxPersons;

	/**
	 * Constructor for the Aircraft Class
	 * 
	 * @param maxSpeed
	 *            The double maximum speed of the aircraft
	 * @param maxWeight
	 *            The double maximum weight of the aircraft
	 * @param maxPersons
	 *            The double maximum person capacity of the aircraft
	 */
	public Aircraft(double maxSpeed, double maxWeight, int maxPersons) {
		super();
		this.maxSpeed = maxSpeed;
		this.maxWeight = maxWeight;
		this.maxPersons = maxPersons;
	}

	/**
	 * getter for the maximum speed of the aircraft
	 * 
	 * @return The double maximum speed value of the aircraft
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * setter for the maximum speed of the aircraft
	 * 
	 * @param maxSpeed
	 *            The new double maximum speed value of the aircraft
	 */
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * getter for the maximum weight of the aircraft
	 * 
	 * @return The double maximum weight value of the aircraft
	 */
	public double getMaxWeight() {
		return maxWeight;
	}

	/**
	 * setter for the maximum weight of the aircraft
	 * 
	 * @param maxWeight
	 *            The new double maximum weight value of the aircraft
	 */
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	/**
	 * getter for the maximum person capacity of the aircraft
	 * 
	 * @return The maximum person capacity of the aircraft
	 */
	public int getMaxPersons() {
		return maxPersons;
	}

	/**
	 * setter for the maximum person capacity of the aircraft
	 * 
	 * @param maxPersons
	 *            The new maximum person capacity of the aircraft
	 */
	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}

	/**
	 * toString method for the aircraft, returns "person" singular if 1 maxPersons
	 * and "persons" otherwise.
	 * 
	 * @return A String representation of the aircraft
	 */
	@Override
	public String toString() {
		String person = "persons";
		if (maxPersons == 1) {
			person = "person";
		} 

		return "The aircraft has a maximal speed of " + maxSpeed + " km/h and a maximal weight of " + maxWeight
				+ " kg. It can carry " + maxPersons + " " + person + ".";
	}

}
