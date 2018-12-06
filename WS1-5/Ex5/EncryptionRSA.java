import java.util.NoSuchElementException;

/**
 * 
 * Variables Changed: p -> primeP, q -> primeQ, e -> primeExponenetial, n ->
 * modulus, d -> secretKey.
 * 
 * @author Seapaddy
 * @version 2017-11-28
 */
public class EncryptionRSA {
	private int primeP, primeQ, primeExponential;
	private long modulus, secretKey;
	private long encryptedMessage;

	/**
	 * Constructor for random prime number encryption. Finds random primes from
	 * array of primes created from sieve method in Cyrene Primes class.
	 * 
	 * @param maxPrimeValue
	 */
	public EncryptionRSA(int maxPrimeValue) {
		int[] allIntegerPrimes = CyrenePrimes.sieve(maxPrimeValue);
		this.primeP = allIntegerPrimes[(int) (Math.random() * allIntegerPrimes.length)];
		this.primeQ = allIntegerPrimes[(int) (Math.random() * allIntegerPrimes.length)];
		// only entered if primes are equal
		while (primeP == primeQ) {
			this.primeQ = allIntegerPrimes[(int) (Math.random() * allIntegerPrimes.length)];
		}
		this.modulus = primeP * primeQ;
		this.primeExponential = initialisePrimeExponential(allIntegerPrimes);
		this.secretKey = modInverse(primeExponential, lambda());
	}

	/**
	 * constructor if p (primeP), q (primeQ), and e (primeExponential) are known
	 * 
	 * @param p
	 *            prime p (primeP)
	 * @param q
	 *            prime q (primeQ)
	 * @param e
	 *            prime e (primeExponential)
	 */
	public EncryptionRSA(int p, int q, int e) {
		this.primeP = p;
		this.primeQ = q;
		this.modulus = p * q;
		this.primeExponential = e;
		this.secretKey = modInverse(primeExponential, lambda());
	}

	/**
	 * Method calculates the modular inverse of 2 numbers. Normal inverse is just
	 * 1/initial number. In modular inverse we don't have division operator. modular
	 * inverse is when ((A*A^-1) mod C = 1), eg if A is 9 and C is 5, inverse of A
	 * is 4. 9*4 = 1 mod 5, 36 = 1 mod 5 -> correct! Only numbers coprime with C
	 * (share no prime factors) have a modular inverse with C. Throws an element
	 * exception if there is no modular inverse.
	 * 
	 * @param a
	 *            in RSA is e (primeExponential)
	 * @param modulus
	 *            in RSA is lambda
	 * @return the modular inverse of e mod lambda
	 */
	public static long modInverse(long a, long modulus) {
		a = a % modulus;
		for (long i = 1; i < modulus; i++) {
			if ((a * i) % modulus == 1) {
				return i;
			}
		}
		throw new NoSuchElementException("There is not modular inverse!");
	}

	/**
	 * method for choosing a random prime for the value of e (primeExponential)
	 * within the range from 1 to the lowest common multiple, lambda, of p (primeP)
	 * and q (primeQ)
	 * 
	 * @param allIntegerPrimes
	 *            the array of prime numbers from 0 to maxPrime inclusive
	 * @return the value calculated for the prime exponential, e
	 */
	public int initialisePrimeExponential(int[] allIntegerPrimes) {
		long lambda = lambda();
		int exponential;
		int topElement = 0;
		for (int i = 0; i < allIntegerPrimes.length; i++) {
			if (lambda > allIntegerPrimes[i]) {
				topElement++;
			} else
				break;
		}
		exponential = allIntegerPrimes[(int) (Math.random() * topElement)];
		// checks exponential is co-prime with lambda
		while (lambda % exponential == 0) {
			exponential = allIntegerPrimes[(int) (Math.random() * topElement)];
		}
		return exponential;
	}

	/**
	 * Calculates the greatest common denominator of two numbers. In RSA encryption
	 * this is the two primes p and q
	 * 
	 * @param x
	 *            one element
	 * @param y
	 *            the other element
	 * @return the greatest common denominator
	 */
	public static long gcd(long x, long y) {
		while (y > 0) {
			long temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}

	/**
	 * Method calculates the lowest common multiple, lambda, of the two primes, p
	 * (primeP) and q (primeQ)
	 * 
	 * @return the value of lambda
	 */
	public long lambda() {
		return lcm(primeP, primeQ);
	}

	/**
	 * This method calculates the lowest common multiple of the two numbers. Lowest
	 * common multiple can be found using the greatest common denominator of two
	 * numbers. In RSA lambda equals lcm
	 * 
	 * @param x
	 *            in RSA it is prime p (primeP)
	 * @param y
	 *            in RSA it is prime q (primeQ)
	 * @return returns the lowest common denominator
	 */
	public static long lcm(long x, long y) {
		return (x - 1) * ((y - 1) / gcd(x - 1, y - 1));
	}

	/**
	 * power followed by modulus function. A fast method using binary structure to
	 * calculate power.
	 * 
	 * whilst exponential is not 0. method checks the right most bit position of the
	 * exponential. if the bit at this position is 1, multiply the result by the
	 * base and take the modulus, if bit at position is 0 do nothing. Shift the
	 * exponentials binary number to the right 1 bit (eg. if binary was 101 goes to
	 * 10 after >>) multiply the base by the current base to account for additional
	 * power. repeat the process until exponential is 0, all bits have been shifted.
	 * 
	 * @param base
	 *            the initial base value of the power function
	 * @param exponential
	 *            the power to which the base is calculated
	 * @param modulus
	 *            for RSA encryption all values need to be modulus, entering here
	 *            saves time within the calculations.
	 * @return the power_modulus of the input power function
	 */
	public static long powerFast(long base, long exponential, long modulus) {
		long result = 1;
		while (exponential != 0) {
			if ((exponential & 1) == 1) {
				result *= base;
				result %= modulus;
			}
			exponential >>= 1;
			base *= base;
			base %= modulus;
		}
		return result;
	}

	/**
	 * Encrypts the original message using the power_mod function
	 * 
	 * @param message
	 *            the message to be encrypted
	 * @return the encrypted message
	 */
	public long encrypt(long message) {
		encryptedMessage = powerFast(message, primeExponential, modulus);
		return encryptedMessage;
	}

	/**
	 * Decrypts the encrypted message using the power_mod function
	 * 
	 * @return the decrypted message (should be same as original)
	 */
	public long decrypt() {
		return powerFast(encryptedMessage, secretKey, modulus);
	}

	/**
	 * @return the String representation showing the private and secret for a pair
	 *         of prime numbers p and q.
	 */
	@Override
	public String toString() {
		return "For the prime numbers, p = " + primeP + ", q = " + primeQ + ":\nPrivate Key SK(n = " + modulus
				+ ", d = " + secretKey + ").\nPublic Key PK(n = " + modulus + ", e = " + primeExponential + ").";
	}
}
