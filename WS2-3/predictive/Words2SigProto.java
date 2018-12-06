package predictive;

/**
 * Words2SigProto is a command-line program that prints the matching signatures
 * from words entered as the arguments in the command line.
 * 
 * @author Seapaddy
 * @version 2018-02-01
 *
 */
public class Words2SigProto {
	/**
	 * main method executes the wordToSignature method for each argument entered
	 * into the command line
	 * 
	 * @param args
	 *            - arguments in the command line
	 */
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.print(" " + PredictivePrototype.wordToSignature(args[i]));
		}
	}
}
