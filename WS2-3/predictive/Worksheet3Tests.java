package predictive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Worksheet3Tests {
	private String pathToDictionary = "words";
	
	/**
	 * checks all lower case letters in the alphabet are accepted
	 */
	@Test
	public void testEx1_1() {
		String expected = "22233344455566677778889999";
		String actual = PredictivePrototype.wordToSignature("abcdefghijklmnopqrstuvwxyz");
		
		assertEquals(expected, actual);
	}
	
	/**
	 * checks non alphabetical is replaced by space
	 */
	@Test
	public void testEx1_2() {
		String expected = " ";
		String actual = PredictivePrototype.wordToSignature("'");
		
		assertEquals(expected, actual);
	}
	
	/**
	 * checks signatures return matching alphabetical characters
	 */
	@Test
	public void testEx1_3() {
		assertEquals("[a, b, c]", PredictivePrototype.signatureToWords("2").toString());
		assertEquals("[d, e, f]", PredictivePrototype.signatureToWords("3").toString());
		assertEquals("[g, h, i]", PredictivePrototype.signatureToWords("4").toString());
		assertEquals("[j, k, l]", PredictivePrototype.signatureToWords("5").toString());
		assertEquals("[m, n, o]", PredictivePrototype.signatureToWords("6").toString());
		assertEquals("[p, q, r, s]", PredictivePrototype.signatureToWords("7").toString());
		assertEquals("[t, u, v]", PredictivePrototype.signatureToWords("8").toString());
		assertEquals("[w, x, y, z]", PredictivePrototype.signatureToWords("9").toString());
	}
	
	/**
	 * checks returns an empty set for a signature that matches no words
	 */
	@Test
	public void testEx1_4() {
		assertEquals("[]", PredictivePrototype.signatureToWords("1").toString());
	}
	
	/**
	 * checks List Dictionary 2 - 9 return the matching characters
	 */
	@Test
	public void testEx2_1() {
		String arguments[] = {"2", "3", "4", "5", "6", "7", "8", "9"};
		System.out.println("Check for Signature to Words List Dictionary");
		Sigs2WordsList.main(arguments);	
		System.out.println();
	}
	
	/**
	 * checks signatures return matching alphabetical characters
	 */
	@Test
	public void testEx2_2() {
		ListDictionary list = new ListDictionary(pathToDictionary);
		
		assertEquals("[a, b, c]", list.signatureToWords("2").toString());
		assertEquals("[d, e, f]", list.signatureToWords("3").toString());
		assertEquals("[g, h, i]", list.signatureToWords("4").toString());
		assertEquals("[j, k, l]", list.signatureToWords("5").toString());
		assertEquals("[m, n, o]", list.signatureToWords("6").toString());
		assertEquals("[p, q, r, s]", list.signatureToWords("7").toString());
		assertEquals("[t, u, v]", list.signatureToWords("8").toString());
		assertEquals("[w, x, y, z]", list.signatureToWords("9").toString());
	}
	
	/**
	 * checks returns an empty set for a signature that matches no words
	 */
	@Test
	public void testEx2_3() {
		ListDictionary list = new ListDictionary(pathToDictionary);
		
		assertEquals("[]", list.signatureToWords("1").toString());
	}
	
	/**
	 * checks signatures return matching alphabetical characters
	 */
	@Test
	public void testEx3_1() {
		MapDictionary map = new MapDictionary(pathToDictionary);
		
		assertEquals("[a, b, c]", map.signatureToWords("2").toString());
		assertEquals("[d, e, f]", map.signatureToWords("3").toString());
		assertEquals("[g, h, i]", map.signatureToWords("4").toString());
		assertEquals("[j, k, l]", map.signatureToWords("5").toString());
		assertEquals("[m, n, o]", map.signatureToWords("6").toString());
		assertEquals("[p, q, r, s]", map.signatureToWords("7").toString());
		assertEquals("[t, u, v]", map.signatureToWords("8").toString());
		assertEquals("[w, x, y, z]", map.signatureToWords("9").toString());
	}
	
	/**
	 * checks returns an empty set for a signature that matches no words
	 */
	@Test
	public void testEx3_2() {
		MapDictionary map = new MapDictionary(pathToDictionary);
		
		assertEquals("[]", map.signatureToWords("1").toString());
	}
	
	/**
	 * checks signatures return matching alphabetical characters
	 */
	@Test
	public void testEx4_1() {
		TreeDictionary tree = new TreeDictionary(pathToDictionary);
		
		assertEquals("[a, b, c]", tree.signatureToWords("2").toString());
		assertEquals("[d, e, f]", tree.signatureToWords("3").toString());
		assertEquals("[g, h, i]", tree.signatureToWords("4").toString());
		assertEquals("[j, k, l]", tree.signatureToWords("5").toString());
		assertEquals("[m, n, o]", tree.signatureToWords("6").toString());
		assertEquals("[p, q, r, s]", tree.signatureToWords("7").toString());
		assertEquals("[t, u, v]", tree.signatureToWords("8").toString());
		assertEquals("[w, x, y, z]", tree.signatureToWords("9").toString());
	}
	
	/**
	 * checks returns an empty set for a signature that matches no words
	 */
	@Test
	public void testEx4_2() {
		TreeDictionary tree = new TreeDictionary(pathToDictionary);
		
		assertEquals("[]", tree.signatureToWords("1").toString());
	}
}
