import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author SeaPaddy
 * 
 *
 */

public class Worksheet2Test {
	private Tree<Integer> emptyTree;
	private List<Integer> emptyList;

	@Before
	public void setUp() {
		emptyTree = new Tree<Integer>();
		emptyList = new List<Integer>();
	}

	/**
	 * Test negate tree for empty tree
	 */
	@Test
	public void testEx1_1() {
		Tree<Integer> expectedTree = new Tree<Integer>();

		boolean expected = true;
		boolean actual = expectedTree.equals(Worksheet2.negateAll(emptyTree));

		assertEquals(expected, actual);
	}

	/**
	 * Test negate on a small tree, negatives -> positive and vice-versa
	 */
	@Test
	public void testEx1_2() {
		Tree<Integer> initialTree = new Tree(0, new Tree(-5), new Tree(10, new Tree(), new Tree(12)));

		Tree<Integer> expectedTree = new Tree(0, new Tree(5), new Tree(-10, new Tree(), new Tree(-12)));

		Tree<Integer> negatedTree = Worksheet2.negateAll(initialTree);

		assertEquals(expectedTree, negatedTree);
	}

	/**
	 * Test negate on a singleton tree, negatives -> positive and vice-versa
	 */
	@Test
	public void testEx1_3() {
		Tree<Integer> singletonNegative = new Tree(-2);
		Tree<Integer> singletonPositve = new Tree(2);
		Tree<Integer> expectedNagatedNegative = new Tree(2);
		Tree<Integer> expectedNegatedPositive = new Tree(-2);

		Tree<Integer> negatedNegative = Worksheet2.negateAll(singletonNegative);
		Tree<Integer> negatedPositive = Worksheet2.negateAll(singletonPositve);

		assertEquals(expectedNagatedNegative, negatedNegative);
		assertEquals(expectedNegatedPositive, negatedPositive);
	}

	/**
	 * Tests whether positive on an empty tree
	 */
	@Test
	public void testEx2_1() {

		boolean expected = true;
		boolean actual = Worksheet2.allPositive(emptyTree);

		assertEquals(expected, actual);
	}

	/**
	 * Tests whether positive on an all positive tree
	 */
	@Test
	public void testEx2_2() {
		Tree<Integer> postiveTree = new Tree(10, new Tree(0), new Tree(20, new Tree(15), new Tree(30)));

		boolean expected = true;
		boolean actual = Worksheet2.allPositive(postiveTree);

		assertEquals(expected, actual);
	}

	/**
	 * Tests whether positive on a tree with negative elements, negative located
	 * right then left branch to check traversing entire tree
	 */
	@Test
	public void testEx2_3() {
		Tree<Integer> tree = new Tree(10, new Tree(0), new Tree(20, new Tree(-15), new Tree(30)));

		boolean expected = false;
		boolean actual = Worksheet2.allPositive(tree);

		assertEquals(expected, actual);
	}

	/**
	 * Test mirror for empty tree
	 */
	@Test
	public void testEx3_1() {
		Tree<Integer> expectedTree = new Tree<Integer>();

		Tree<Integer> mirrorTree = Worksheet2.mirror(emptyTree);

		assertEquals(expectedTree, mirrorTree);
	}

	/**
	 * Test mirror for a small tree of string elements
	 */
	@Test
	public void testEx3_2() {
		Tree<String> initialTree = new Tree("D", new Tree("C", new Tree("A"), new Tree("B")),
				new Tree("E", new Tree("F"), new Tree()));

		Tree<String> expectedTree = new Tree("D", new Tree("E", new Tree(), new Tree("F")),
				new Tree("C", new Tree("B"), new Tree("A")));

		Tree<String> actualTree = Worksheet2.mirror(initialTree);

		assertEquals(expectedTree, actualTree);
	}

	/**
	 * Test postorder for empty tree
	 */
	@Test
	public void testEx4_1() {
		boolean expected = true;
		boolean actual = emptyList.equals(Worksheet2.postorder(emptyTree));

		assertEquals(expected, actual);
	}

	/**
	 * Test postorder for an alphabetical tree
	 */
	@Test
	public void testEx4_2() {
		Tree<String> initialTree = new Tree("F", new Tree("C", new Tree("A"), new Tree("B")),
				new Tree("E", new Tree("D"), new Tree()));

		List<String> expectedList = new List("A",
				new List("B", new List("C", new List("D", new List("E", new List("F", new List()))))));

		List<String> actualList = Worksheet2.postorder(initialTree);

		assertEquals(expectedList, actualList);
	}

	/**
	 * Test whether an empty tree is a binary search tree
	 */
	@Test
	public void testEx5_1() {
		boolean expected = true;
		boolean actual = Worksheet2.isSearchTree(emptyTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test binary search for, node->left->right, where right < node always!
	 */
	@Test
	public void testEx5_2() {
		Tree<Integer> binaryTree = new Tree(10, new Tree(4, new Tree(), new Tree(10)), new Tree());

		boolean expected = false;
		boolean actual = Worksheet2.isSearchTree(binaryTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test binary search that left < node
	 */
	@Test
	public void testEx5_3() {
		Tree<Integer> binaryTree = new Tree(10, new Tree(10), new Tree());

		boolean expected = false;
		boolean actual = Worksheet2.isSearchTree(binaryTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test binary search that right > node
	 */
	@Test
	public void testEx5_4() {
		Tree<Integer> binaryTree = new Tree(10, new Tree(), new Tree(10));

		boolean expected = false;
		boolean actual = Worksheet2.isSearchTree(binaryTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test binary search returns true for binary search tree
	 */
	@Test
	public void testEx5_5() {
		Tree<Integer> binarySearchTree = new Tree(10, new Tree(6, new Tree(3), new Tree(8)),
				new Tree(14, new Tree(), new Tree(18)));

		boolean expected = true;
		boolean actual = Worksheet2.isSearchTree(binarySearchTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test print descending for empty tree
	 */
	@Test
	public void testEx6_1() {
		Worksheet2.printDescending(emptyTree);
	}

	/**
	 * Test print descending for singleton tree
	 */
	@Test
	public void testEx6_2() {
		Tree<Integer> singleton = new Tree(8);

		Worksheet2.printDescending(singleton);
		System.out.println();
	}

	/**
	 * Test print descending for binary search tree
	 */
	@Test
	public void testEx6_3() {
		Tree<Integer> binaryTree = new Tree(8, new Tree(6, new Tree(), new Tree(7)),
				new Tree(10, new Tree(9), new Tree(11)));

		Worksheet2.printDescending(binaryTree);
		System.out.println();
	}

	/**
	 * Test max for singleton tree
	 */
	@Test
	public void testEx7_1() {
		Tree<Integer> singletonTree = new Tree(10);

		int expected = 10;
		int actual = Worksheet2.max(singletonTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test max for binary search tree
	 */
	@Test
	public void testEx7_2() {
		Tree<Integer> binaryTree = new Tree(10, new Tree(7), new Tree(18, new Tree(), new Tree(24)));

		int expected = 24;
		int actual = Worksheet2.max(binaryTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test delete for an empty tree
	 */
	@Test
	public void testEx8_1() {
		Tree<Integer> expectedTree = new Tree();

		Tree<Integer> actualTree = Worksheet2.delete(emptyTree, 2);

		assertEquals(expectedTree, actualTree);
	}

	/**
	 * Test delete for a singleton tree
	 */
	@Test
	public void testEx8_2() {
		Tree<Integer> initialTree = new Tree(10);

		Tree<Integer> expectedTree = new Tree();

		Tree<Integer> actualTree = Worksheet2.delete(initialTree, 10);

		assertEquals(expectedTree, actualTree);
	}

	/**
	 * Test delete for a tree replacing node with left max tree
	 */
	@Test
	public void testEx8_3() {
		Tree<Integer> initialTree = new Tree(10, new Tree(),
				new Tree(15, new Tree(12, new Tree(11), new Tree(14)), new Tree(20)));

		Tree<Integer> expectedTree = new Tree(10, new Tree(),
				new Tree(14, new Tree(12, new Tree(11), new Tree()), new Tree(20)));

		Tree<Integer> actualTree = Worksheet2.delete(initialTree, 15);

		assertEquals(expectedTree, actualTree);
	}

	/**
	 * Test delete for a tree with no extending left node
	 */
	@Test
	public void testEx8_4() {
		Tree<Integer> initialTree = new Tree(10, new Tree(),
				new Tree(15, new Tree(), new Tree(20, new Tree(16), new Tree(22))));

		Tree<Integer> expectedTree = new Tree(10, new Tree(), new Tree(20, new Tree(16), new Tree(22)));

		Tree<Integer> actualTree = Worksheet2.delete(initialTree, 15);

		assertEquals(expectedTree, actualTree);
	}

	/**
	 * Test balanced for empty tree
	 */
	@Test
	public void testEx9_1() {
		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(emptyTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test balanced for right -> right tree
	 */
	@Test
	public void testEx9_2() {
		Tree<Integer> rightRightTree = new Tree(10, new Tree(), new Tree(15, new Tree(), new Tree(22)));

		boolean expected = false;
		boolean actual = Worksheet2.isHeightBalanced(rightRightTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test balanced for left -> left tree
	 */
	@Test
	public void testEx9_3() {
		Tree<Integer> leftLeftTree = new Tree(10, new Tree(7, new Tree(5), new Tree()), new Tree());

		boolean expected = false;
		boolean actual = Worksheet2.isHeightBalanced(leftLeftTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test balanced for left -> right tree
	 */
	@Test
	public void testEx9_4() {
		Tree<Integer> leftRightTree = new Tree(10, new Tree(7, new Tree(), new Tree(9)), new Tree());

		boolean expected = false;
		boolean actual = Worksheet2.isHeightBalanced(leftRightTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test balanced for right -> left tree
	 */
	@Test
	public void testEx9_5() {
		Tree<Integer> rightLeftTree = new Tree(10, new Tree(), new Tree(15, new Tree(13), new Tree()));

		boolean expected = false;
		boolean actual = Worksheet2.isHeightBalanced(rightLeftTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test balanced for 1 height difference
	 */
	@Test
	public void testEx9_6() {
		Tree<Integer> balancedTree = new Tree(10, new Tree(), new Tree(15));

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(balancedTree);

		assertEquals(expected, actual);
	}

	/**
	 * Test insert height into empty tree
	 */
	@Test
	public void testEx10a_1() {
		Tree<Integer> modifiedTree = Worksheet2.insertHB(3, emptyTree);

		Tree<Integer> expectedTree = new Tree(3);

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test insert height balanced right -> right imbalance
	 */
	@Test
	public void testEx10a_2() {
		Tree<Integer> initialTree = new Tree(10, new Tree(6), new Tree(14, new Tree(), new Tree(16)));
		Tree<Integer> modifiedTree = Worksheet2.insertHB(18, initialTree);

		Tree<Integer> expectedTree = new Tree(10, new Tree(6),
				new Tree(16, new Tree(14), new Tree(18)));

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test insert height balanced right -> left imbalance
	 */
	@Test
	public void testEx10a_3() {
		Tree<Integer> initialTree = new Tree(10, new Tree(6), new Tree(16, new Tree(14), new Tree()));
		Tree<Integer> modifiedTree = Worksheet2.insertHB(12, initialTree);

		Tree<Integer> expectedTree = new Tree(10, new Tree(6), new Tree(14, new Tree(12), new Tree(16)));

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test insert height balanced left -> left imbalance
	 */
	@Test
	public void testEx10a_4() {
		Tree<Integer> initialTree = new Tree(10,
				new Tree(6, new Tree(5, new Tree(3), new Tree()), new Tree(8)),
				new Tree(14, new Tree(12), new Tree(17)));
		Tree<Integer> modifiedTree = Worksheet2.insertHB(1, initialTree);

		Tree<Integer> expectedTree = new Tree(10,
				new Tree(6, new Tree(3, new Tree(1), new Tree(5)), new Tree(8)),
				new Tree(14, new Tree(12), new Tree(17)));

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test insert height balanced left -> right imbalance
	 */
	@Test
	public void testEx10a_5() {
		Tree<Integer> initialTree = new Tree(10, new Tree(7), new Tree());
		Tree<Integer> modifiedTree = Worksheet2.insertHB(9, initialTree);

		Tree<Integer> expectedTree = new Tree(9, new Tree(7), new Tree(10));

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test insert height balanced left -> right imbalance on second level height
	 */
	@Test
	public void testEx10a_6() {
		Tree<Integer> initialTree = new Tree(8, new Tree(3, new Tree(1), new Tree(7)), new Tree(9));
		Tree<Integer> modifiedTree = Worksheet2.insertHB(4, initialTree);

		Tree<Integer> expectedTree = new Tree(7, new Tree(3, new Tree(1), new Tree(4)),
				new Tree(8, new Tree(), new Tree(9)));

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test empty tree removal of node
	 */
	@Test
	public void testEx10b_1() {
		Tree<Integer> modifiedTree = Worksheet2.deleteHB(emptyTree, 5);

		Tree<Integer> expectedTree = new Tree();

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test delete for singleton tree
	 */
	@Test
	public void testEx10b_2() {
		Tree<Integer> initialTree = new Tree(5);
		Tree<Integer> modifiedTree = Worksheet2.deleteHB(initialTree, 5);

		Tree<Integer> expectedTree = new Tree();

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test delete height balance is right right heavy
	 */
	@Test
	public void testEx10b_3() {
		Tree<Integer> initialTree = new Tree(5, new Tree(2), new Tree(10, new Tree(8), new Tree(14)));
		Tree<Integer> modifiedTree = Worksheet2.deleteHB(initialTree, 2);

		Tree<Integer> expectedTree = new Tree(10, new Tree(5, new Tree(), new Tree(8)), new Tree(14));

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test delete height balance is right left heavy
	 */
	@Test
	public void testEx10b_4() {
		Tree<Integer> initialTree = new Tree(5, new Tree(2, new Tree(), new Tree(4)),
				new Tree(10, new Tree(8, new Tree(7), new Tree()), new Tree(14)));
		Tree<Integer> modifiedTree = Worksheet2.deleteHB(initialTree, 5);

		Tree<Integer> expectedTree = new Tree(8, new Tree(4, new Tree(2), new Tree(7)),
				new Tree(10, new Tree(), new Tree(14)));

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test delete height balance is left left heavy
	 */
	@Test
	public void testEx10b_5() {
		Tree<Integer> initialTree = new Tree(10, new Tree(5, new Tree(2), new Tree(8)), new Tree(14));
		Tree<Integer> modifiedTree = Worksheet2.deleteHB(initialTree, 14);

		Tree<Integer> expectedTree = new Tree(5, new Tree(2), new Tree(10, new Tree(8), new Tree()));

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

	/**
	 * Test delete height balance is left right heavy
	 */
	@Test
	public void testEx10b_6() {
		Tree<Integer> initialTree = new Tree(10, new Tree(5, new Tree(2), new Tree(8, new Tree(7), new Tree())),
				new Tree(14, new Tree(), new Tree(16)));
		Tree<Integer> modifiedTree = Worksheet2.deleteHB(initialTree, 14);

		Tree<Integer> expectedTree = new Tree(8, new Tree(5, new Tree(2), new Tree(7)),
				new Tree(10, new Tree(), new Tree(16)));

		boolean expected = true;
		boolean actual = Worksheet2.isHeightBalanced(modifiedTree);

		assertEquals(expectedTree, modifiedTree);
		assertEquals(expected, actual);
	}

}
