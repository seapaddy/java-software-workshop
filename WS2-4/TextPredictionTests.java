import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class TextPredictionTests {

	/**
	 * check a standard test case for using the 'words' dictionary
	 */
	@Test
	public void test1() {
		DictionaryModel model;
		try {
			ArrayList<String> expected = new ArrayList<String>();
			expected.add("hello");

			model = new DictionaryModel("testwords");
			model.addCharacter('4');
			model.addCharacter('3');
			model.addCharacter('5');
			model.addCharacter('5');
			model.addCharacter('6');
			model.acceptWord();
			assertEquals(expected, model.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * check if do more than the size of the array next match, doesn't return an
	 * error and still returns one of the options
	 */
	@Test
	public void test2() {
		DictionaryModel model;
		try {
			ArrayList<String> expected = new ArrayList<String>();
			expected.add("a");

			model = new DictionaryModel("testwords");
			model.addCharacter('2');
			model.nextMatch();
			model.nextMatch();
			model.nextMatch();
			model.acceptWord();

			assertEquals(expected, model.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * check can return final word in the set of words
	 */
	@Test
	public void test3() {
		DictionaryModel model;
		try {
			ArrayList<String> expected = new ArrayList<String>();
			expected.add("z");

			model = new DictionaryModel("testwords");
			model.addCharacter('9');
			model.nextMatch();
			model.nextMatch();
			model.nextMatch();
			model.acceptWord();

			assertEquals(expected, model.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * check remove last character works
	 */
	@Test
	public void test4() {
		DictionaryModel model;
		try {
			ArrayList<String> expected = new ArrayList<String>();
			expected.add("be");

			model = new DictionaryModel("testwords");
			model.addCharacter('2');
			model.addCharacter('3');

			assertEquals(expected, model.getMessage());

			model.removeLastCharacter();
			expected = new ArrayList<>();
			expected.add("a");

			assertEquals(expected, model.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * check pressing 0 when an empty word, doesn't throw any errors
	 */
	@Test
	public void test5() {
		DictionaryModel model;
		try {
			model = new DictionaryModel("testwords");
			model.acceptWord();
			model.acceptWord();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * check no exceptions when changing to character in empty string
	 */
	@Test
	public void test6() {
		DictionaryModel model;
		try {
			model = new DictionaryModel("testwords");
			model.addCharacter('2');
			model.removeLastCharacter();
			model.nextMatch();
			model.nextMatch();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
