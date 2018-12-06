

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeDictionary contains a constructor which searches the dictionary provided,
 * and creates a Tree representation of the dictionary with words stored in the
 * matching signature locations throughout the dictionary.
 * 
 * TreeDictionary implements the Interface Dictionary
 * 
 * @author SeaPaddy
 * @version 2018-02-09
 *
 */
public class TreeDictionary implements Dictionary {
	private Tree<String> dictionaryTree = new Tree<String>();

	/**
	 * Constructor for TreeDictionary, searches through a dictionary file located at
	 * the directory position 'path'. Uses the insert Tree function to add the
	 * current word in it matching signature locations throughout the tree
	 * 'dictionaryTree'
	 * 
	 * @param path
	 *            - String representation of location of the dictionary in the
	 *            directory of the computer
	 */
	public TreeDictionary(String path) {
		try {

			Scanner sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
				String word = sc.nextLine().toLowerCase();
				if (PredictivePrototype.isValidWord(word)) {
					String signature = PredictivePrototype.wordToSignature(word);
					dictionaryTree.insert(word, signature);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * signatureToWords is an implemented method from the Dictionary interface. It
	 * returns a set of possible words, or prefixes to words linked to the matching
	 * signature input.
	 * 
	 * @return - returns a set with words and prefix-matched words the same with
	 *         character length the same as the input signature.
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		Set<String> returnSet = new TreeSet<String>();
		Set<String> words = dictionaryTree.getWords(signature);
		int length = signature.length();
		words.forEach(i -> returnSet.add(i.substring(0, length)));
		return returnSet;
	}
}
