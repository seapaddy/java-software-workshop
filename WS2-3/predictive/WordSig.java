package predictive;

/**
 * WordSig pairs words and their matching signatures
 * 
 * @author Seapaddy
 * @version 2018-02-01
 *
 */

public class WordSig implements Comparable<WordSig> {
	private String words;
	private String signature;

	/**
	 * constructor accepts words and calculates their matching signature
	 * 
	 * @param words
	 *            - String word. Example: A word from a dictionary
	 */
	public WordSig(String words) {
		this.words = words;
		if (!(words == null)) {
			this.signature = PredictivePrototype.wordToSignature(words);
		}
	}

	/**
	 * uses the compare to method from the Comparable class, allows for sorting of a
	 * list. Compares each signature in the list, if the Collections.sort() method
	 * is used for the WordSig object it will be sorted according to signature.
	 * 
	 * Essentially for a dictionary it allows all words with the same signature to
	 * be stored next to one another
	 */
	public int compareTo(WordSig ws) {
		return this.signature.compareTo(ws.signature);
	}

	/**
	 * @return - the word of this WordSig object
	 */
	public String getWords() {
		return words;
	}

	/**
	 * @return - the signature of this WordSig object
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * allows for setting of the signature if this.word is set to null. Is provided
	 * so Collections function binarySearch executes efficiently
	 * 
	 * @param signature
	 *            - the signature to be allocated for the WordSig object
	 */
	public void setSignature(String signature) {
		if (words == null) {
			this.signature = signature;
		} else {
			throw new IllegalAccessError(
					"You can only insert a signature in a WordSig object with a word equal to null");
		}
	}

}
