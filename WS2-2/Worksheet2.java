/**
 * @author SeaPaddy
 * 
 *         This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {
	// Exercise 1
	/**
	 * negate all returns a new tree containing all the negated elements from input
	 * tree t
	 * 
	 * @param t
	 *            - is a binary tree of integers
	 * @return - the duplicate of input tree 't', with all element values negated
	 */
	public static Tree<Integer> negateAll(Tree<Integer> t) {
		if (t.isEmpty()) {
			return new Tree<Integer>();
		} else {
			return new Tree<Integer>(-t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
		}
	}

	// Exercise 2
	/**
	 * checks whether all trees elements are greater than or equal to 0
	 * 
	 * @param a
	 *            - is a binary search tree of integers
	 * @return - true if all elements in tree 'a' are positive, false if not
	 */
	public static boolean allPositive(Tree<Integer> a) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getValue() >= 0) {
			return allPositive(a.getLeft()) && allPositive(a.getRight());
		} else
			return false;
	}

	// Exercise 3
	/**
	 * returns the mirror tree of a generic tree, left branches returned on right
	 * and vice-versa
	 * 
	 * @param t
	 *            - is a binary tree of generic elements
	 * @return - a tree containing all elements in 't', with their positions
	 *         mirrored
	 */
	public static <E> Tree<E> mirror(Tree<E> t) {
		if (t.isEmpty()) {
			return new Tree();
		} else {
			return new Tree(t.getValue(), mirror(t.getRight()), mirror(t.getLeft()));
		}
	}

	// Exercise 4
	/**
	 * creates a list in postorder from tree t. This method uses the helper method
	 * postorderHelper
	 * 
	 * @param t
	 *            - input binary tree of generic elements
	 * @return - generic list in postorder
	 */
	public static <E> List<E> postorder(Tree<E> t) {
		if (t.isEmpty()) {
			return new List();
		} else {
			return postorderHelper(t, new List());
		}
	}

	/**
	 * helper method searches a binary tree t, add elements to generic list l.
	 * Initially top elements, then right branches, then left are added to the list
	 * in each iteration of calling the helper function. Therefore the returned list
	 * is in postorder
	 * 
	 * @param t
	 *            - input binary tree of generic elements
	 * @param l
	 *            - input list of generic elements
	 * @return - generic list in postorder containing all elements of input tree 't'
	 */
	private static <E> List<E> postorderHelper(Tree<E> t, List<E> l) {
		if (t.isEmpty()) {
			return l;
		} else {
			return postorderHelper(t.getLeft(), postorderHelper(t.getRight(), new List(t.getValue(), l)));
		}
	}

	// Exercise 5
	/**
	 * checks whether a binary tree is a binary search tree, all elements in left
	 * branches are less than node, and all elements in right branches are greater
	 * than node. Uses helper method searchTreeHelper to pass maximum and minimum
	 * values for future nodes
	 * 
	 * @param a
	 *            - input binary tree of integer elements
	 * @return - true if binary tree 'a' is a binary search tree, false if not
	 */
	public static boolean isSearchTree(Tree<Integer> a) {
		if (a.isEmpty()) {
			return true;
		} else {
			return searchTreeHelper(a.getLeft(), a.getValue(), Integer.MIN_VALUE)
					&& searchTreeHelper(a.getRight(), Integer.MAX_VALUE, a.getValue());
		}
	}

	/**
	 * passes a maximum and minimum value for the subsequent branches of the binary
	 * tree
	 * 
	 * @param a
	 *            - input binary tree of integer elements
	 * @param max
	 *            - maximum integer value for the current root node
	 * @param min
	 *            - minimum integer value for the current root node
	 * @return - true if binary tree 'a' is a binary search tree, false if not
	 */
	private static boolean searchTreeHelper(Tree<Integer> a, int max, int min) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getValue() < max && a.getValue() > min) {
			return searchTreeHelper(a.getLeft(), a.getValue(), min)
					&& searchTreeHelper(a.getRight(), max, a.getValue());
		} else {
			return false;
		}
	}

	// Exercise 6
	/**
	 * prints all elements values in tree 'a' to the console in descending order
	 * 
	 * @param a
	 *            - input binary search tree of integer elements
	 */
	public static void printDescending(Tree<Integer> a) {
		if (!a.isEmpty()) {
			printDescending(a.getRight());
			System.out.println(a.getValue());
			printDescending(a.getLeft());
		}
	}

	// Exercise 7
	/**
	 * finds the maximum value in a binary search tree
	 * 
	 * @param a
	 *            - input a non-empty binary search tree of integer elements
	 * @return - returns the maximum integer value of the binary search tree 'a'
	 */
	public static int max(Tree<Integer> a) {
		if (a.isEmpty()) {
			throw new IllegalArgumentException("This tree is empty, there is not maximum");
		} else if (a.getRight().isEmpty()) {
			return a.getValue();
		} else {
			return max(a.getRight());
		}
	}

	// Exercise 8
	/**
	 * deletes the node equal to 'x' in the binary search tree 'a' and returns the
	 * binary search tree minus this node. If the node deleted has two children
	 * branches, the node that replaces it is the maximum of the left children
	 * branch. Otherwise return the remaining branch
	 * 
	 * @param a
	 *            - input binary search tree of integer elements
	 * @param x
	 *            - integer value to be deleted from binary search tree 'a'
	 * @return - binary search tree, containing all elements from binary search tree
	 *         'a', minus the element equal to 'x'
	 */
	public static Tree<Integer> delete(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return new Tree<Integer>();
		} else if (x > a.getValue()) {
			return new Tree<Integer>(a.getValue(), a.getLeft(), delete(a.getRight(), x));
		} else if (x < a.getValue()) {
			return new Tree<Integer>(a.getValue(), delete(a.getLeft(), x), a.getRight());
		} else {
			if (a.getLeft().isEmpty()) {
				return a.getRight();
			} else if (a.getRight().isEmpty()) {
				return a.getLeft();
			} else {
				int maxLeft = max(a.getLeft());
				return new Tree<Integer>(maxLeft, delete(a.getLeft(), maxLeft), a.getRight());
			}
		}
	}

	// Exercise 9
	/**
	 * checks whether a binary tree 'a' is balanced
	 * 
	 * @param a
	 *            - binary tree of generic elements with no duplicates
	 * @return - true if the binary tree 'a' is balanced, false if not
	 */
	public static <E> boolean isHeightBalanced(Tree<E> a) {
		if (a.isEmpty()) {
			return true;
		} else {
			int leftHeight = a.getLeft().getHeight();
			int rightHeight = a.getRight().getHeight();
			int difference = leftHeight - rightHeight;
			if (Math.abs(difference) <= 1) {
				return isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
			} else {
				return false;
			}
		}
	}

	// Exercise 10
	/**
	 * insert 'x' into the tree 'a' in order, and returns the resulting height
	 * balanced binary search tree. Uses helper function heightCorrection which
	 * checks height balance and returns height balanced trees.
	 * 
	 * @param x
	 *            - integer element to be inserted from binary search tree 'a'
	 * @param a
	 *            - height balanced binary search tree of integers with no
	 *            duplicates
	 * @return - resulting height balanced binary search tree from inserting 'x'
	 *         into the tree 'a'
	 */
	public static Tree<Integer> insertHB(int x, Tree<Integer> a) {
		if (a.isEmpty()) {
			return new Tree<Integer>(x);
		} else if (x < a.getValue()) {
			return heightCorrection(new Tree<Integer>(a.getValue(), insertHB(x, a.getLeft()), a.getRight()));
		} else if (x > a.getValue()) {
			return heightCorrection(new Tree<Integer>(a.getValue(), a.getLeft(), insertHB(x, a.getRight())));
		} else {
			return a;
		}
	}

	/**
	 * removes the element 'x' from the binary search tree 'a', and returns a height
	 * balanced binary search tree with all remaining elements in 'a'. Uses helper
	 * function heightCorrection which checks height balance and returns height
	 * balanced trees.
	 * 
	 * @param a
	 *            - height balanced binary search tree of integers with no
	 *            duplicates
	 * @param x
	 *            - integer element to be deleted from binary search tree 'a'
	 * @return - a height balanced binary search tree of integers with no
	 *         duplicates, containing all elements of 'a' except for the element
	 *         equal to 'x'
	 */
	public static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
		if (a.isEmpty()) {
			return new Tree<Integer>();
		} else if (x > a.getValue()) {
			return heightCorrection(new Tree<Integer>(a.getValue(), a.getLeft(), deleteHB(a.getRight(), x)));
		} else if (x < a.getValue()) {
			return heightCorrection(new Tree<Integer>(a.getValue(), deleteHB(a.getLeft(), x), a.getRight()));
		} else {
			if (a.getLeft().isEmpty()) {
				return a.getRight();
			} else if (a.getRight().isEmpty()) {
				return a.getLeft();
			} else {
				int maxLeft = max(a.getLeft());
				return heightCorrection(new Tree<Integer>(maxLeft, deleteHB(a.getLeft(), maxLeft), a.getRight()));
			}
		}
	}

	/**
	 * checks whether a tree is height balance, if not returns a height balanced
	 * tree. Uses helper methods, leftLeftRotation, rightRightRotation,
	 * rightLeftRotation, and leftRightRotation
	 * 
	 * @param a
	 *            - binary search tree of integers with no duplicates
	 * @return - a height balance binary search tree with all the elements of input
	 *         binary search tree 'a'
	 */
	private static Tree<Integer> heightCorrection(Tree<Integer> a) {
		int leftHeight = a.getLeft().getHeight();
		int rightHeight = a.getRight().getHeight();
		int balance = rightHeight - leftHeight;

		if (balance < -1) {
			// checks which sub-branch of the left tree is larger to determine which
			// rotation should be performed
			if (a.getLeft().getLeft().getHeight() < a.getLeft().getRight().getHeight()) {
				return leftRightRotation(a);
			} else {
				return leftLeftRotation(a);
			}
		} else if (balance > 1) {
			// checks which sub-branch of the right tree is larger to determine which
			// rotation should be performed
			if (a.getRight().getLeft().getHeight() > a.getRight().getRight().getHeight()) {
				return rightLeftRotation(a);
			} else {
				return rightRightRotation(a);
			}
		} else {
			// tree is balanced return input tree
			return a;
		}
	}

	/**
	 * performs a single rotation right, this occurs when the tree is left -> left
	 * heavy
	 * 
	 * @param t
	 *            - unbalanced binary search tree of integers with no duplicates.
	 *            Binary search tree 't' has to be left -> left heavy.
	 * @return - a height balance binary search tree with all the elements of input
	 *         binary search tree 't'
	 */
	private static Tree<Integer> leftLeftRotation(Tree<Integer> t) {
		int root = t.getLeft().getValue();
		Tree<Integer> left = t.getLeft().getLeft();
		Tree<Integer> right = new Tree<Integer>(t.getValue(), t.getLeft().getRight(), t.getRight());

		return new Tree<Integer>(root, left, right);
	}

	/**
	 * performs a single rotation left, this occurs when the tree is right -> right
	 * heavy
	 * 
	 * @param t
	 *            - unbalanced binary search tree of integers with no duplicates.
	 *            Binary search tree 't' has to be right -> right heavy.
	 * @return - a height balance binary search tree with all the elements of input
	 *         binary search tree 't'
	 */
	private static Tree<Integer> rightRightRotation(Tree<Integer> t) {
		int root = t.getRight().getValue();
		Tree<Integer> left = new Tree<Integer>(t.getValue(), t.getLeft(), t.getRight().getLeft());
		Tree<Integer> right = t.getRight().getRight();

		return new Tree<Integer>(root, left, right);
	}

	/**
	 * performs a double rotation right, this occurs when the tree is left -> right
	 * heavy
	 * 
	 * @param t
	 *            - unbalanced binary search tree of integers with no duplicates.
	 *            Binary search tree 't' has to be left -> right heavy.
	 * @return - a height balance binary search tree with all the elements of input
	 *         binary search tree 't'
	 */
	private static Tree<Integer> leftRightRotation(Tree<Integer> t) {
		int root = t.getLeft().getRight().getValue();
		Tree<Integer> left = new Tree<Integer>(t.getLeft().getValue(), t.getLeft().getLeft(),
				t.getLeft().getRight().getLeft());
		Tree<Integer> right = new Tree<Integer>(t.getValue(), t.getLeft().getRight().getRight(), t.getRight());

		return new Tree<Integer>(root, left, right);
	}

	/**
	 * performs a double rotation left, this occurs when the tree is right -> left
	 * heavy
	 * 
	 * @param t
	 *            - unbalanced binary search tree of integers with no duplicates.
	 *            Binary search tree 't' has to be right -> left heavy.
	 * @return - a height balance binary search tree with all the elements of input
	 *         binary search tree 't'
	 */
	private static Tree<Integer> rightLeftRotation(Tree<Integer> t) {
		int root = t.getRight().getLeft().getValue();
		Tree<Integer> left = new Tree<Integer>(t.getValue(), t.getLeft(), t.getRight().getLeft().getLeft());
		Tree<Integer> right = new Tree<Integer>(t.getRight().getValue(), t.getRight().getLeft().getRight(),
				t.getRight().getRight());

		return new Tree<Integer>(root, left, right);
	}

}
