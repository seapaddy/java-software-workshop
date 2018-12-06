package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * MapDictonary stores a dictionary as a map of signatures. Each signature
 * points to a set of possible words matching that signature. The map is created
 * in the constructor, converting the information from an input dictionary.
 * 
 * Tree map is a provides a structure of signatures, with each signature linked
 * to the set of matching words.
 * 
 * TreeMap has been used so the positions of the signatures are in order.
 * Although it takes slightly longer than HashMap to compile the initial
 * dictionary, once the dictionary is created it guarantees to find the key in
 * log(n) time. TreeMap produces a similar tree structure as used in exercise 2.
 * 
 * @author Seapaddy
 * @version 2018-02-01
 *
 */
public class MapDictionary implements Dictionary {
	private TreeMap<String, Set<String>> dictionary = new TreeMap<String, Set<String>>();

	/**
	 * constructor for MapDictionary objects. Creates a tree map of signature keys,
	 * which point to a set of possible words matching that signature.
	 * 
	 * @param path
	 *            - String representation of location of the dictionary in the
	 *            directory of the computer
	 */
	public MapDictionary(String path) {
		try {
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
				String word = sc.nextLine().toLowerCase();
				if (PredictivePrototype.isValidWord(word)) {
					String signature = PredictivePrototype.wordToSignature(word);
					Set<String> set = dictionary.get(signature);

					if (set == null) {
						set = new TreeSet<String>();
						set.add(word);
						dictionary.put(signature, set);
					} else {
						set.add(word);
					}
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("The file you wanted can not be found.");
		}

	}

	/**
	 * Signature to words takes a numerical signature and returns a set of possible
	 * matching words from the dictionary. The returned list has no duplicates as
	 * Set does not allow duplicates. This method overrides the method in the
	 * dictionary interface.
	 * 
	 * @param signature
	 *            - String of digits between 2 and 9 inclusive
	 * @return - Set of possible matching words to the input signature
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		// of input signatures all map to words, this method is faster
		Set<String> possibleWords = dictionary.get(signature);
		if (possibleWords != null) {
			return possibleWords;
		} else {
			return new TreeSet<String>();
		}
	}

	/**
	 * to String() method allows for printing the map representation of the
	 * dictionary with words matching their signature value
	 */
	public String toString() {
		Set<Entry<String, Set<String>>> entries = dictionary.entrySet();
		StringBuffer returnString = new StringBuffer();
		for (Entry<String, Set<String>> entry : entries) {
			returnString.append(entry.toString());
			returnString.append("\n");
		}
		return returnString.toString();
	}

}
