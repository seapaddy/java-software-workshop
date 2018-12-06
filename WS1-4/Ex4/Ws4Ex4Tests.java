import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for ExamQuestion, ExamQuestionNumeric, ExamQuestionSimpleChoice and
 * ExamQuestionMultipleChoice;
 * 
 * @author Seapaddy
 * @version 2017-11-13
 *
 */
public class Ws4Ex4Tests {

	private ExamQuestion question1, question2;
	private ExamQuestionNumeric numericQuestion1, numericQuestion2, numericQuestion3;
	private ExamQuestionSimpleChoice simpleChoiceQuestion1, simpleChoiceQuestion2, simpleChoiceQuestion3;
	private ExamQuestionMultipleChoice multipleChoiceQuestion1, multipleChoiceQuestion2;

	@Before
	public void setup() {
		question1 = new ExamQuestion("What is 3 minus 4?", 10);
		question2 = new ExamQuestion("What is -1 plus 1?", 5);

		numericQuestion1 = new ExamQuestionNumeric("What is -3 times 2?", 10, -6);
		numericQuestion2 = new ExamQuestionNumeric("What is 2 divided by 2?", 5, 1);
		numericQuestion3 = new ExamQuestionNumeric("What is square root of 36?", 1, 6);

		ArrayList<String> simpleChoiceAnswers1 = new ArrayList<String>(Arrays.asList("1", "3", "6", "9"));
		simpleChoiceQuestion1 = new ExamQuestionSimpleChoice("What is 2 plus 1?", 10, simpleChoiceAnswers1, 2);

		ArrayList<String> simpleChoiceAnswers2 = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "-1"));
		simpleChoiceQuestion2 = new ExamQuestionSimpleChoice("What is 8 divided by 2?", 1, simpleChoiceAnswers2, 4);

		ArrayList<String> simpleChoiceAnswers3 = new ArrayList<String>(
				Arrays.asList("Turtle", "Bear", "Snake", "Flamingo"));
		simpleChoiceQuestion3 = new ExamQuestionSimpleChoice("Which animal is a mammal", 20, simpleChoiceAnswers3, 2);

		ArrayList<String> possibleAnswers1 = new ArrayList<>(Arrays.asList("-3", "0", "3", "6"));
		ArrayList<Integer> correctAnswers1 = new ArrayList<>(Arrays.asList(1, 3));
		multipleChoiceQuestion1 = new ExamQuestionMultipleChoice("Square root of x * x = 3", 10, possibleAnswers1,
				correctAnswers1);

		ArrayList<String> possibleAnswers2 = new ArrayList<>(Arrays.asList("-2", "-1", "0", "1", "2"));
		ArrayList<Integer> correctAnswers2 = new ArrayList<>(Arrays.asList(2, 3, 4));
		multipleChoiceQuestion2 = new ExamQuestionMultipleChoice("x * x minus abs(x) = 0", 20, possibleAnswers2,
				correctAnswers2);
	}

	/**
	 * test getQuestionText, getMaximalMark, setMaximalMark and toString of
	 * ExamQuestion Class
	 */
	@Test
	public void test1() {
		int actual1 = question1.getMaximalMark();
		int actual2 = question2.getMaximalMark();
		int expected1 = 10;
		int expected2 = 5;

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);

		question1.setMaximalMark(20);
		question2.setMaximalMark(1);

		actual1 = question1.getMaximalMark();
		actual2 = question2.getMaximalMark();
		expected1 = 20;
		expected2 = 1;

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);

		String actual3 = question1.getQuestionText();
		String expected3 = "What is 3 minus 4?";

		String actual4 = question2.getQuestionText();
		String expected4 = "What is -1 plus 1?";

		assertEquals(expected3, actual3);
		assertEquals(expected4, actual4);

		String expected5 = "Question (Maximal mark: 20): What is 3 minus 4?";
		String actual5 = question1.toString();

		assertEquals(expected5, actual5);

	}

	/**
	 * test mark and toString of ExamQuestionNumeric
	 */
	@Test
	public void test2() {
		int expected1 = 10;
		int actual1 = numericQuestion1.mark(-6);

		int expected2 = 0;
		int actual2 = numericQuestion1.mark(6);

		int expected3 = 5;
		int actual3 = numericQuestion2.mark(1);

		int expected4 = 0;
		int actual4 = numericQuestion2.mark(80);

		int expected5 = 1;
		int actual5 = numericQuestion3.mark(6);

		int expected6 = 0;
		int actual6 = numericQuestion3.mark(0);

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(expected3, actual3);
		assertEquals(expected4, actual4);
		assertEquals(expected5, actual5);
		assertEquals(expected6, actual6);

		String expected7 = "Question (Maximal mark: 5): What is 2 divided by 2? Correct Answer is: 1";
		String actual7 = numericQuestion2.toString();

		assertEquals(expected7, actual7);
	}

	/**
	 * test mark and toString of ExamQuestionSimple
	 */
	@Test
	public void test3() {
		int expected1 = 10;
		int actual1 = simpleChoiceQuestion1.mark(2);

		int expected2 = 0;
		int actual2 = simpleChoiceQuestion1.mark(18);

		int expected3 = 1;
		int actual3 = simpleChoiceQuestion2.mark(4);

		int expected4 = 0;
		int actual4 = simpleChoiceQuestion2.mark(-2);

		int expected5 = 20;
		int actual5 = simpleChoiceQuestion3.mark(2);

		int expected6 = 0;
		int actual6 = simpleChoiceQuestion3.mark(6);

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(expected3, actual3);
		assertEquals(expected4, actual4);
		assertEquals(expected5, actual5);
		assertEquals(expected6, actual6);

		String expected7 = "Question (Maximal mark: 1): What is 8 divided by 2?\n"
				+ "Possible answers are: [1, 2, 3, 4, 5, -1]\n" + "Correct answer position is: 4";
		String actual7 = simpleChoiceQuestion2.toString();

		assertEquals(expected7, actual7);
	}

	/**
	 * test mark and toString of ExamQuestionMulitple
	 */
	@Test
	public void test4() {
		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1, 3));

		int expected1 = 10;
		int actual1 = multipleChoiceQuestion1.mark(givenAnswers);

		assertEquals(expected1, actual1);

		String expected2 = "Question (Maximal mark: 10): Square root of x * x = 3\n"
				+ "Possible answers are: [-3, 0, 3, 6]\n" + "Correct answers are: [1, 3]";
		String actual2 = multipleChoiceQuestion1.toString();

		assertEquals(expected2, actual2);
	}
	
	/**
	 * test half marks of ExamQuestionMulitple
	 */
	@Test
	public void test5() {
		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1));

		int expected1 = 5;
		int actual1 = multipleChoiceQuestion1.mark(givenAnswers);

		assertEquals(expected1, actual1);
	}
	
	/**
	 * test mark of ExamQuestionMulitple
	 */
	@Test
	public void test6() {
		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(2, 3, 4));

		int expected1 = 20;
		int actual1 = multipleChoiceQuestion2.mark(givenAnswers);

		assertEquals(expected1, actual1);
	}
	
	/**
	 * test mark of ExamQuestionMulitple
	 */
	@Test
	public void test7() {
		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(3, 3, 4));

		int expected1 = 13;
		int actual1 = multipleChoiceQuestion2.mark(givenAnswers);

		assertEquals(expected1, actual1);
	}
	
	/**
	 * test mark of ExamQuestionMulitple
	 */
	@Test
	public void test8() {
		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(3));

		int expected1 = 7;
		int actual1 = multipleChoiceQuestion2.mark(givenAnswers);

		assertEquals(expected1, actual1);
	}
	
	/**
	 * test mark of ExamQuestionMulitple
	 */
	@Test
	public void test9() {
		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList());

		int expected1 = 0;
		int actual1 = multipleChoiceQuestion2.mark(givenAnswers);

		assertEquals(expected1, actual1);
	}

}
