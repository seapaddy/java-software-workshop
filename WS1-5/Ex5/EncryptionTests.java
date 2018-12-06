import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EncryptionTests {
	private long message1, message2, message3;

	@Before
	public void setUp() {
		message1 = 65;
		message2 = 25;
		message3 = -10;
	}

	/**
	 * check encryption and decryption of message 65 using RSA with prime p = 61, q
	 * = 53, e = 17;
	 */
	@Test
	public void test1() {
		EncryptionRSA encryption = new EncryptionRSA(61, 53, 17);
		long encryptionExpected = 2790;
		long encryptionActual = encryption.encrypt(message1);

		assertEquals(encryptionExpected, encryptionActual);

		long decryptActual = encryption.decrypt();

		assertEquals(message1, decryptActual);
	}

	/**
	 * check encryption and decryption of message 65 using RSA with prime p = 293, q
	 * = 317, e = 97;
	 */
	@Test
	public void test2() {
		EncryptionRSA encryption = new EncryptionRSA(293, 317, 97);
		long encryptionExpected = 38190;
		long encryptionActual = encryption.encrypt(message1);

		assertEquals(encryptionExpected, encryptionActual);

		long decryptActual = encryption.decrypt();

		assertEquals(message1, decryptActual);
	}

	/**
	 * check encryption and decryption of message 65 using RSA with prime p = 99991,
	 * q = 8999, e = 14983;
	 */
	@Test
	public void test3() {
		EncryptionRSA encryption = new EncryptionRSA(99991, 8999, 14983);
		long encryptionExpected = 892177137;
		long encryptionActual = encryption.encrypt(message1);

		assertEquals(encryptionExpected, encryptionActual);

		long decryptActual = encryption.decrypt();

		assertEquals(message1, decryptActual);
	}

	/**
	 * check encryption and decryption of message 25 using RSA with prime p = 293, q
	 * = 317, e = 97;
	 */
	@Test
	public void test4() {
		EncryptionRSA encryption = new EncryptionRSA(293, 317, 97);
		long encryptionExpected = 57267;
		long encryptionActual = encryption.encrypt(message2);

		assertEquals(encryptionExpected, encryptionActual);

		long decryptActual = encryption.decrypt();

		assertEquals(message2, decryptActual);
	}

	/**
	 * check encryption and decryption of message -10 using RSA with prime p = 293,
	 * q = 317, e = 97;
	 */
	@Test
	public void test5() {
		EncryptionRSA encryption = new EncryptionRSA(293, 317, 97);
		long encryptionExpected = -19516;
		long encryptionActual = encryption.encrypt(message3);

		assertEquals(encryptionExpected, encryptionActual);

		long decryptActual = encryption.decrypt();

		assertEquals(message3, decryptActual);
	}

	/**
	 * check decryption of message 65 using RSA with random primes, max prime of
	 * 50,000
	 */
	@Test
	public void test6() {
		int maxPrime = 50000;
		EncryptionRSA encryption = new EncryptionRSA(maxPrime);

		encryption.encrypt(message1);
		long decryptActual = encryption.decrypt();

		assertEquals(message1, decryptActual);
	}

}
