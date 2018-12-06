

import java.util.Set;
import java.util.TreeSet;

/**
 * Tree class defines a recursive type called Tree for structures with 8
 * children and provides constructor, getter methods and an insert method. Each
 * node is a Set of genetic values.
 * 
 * @author SeaPaddy
 * @version 2018-02-09
 *
 * @param <E>
 *            - Genetic input parameter.
 */
public class Tree<E> {
	protected final Set<E> value;
	protected final Tree<E>[] children = new Tree[8];

	/**
	 * constructor for Tree, creates a new Tree with an empty tree set as the root,
	 * and children nodes all initially set to null
	 */
	public Tree() {
		this.value = new TreeSet<E>();
		for (int i = 0; i < children.length; i++) {
			this.children[i] = null;
		}

	}

	/**
	 * 
	 * @return - the set of words at the current position in the tree
	 */
	public Set<E> getValue() {
		return value;
	}

	/**
	 * 
	 * @param position
	 *            - integer position 0 - 7 as the children array has length 8
	 * @return - the child tree of the current node at the array index position
	 */
	public Tree<E> getChild(int position) {
		if (this.children[position] == null) {
			throw new IllegalStateException("Trying to access subtree of an empty tree");
		}
		return this.children[position];
	}

	/**
	 * insert adds word into the tree structure of the dictionary. All possible
	 * words matching the current input signature are added to each matching node
	 * within the tree.
	 * 
	 * @param word
	 *            - the word to be added to the tree at each matching signature
	 *            location
	 * @param signature
	 *            - the matching signature of the word, used to locate the positions
	 *            within the tree where the word should be added.
	 */
	public void insert(E word, String signature) {
		if (signature.length() == 0) {
			return;
		}
		int position = signature.charAt(0) - '0' - 2;
		if (this.children[position] == null) {
			Tree<E> temp = new Tree<E>();
			this.children[position] = temp;
			this.children[position].value.add(word);
			this.children[position].insert(word, signature.substring(1, signature.length()));
		} else {
			this.children[position].value.add(word);
			this.children[position].insert(word, signature.substring(1, signature.length()));
		}
	}

	/**
	 * 
	 * @param signature
	 *            - String of digits between 2 and 9 inclusive
	 * @return - the tree set of possible words matching the input signature
	 */
	public Set<E> getWords(String signature) {
		if (signature.length() == 0) {
			return this.value;
		}
		int position = signature.charAt(0) - '0' - 2;
		if (position < 0 || position > 7 || this.children[position] == null) {
			return new TreeSet<E>();
		} else {
			return this.children[position].getWords(signature.substring(1, signature.length()));
		}
	}
}
