package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ListDictionary contains a constructor which searches the dictionary provided,
 * and creates an ordered WordSig object 'dictionaryPairs' of the words in the
 * dictionary matched with their signature.
 * 
 * 'dictionaryPairs' is used to quickly search for words matching the input
 * signature in the method signature to words.
 * 
 * ListDictionary implements the Interface Dictionary
 * 
 * @author Seapaddy
 * @version 2018-02-01
 *
 */

public class ListDictionary implements Dictionary {
	private ArrayList<WordSig> dictionaryPairs = new ArrayList<WordSig>();

	/**
	 * Constructor for ListDictionary, assigns words and their matching signatures
	 * to the variable dictionaryPairs, which is an ArrayList of WordSig objects.
	 * Collection.sort stores the dictionary in sorted order according to their
	 * signature.
	 * 
	 * @param path
	 *            - String representation of location of the dictionary in the
	 *            directory of the computer
	 * @throws illegalArgumentException
	 *             - if the dictionary file can not be found
	 */
	public ListDictionary(String path) {
		super();
		try {
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
				String word = sc.nextLine().toLowerCase();
				if (PredictivePrototype.isValidWord(word)) {
					WordSig wordPair = new WordSig(word);
					dictionaryPairs.add(wordPair);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("This file can not be found!");
		}
		Collections.sort(dictionaryPairs);
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
		Set<String> returnSet = new HashSet<String>();
		WordSig search = new WordSig(null);
		search.setSignature(signature);
		int index = Collections.binarySearch(dictionaryPairs, search);
		int indexUp = index;
		if (index < 0) {
			return returnSet;
		}
		while (index > 0 && dictionaryPairs.get(index).getSignature().equals(signature)) {
			returnSet.add(dictionaryPairs.get(index).getWords());
			index--;
		}
		while (indexUp < (dictionaryPairs.size()) && dictionaryPairs.get(indexUp).getSignature().equals(signature)) {
			returnSet.add(dictionaryPairs.get(indexUp).getWords());
			indexUp++;
		}
		return returnSet;
	}

	/**
	 * @return - the input dictionary as a String of word and their matching
	 *         signature
	 */
	public String toString() {
		StringBuffer returnString = new StringBuffer();
		for (int i = 0; i < dictionaryPairs.size(); i++) {
			returnString.append(dictionaryPairs.get(i).getWords());
			returnString.append(": ");
			returnString.append(dictionaryPairs.get(i).getSignature());
			returnString.append("\n");
		}
		return returnString.toString();
	}
}
