/**
 * The Class Car implements the interface Sortable. The Class consists of the
 * fields maxSpeed, carNumber and make.
 * 
 * The class consists of a constructor, a toString method as well as
 * compareValue method (returns the maxSpeed of the Car)
 * 
 * @author Seapaddy
 * @version 2017-11-03
 */
public class Car implements Sortable {
	private double maxSpeed;
	private String carNumber;
	private String make;

	/**
	 * Constructor for the Car Class
	 * @param maxSpeed The maximum speed of the car
	 * @param carNumber The car number plate
	 * @param make The car manufacturer
	 */
	public Car(double maxSpeed, String carNumber, String make) {
		super();
		this.maxSpeed = maxSpeed;
		this.carNumber = carNumber;
		this.make = make;
	}

	/**
	 * @return a String representation of the Car
	 */
	@Override
	public String toString() {
		return "Car [maxSpeed=" + maxSpeed + ", carNumber=" + carNumber + ", make=" + make + "]";
	}

	/**
	 * compareValue method returns the maximum speed of the Car
	 * @return the maximum speed of the car
	 */
	public double compareValue() {
		return maxSpeed;
	}

}
