/**
 * CyrenePrimesMain class contains a main method to test the CyrenePrimes
 * objects, and the sieve method for generating primes.
 * 
 * @author Seapaddy
 * @version 2017-11-28
 */
public class CyrenePrimesMain {

	/**
	 * main method to test CyrenePrimes objects
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int maxInteger = 50000;
		int[] primeArray = CyrenePrimes.sieve(maxInteger);
		// print all primes below maxInteger inclusive
		for (int i = 0; i < primeArray.length; i++) {
			System.out.println(primeArray[i]);
		}
		// print all number of primes below maxInteger inclusive
		System.out.println("\n" + primeArray.length);
	}
}
