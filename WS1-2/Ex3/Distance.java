/**	The class Distance which creates Distance objects
 *	Each Distance object has 1 initialised parameter, distance in kilometres
 *
 *	3 final variables, KM_PER_MILE which is the number of kilometres in a mile
 *	M_PER_KM is the number of metres in a kilometre
 *	YRDS_PER_KM is the number of yards in a kilometre
 *	
 *	Distance class has 4 getters, to return the distance in kilometres, miles, metres and yards
 *	Distances are converted from Kilometres using the following conversion table
 *	1.60934 Kilometres ~ 1 Mile
 *	1000 Metres = 1 Kilometre
 *	1760 Yards = 1 Miles
 *
 *	@author Seapaddy
 *	@version 2017-10-05, last changed 2017-10-18
 */

public class Distance {
	private double kilometres;
	
	public static final double KM_PER_MILE = 1.60934;
	public static final double M_PER_KM = 1000;
	public static final double YRDS_PER_KM = 1760/1.60934;
	
	/**
	 * Constructor for the Distance class, initialising a distance objects attributes
	 * 
	 * @param km The value of the distance in Kilometres
	 */
	public Distance(double km) {
		this.kilometres = km;
	}

	/**
	 * Returns the value of Kilometres of the Distance object
	 * 
	 * @return Returns the value of the Kilometres
	 */
	public double getKilometres() {
		return kilometres;
	}

	/**
	 * Returns the value of the Miles of the Distance object
	 * Calculates the value of the Miles using Miles = Kilometres/1.60934
	 * 
	 * @return Returns the value of the Miles
	 */
	public double getMiles() {
		return kilometres / KM_PER_MILE;
	}

	/**
	 * Returns the value of the Metres of the Distance object
	 * Calculates the value of Metres using the conversion Metres = 1000 * kilometres
	 * 
	 * @return Returns the value of the Metres
	 */
	public double getMetres() {
		return kilometres * M_PER_KM;
	}

	/**
	 * Returns the value of the Yards of the Distance object
	 * Calculates the value of the Yards using the conversion Yards = Kilometres / 1.60934 * 1760
	 * 
	 * @return Returns the value of the Yards
	 */
	public double getYards() {
		return kilometres * YRDS_PER_KM;
	}
}
