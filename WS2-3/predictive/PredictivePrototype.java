package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Predictive prototype is the initial design for a predictive text application,
 * similar to those used in early mobile phones. It converts words from the
 * dictionary into numerical signatures and compares these with number input to
 * predict the word a user may be attempting to type.
 * 
 * @author Seapaddy
 * @version 2018-02-01
 *
 */
public class PredictivePrototype {
	private static String pathToDictionary = "words";
	/**
	 * wordToSignature takes a word and returns a numerical signature. Example
	 * "home" will return "4663".
	 * 
	 * StringBuffer is more efficient than String because objects of type String are
	 * read only and immutable, therefore can not be modified. Java modifies a
	 * String by converting to a StringBuffer, followed by converting back to a
	 * String.
	 * 
	 * StringBuffer is used to represent characters that can be modified, therefore
	 * in this class it is quicker and more efficient to use StringBuffer. For each
	 * word the signature is calculated character by character, and appended to the
	 * return signature.
	 * 
	 * pre-condition: String word input is all lower case characters
	 * 
	 * @param word
	 *            - input string, alphabetical characters will produce a numerical
	 *            signature, non-alphabetical characters will return a space " ".
	 * @return - the String signature of the input String. (should contain all
	 *         digits 2-9)
	 */
	public static String wordToSignature(String word) {
		StringBuffer characters = new StringBuffer(word);
		StringBuffer signature = new StringBuffer();
		for (int i = 0; i < characters.length(); i++) {
			// Converts char input into numerical value
			int currentCharacterSignature = characters.charAt(i) - 'a' + 1;

			// checks for s and v character cases (four letters on signature '7', have to
			// count for additional)
			if (currentCharacterSignature == 19 || currentCharacterSignature == 22) {
				currentCharacterSignature += 4;
			}
			// when
			else if (currentCharacterSignature == 25 || currentCharacterSignature == 26) {
				currentCharacterSignature += 3;
			}
			// when non-alphabetical return space " " in resulting signature
			else if (currentCharacterSignature <= 0 || currentCharacterSignature >= 27) {
				currentCharacterSignature = 0;
			} else {
				currentCharacterSignature += 5;
			}
			// calculates the signature value of the letter
			signature.append(currentCharacterSignature / 3);
		}
		// returns the signature, replaces all occurrences of "0" with " ".
		return signature.toString().replace("0", " ");
	}

	/**
	 * signatureToWords takes a signature and returns potential words from a
	 * dictionary. No duplicates in return Set, as Set does not allow duplicates.
	 * 
	 * The dictionary is not stored in the java program, therefore for each
	 * signature the method will have to search the entire dictionary of words for
	 * matches. This will cause the program to be inefficient as it will have to
	 * calculate the signature of each word in the dictionary on every search. If n
	 * words are to be converted it will have to traverse and calculate signatures n
	 * times through the dictionary.
	 * 
	 * @param signature
	 *            - String signature. signature should contain only digits ranging
	 *            between 2 and 9 inclusive.
	 * @throws illegalArgumentException
	 *             - if the dictionary file can not be found
	 * @return - Set<String> of possible words from a dictionary linking to the
	 *         input signature
	 */
	public static Set<String> signatureToWords(String signature) {
		try {
			Scanner sc = new Scanner(new File(pathToDictionary));
			// tree set is used so the returned set is in alphabetical order
			Set<String> returnList = new TreeSet<String>();
			while (sc.hasNextLine()) {
				String word = sc.nextLine().toLowerCase();
				if (isValidWord(word)) {
					if (wordToSignature(word).equals(signature)) {
						returnList.add(word);
					}
				}
			}
			sc.close();
			return returnList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("This file can not be found!");
		}
	}

	/**
	 * helper method to ignore unwanted lines with non-alphabetical characters from
	 * the dictionary. Checks each word contains characters between a and z, if not
	 * they are ignored.
	 * 
	 * (-'a' + 1 returns the integer 1, and so on to 26 as you move through the
	 * alphabet, therefore check the number is between 1 and 26 inclusive)
	 * 
	 * @param word
	 *            - a string
	 * @return - true if the word contains only lower case alphabetical characters,
	 *         false otherwise.
	 */
	static boolean isValidWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			int numericalEquivalent = word.charAt(i) - 'a' + 1;
			if (numericalEquivalent < 1 || numericalEquivalent > 26) {
				return false;
			}
		}
		return true;
	}

}
