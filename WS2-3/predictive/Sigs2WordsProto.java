package predictive;

import java.util.Set;

/**
 * Sigs2WordsProto is a command-line program that prints possible words matching
 * to an input signatures. The input signatures are arguments from the command
 * line input.
 * 
 * @author Seapaddy
 * @version 2018-02-01
 *
 */
public class Sigs2WordsProto {
	/**
	 * main method executes the signatureToWords method from the PredictivePrototype
	 * class for each input argument from the command line, and prints the possible
	 * words linking to the signature in the command line
	 * 
	 * @param args
	 *            - arguments in the command line
	 */
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].matches("[2-9]+")) {
				System.out.print(args[i] + ": ");
				Set<String> possibleWords = PredictivePrototype.signatureToWords(args[i]);
				for (String s : possibleWords) {
					System.out.print(s + " ");
				}
				System.out.println();
			}
		}
	}
}
