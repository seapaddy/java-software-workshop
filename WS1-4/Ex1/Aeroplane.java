/**
 * The class Aeroplane extends the class Aircraft. It inherits all the methods
 * from the superclass. It has an additional field range (range in km of the
 * aeroplane)
 * 
 * The class consists of a constructor, getter and setter for the range and a
 * toString method
 * 
 * @author Seapaddy
 * @version 2017-11-03
 */
public class Aeroplane extends Aircraft {
	private double range;

	/**
	 * Constructor for the Aeroplane Class, uses inheritance from the super class to
	 * construct maxSpeed, maxWeight, and maxPersons.
	 * 
	 * @param maxSpeed
	 *            The maximum speed of the Aeroplane
	 * @param maxWeight
	 *            The maximum weight of the Aeroplane
	 * @param maxPersons
	 *            The maximum person capacity of the Aeroplane
	 * @param range
	 *            The range in km of the Aeroplane
	 */
	public Aeroplane(double maxSpeed, double maxWeight, int maxPersons, double range) {
		super(maxSpeed, maxWeight, maxPersons);
		this.range = range;
	}

	/**
	 * getter for the range of the aircraft
	 * 
	 * @return the double range of the aircraft
	 */
	public double getRange() {
		return range;
	}

	/**
	 * setter for the range of the aircraft
	 * 
	 * @param range
	 *            value of the new range of the aircraft
	 */
	public void setRange(double range) {
		this.range = range;
	}

	/**
	 * toString method of the aeroplane, uses inheritance for some of the String and
	 * concatenates the range information
	 * @return a String representation of the Aeroplane.
	 */
	@Override
	public String toString() {
		return super.toString() + " It has a range of " + range + " km.";
	}
}
