/**
 * The class HotAirBalloon extends the class Aircraft. It inherits all the
 * methods from the superclass. It has an additional field gasTemperature
 * (gasTemperature in degrees Celsius of the HotAirBalloons gas)
 * 
 * The class consists of a constructor, getter and setter for the gas
 * temperature and a toString method
 * 
 * @author Seapaddy
 * @version 2017-11-03
 */
public class HotAirBalloon extends Aircraft {
	private double gasTemperature;

	/**
	 * Constructor for the HotAirBalloon Class, uses inheritance from the super
	 * class to construct maxSpeed, maxWeight, and maxPersons.
	 * 
	 * @param maxSpeed
	 *            is the maximum speed of the hot air balloon
	 * @param maxWeight
	 *            is the maximum weight of the hot air balloon
	 * @param maxPersons
	 *            is the maximum capacity of people in the hot air balloon
	 * @param gasTemperature
	 *            is the gas temperature of the hot air balloon
	 */
	public HotAirBalloon(double maxSpeed, double maxWeight, int maxPersons, double gasTemperature) {
		super(maxSpeed, maxWeight, maxPersons);
		this.gasTemperature = gasTemperature;
	}

	/**
	 * getter for the gas temperature of the hot air balloon
	 * 
	 * @return the double value of the gas temperature
	 */
	public double getGasTemperature() {
		return gasTemperature;
	}

	/**
	 * setter for the gas temperature of the hot air balloon
	 * 
	 * @param gasTemperature
	 *            is the value of the new gas temperature of the hot air balloon
	 */
	public void setGasTemperature(double gasTemperature) {
		this.gasTemperature = gasTemperature;
	}

	/**
	 * toString method of the hot air balloon, uses inheritance for the initial
	 * maximum speed, maximum weight and maximum person capacity of the String and
	 * concatenates the gas temperature information
	 * 
	 * @return a string representation of the HotAirBalloon
	 */
	@Override
	public String toString() {
		return super.toString() + " It has a gas temperature of maximally " + gasTemperature + "\u00b0C.";
	}

}
