
/**
 * The interface Sortable extends the interface Sorting. Sortable contains one
 * method compareValue. This method can be used by Class's that implement the
 * Sortable interface, in this case the Car Class and Customer Class.
 * 
 * @author Seapaddy
 * @version 2017-11-03, last changed 2017-11-10
 */
public interface Sortable extends Sorting {
	/**
	 * compareValue returns the maximum speed of the car for the Car Class and
	 * returns the total money spent by the customer for the Customer class
	 * 
	 * @return the return value of compareValue for the objects class
	 */
	double compareValue();
}
