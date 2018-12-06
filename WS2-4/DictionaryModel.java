import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Dictionary Model creates a phone texting application to imitate old mobile
 * phone text predictions.
 * 
 * DictionaryModel contains a constructor and 4 methods. getMessage which
 * returns the text message. addCharacter which adds characters to the current
 * word in the message. removeLastCharacter which removes incorrect input from
 * the message. nextMatch cycles through all the possible words depending on the
 * current word signature.
 * 
 * @author SeaPaddy
 * @version 2018-02-17
 *
 */
public class DictionaryModel extends Observable implements DictionaryModelInterface {
	private TreeDictionary dictionary;
	private List<String> composedMessage = new ArrayList<String>();
	private String currentKey = "";
	private List<String> words;
	private int currentWord, currentIndex = 0;

	/**
	 * constructor for Dictionary model, creates a tree of words from the dictionary
	 * at the path dictionaryFile
	 * 
	 * @param dictionaryFile
	 *            - path to dictionary file in directory
	 * @throws java.io.IOException
	 *             - if the constructor encounters an error throws an exception
	 */
	public DictionaryModel(String dictionaryFile) throws java.io.IOException {
		this.dictionary = new TreeDictionary(dictionaryFile);
	}

	/**
	 * constructor for Dictionary model, creates a tree of words from the dictionary
	 * at the default path "words" in the projects directory
	 * 
	 * @throws java.io.IOException
	 *             - if the constructor encounters an error throws an exception
	 */
	public DictionaryModel() throws java.io.IOException {
		this.dictionary = new TreeDictionary("words");
	}

	/**
	 * @return - returns the current text message
	 */
	@Override
	public List<String> getMessage() {
		return composedMessage;
	}

	/**
	 * 'addCharacter' adds a character to the composed message. The method notifies
	 * observers so the updates are shown in the GUI representation.
	 * 
	 * @param key
	 *            - the signature input from keypad listener
	 */
	@Override
	public void addCharacter(char key) {
		currentKey += key;
		words = new ArrayList<String>(dictionary.signatureToWords(currentKey));
		if (words.isEmpty()) {
			removeLastCharacter();
			setChanged();
			notifyObservers(composedMessage);
			return;
		}
		// Set<String> words = dictionary.signatureToWords(currentKey);
		// List<String> possibleWords = new ArrayList<String>(words);
		if (!composedMessage.isEmpty()) {
			if (composedMessage.size() == currentIndex + 1) {
				composedMessage.remove(composedMessage.get(currentIndex));
			}
		}
		if (words.isEmpty()) {
			composedMessage.add("");
		} else {
			currentWord = 0;
			composedMessage.add(words.get(currentWord));
		}
		setChanged();
		notifyObservers(composedMessage);

	}

	/**
	 * 'removeLastCharacter' removes the last character from the composed message,
	 * or if the composed message has no characters in the current word it removes
	 * the previous word if there is one. The method notifies observers so the
	 * updates are shown in the GUI representation.
	 */
	@Override
	public void removeLastCharacter() {
		if (currentKey.length() == 0) {
			if (currentIndex > 0) {
				currentIndex--;
				composedMessage.remove(composedMessage.get(currentIndex));
				setChanged();
				notifyObservers(composedMessage);
			}
			return;
		}
		if (currentKey.length() - 1 == 0) {
			currentKey = "";
		} else {
			currentKey = currentKey.substring(0, currentKey.length() - 1);
		}
		words = new ArrayList<String>(dictionary.signatureToWords(currentKey));
		if (!composedMessage.isEmpty()) {
			composedMessage.remove(composedMessage.get(currentIndex));
		}
		if (words.isEmpty()) {
			composedMessage.add("");
		} else {
			currentWord = 0;
			composedMessage.add(words.get(currentWord));
		}
		setChanged();
		notifyObservers(composedMessage);
	}

	/**
	 * 'nextMatch' recursively cycles through the set of words matching the current
	 * signature, and updates the observers so the change can be seen in the GUI
	 * representation of the phone
	 */
	@Override
	public void nextMatch() {
		if (currentKey == "") {
			return;
		} else {
			if (!composedMessage.isEmpty()) {
				composedMessage.remove(composedMessage.size() - 1);
			}
			if (words.size() != 0) {
				composedMessage.add(words.get(++currentWord % words.size()));
			}
			setChanged();
			notifyObservers(composedMessage);
		}

	}

	/**
	 * 'acceptWord' adds the current word to the composed message. And notifies
	 * observers so the updates are shown in the GUI representation.
	 */
	@Override
	public void acceptWord() {
		if (currentKey == "") {
			return;
		} else {
			composedMessage.add(currentIndex, words.get(currentWord % words.size()));
			currentIndex++;
			currentKey = "";
			composedMessage.remove(currentIndex);
			setChanged();
			notifyObservers(composedMessage);
		}
	}
}
