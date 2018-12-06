/**
 * Class CyrenePrimes contains the blueprint for the sieve method, which
 * calculates the prime numbers using Eratosthenes of Cyrenes efficient method
 * for calculating primes. The sieve method receives an integer variable max and
 * calculates the primes between 0 and max, which are returned within an integer
 * array.
 * 
 * @author SeaPaddy  
 * @version 2017-11-28
 */
public class CyrenePrimes {
	/**
	 * sieve creates a boolean array with length max+1 so all integers from 0 to max
	 * inclusive are included. all booleans are set to true initially, excluding 0
	 * and 1 as they are not prime numbers. for loops below find the left most true,
	 * this element will be prime and set all multiples of this element to false
	 * throughout the remainder of the array. sieve terminates once the element in
	 * question is greater than the square root of the max value, as all primes
	 * within the range will have been calculated. returns the primes calculated
	 * within an integer array.
	 * 
	 * @param max
	 *            The maximum integer in the range of primes calculated
	 * @return The integer array of prime numbers in range 0 to max
	 */
	public static int[] sieve(int max) {
		// +1 so the sieve includes all values including max
		boolean[] sieve = new boolean[max + 1];

		for (int i = 0; i < sieve.length; i++) {
			if (i > 1) {
				sieve[i] = true;
			} else {
				// set sieve 0 and 1 to false as 0 and 1 are never prime numbers
				sieve[i] = false;
			}
		}

		/**
		 * example of for loop below: for i == 2 sets 2 as prime number and removes all
		 * multiples of 2 throughout array. within the inner for loop incrementing j by
		 * i each time sets all multiples of the current number i to false as they are
		 * not prime. method stops once i is greater than the square root of max, as all
		 * primes have been calculated by this point.
		 */
		// outerloop set so can break out of nested loops
		outerloop: for (int i = 2; i < sieve.length; i++) {
			if (sieve[i] == true) {
				// if prime is larger than square root of max
				if (i > Math.sqrt(max)) {
					break outerloop;
				}
				for (int j = i + i; j < sieve.length; j += i) {
					sieve[j] = false;
				}
			}
		}
		// checks the length needed for the return array
		int returnArrayLength = 0;
		for (boolean b : sieve) {
			if (b == true) {
				returnArrayLength++;
			}
		}

		/**
		 * creates a new integer array, with length returnArrayLength as calculated
		 * above, rArrayCurrentPosition is the position each prime should be added to the
		 * return array
		 */
		int returnArrayCurrentPosition = 0;
		int[] returnArray = new int[returnArrayLength];
		for (int i = 0; i < sieve.length; i++) {
			if (sieve[i] == true) {
				returnArray[returnArrayCurrentPosition] = i;
				returnArrayCurrentPosition++;
			}
		}
		return returnArray;
	}
}
