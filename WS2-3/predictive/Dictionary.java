package predictive;

import java.util.Set;

/**
 * Dictionary interface - contains the method signatureToWords
 * 
 * @author Seapaddy
 * @version 2018-02-01
 *
 */
public interface Dictionary {
	/**
	 * signatureToWords converts is used to find the words matching signatures and
	 * returns them in a Set of Strings
	 * 
	 * @param signature
	 *            - the signature of the word
	 * @return - a Set of Strings containing words matching to the signature
	 */
	public Set<String> signatureToWords(String signature);
}
