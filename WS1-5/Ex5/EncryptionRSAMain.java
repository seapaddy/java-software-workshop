/**
 * Main function to test RSA encryption class
 * @author Seapaddy
 * @Version 2017-11-29
 */
public class EncryptionRSAMain {
	public static void main(String[] args) {
		// message to be encrypted
		long message = 65;
		
		// testing for primes p = 61, q = 53, e = 17
		EncryptionRSA primeNumbers = new EncryptionRSA(61, 53, 17);
		System.out.println(primeNumbers.toString());
		System.out.println("Encryption for the message " + message +" is " + primeNumbers.encrypt(message));
		System.out.println("And decryption for that same message is " + primeNumbers.decrypt());
		System.out.println();
		
		// testing for primes p = 293, q = 317, e = 97
		EncryptionRSA primeNumbers2 = new EncryptionRSA(293, 317, 97);
		System.out.println(primeNumbers2.toString());
		System.out.println("Encryption for the message " + message +" is " + primeNumbers2.encrypt(message));
		System.out.println("And decryption for that same message is " + primeNumbers2.decrypt());
		System.out.println();
		
		// testing for primes p = 99991, q = 8999, e = 14983
		EncryptionRSA primeNumbers3 = new EncryptionRSA(99991, 8999, 14983);
		System.out.println(primeNumbers3.toString());
		System.out.println("Encryption for the message " + message +" is " + primeNumbers3.encrypt(message));
		System.out.println("And decryption for that same message is " + primeNumbers3.decrypt());
		System.out.println();
		
		// testing for random primes below max prime
		int maxPrime = 400;
		EncryptionRSA primeNumbers4 = new EncryptionRSA(maxPrime);
		System.out.println(primeNumbers4.toString());
		System.out.println("Encryption for the message " + message + " is " + primeNumbers4.encrypt(message));
		System.out.println("And decryption for that same message is " + primeNumbers4.decrypt());	
	}
}
