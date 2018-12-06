package predictive;

import java.util.Set;

/**
 * Sigs2WordsList is a command-line program that prints possible words matching
 * to an input signatures. The input signatures are arguments from the command
 * line input.
 * 
 * @author Seapaddy
 * @version 2018-02-01
 *
 */
public class Sigs2WordsList {
	private static String pathToDictionary = "words";
	/**
	 * Main method creates a list dictionary object. Using the dictionary object,
	 * main prints sets of possible words matching to the input arguments from the
	 * command line. The input command line arguments should only contain digits 2-9
	 * inclusive.
	 * 
	 * @param args
	 *            - arguments in the command line
	 */
	public static void main(String[] args) {
		ListDictionary dictionary = new ListDictionary(pathToDictionary);
		for (int i = 0; i < args.length; i++) {
			System.out.print(args[i] + ": ");
			Set<String> possibleWords = dictionary.signatureToWords(args[i]);
			for (String s : possibleWords) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}


