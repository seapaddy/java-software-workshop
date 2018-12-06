import java.util.ArrayList;

/**
 * The class ExamQuestionSimpleChoice extends the class ExamQuestion. It
 * inherits all the methods from the superclass. It has additional fields
 * possibleAnswers (an ArrayList of possible answers to the question) and
 * correct answer (the ArrayList integer position of the correct answer to the
 * exam question)
 * 
 * The class consists of a constructor, a toString method, and the mark method.
 * 
 * The mark method, compares the ArrayList position of the answer (value), with
 * the position of the correct value within the ArrayList of possible answers.
 * If they are equal mark returns the maximum mark for the question, using
 * inheritance the super class ExamQuestion.
 * 
 * @author Seapaddy
 * @version 2017-11-03
 */
public class ExamQuestionSimpleChoice extends ExamQuestion {
	public ArrayList<String> possibleAnswers;
	private int correctAnswer;

	/**
	 * Constructor for the ExamQuestionSimpleChoice Class
	 * 
	 * @param questionText
	 *            The String of the question to be answered
	 * @param maximumMark
	 *            The integer maximum mark of the question
	 * @param possibleAnswers
	 *            The ArrayList of the answer choices for the question
	 * @param correctAnswer
	 *            The correct position of the answer in the ArrayList (The array
	 *            starts from 1)
	 */
	public ExamQuestionSimpleChoice(String questionText, int maximumMark, ArrayList<String> possibleAnswers,
			int correctAnswer) {
		super(questionText, maximumMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswer = correctAnswer;
	}

	/**
	 * mark method returns maximum marks if the integer value for the array position
	 * is equal to the correct answer position within the array, if not mark returns
	 * 0.
	 * 
	 * @param value
	 *            The answer provided states the correct answers array location
	 * @return the integer mark of the question, maximum marks if correct, 0 if
	 *         incorrect
	 */
	public int mark(int value) {
		if (value == correctAnswer) {
			return getMaximalMark();
		} else {
			return 0;
		}
	}

	/**
	 * toString method, uses inheritance from the super class concatenated with
	 * answer choices and the array position of the correct answer.
	 * @return a string representation of the a simple choice question
	 */
	@Override
	public String toString() {
		return super.toString() + "\nPossible answers are: " + possibleAnswers + "\nCorrect answer position is: "
				+ correctAnswer;
	}
}
