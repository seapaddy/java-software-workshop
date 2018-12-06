/**
 * The class ExamQuestionNumeric extends the class ExamQuestion. It inherits all
 * the methods from the superclass. It has an additional field correct answer
 * (the correct numerical integer answer of the exam question).
 * 
 * The class consists of a constructor, a toString method, and the mark method.
 * 
 * The mark method, compares the integer value with the correct answer. If they
 * are equal mark returns the maximum mark for the question, from the super
 * class ExamQuestion.
 * 
 * @author Seapaddy
 * @version 2017-11-03
 */
public class ExamQuestionNumeric extends ExamQuestion {
	private int correctAnswer;

	/**
	 * Constructor for the ExamQuestionNumeric Class
	 * 
	 * @param questionText
	 *            The String of the question to be answered
	 * @param maximumMark
	 *            The integer maximum mark of the question
	 * @param correctAnswer
	 *            The integer correct answer of the question
	 */
	public ExamQuestionNumeric(String questionText, int maximumMark, int correctAnswer) {
		super(questionText, maximumMark);
		this.correctAnswer = correctAnswer;
	}

	/**
	 * mark method compares the integer answer (value) of the exam question to the
	 * integer correct answer.
	 * 
	 * @param value
	 *            The integer answer of the question
	 * @return The integer maximumMark for a correct answer, 0 for an incorrect
	 *         answer
	 */
	public int mark(int value) {
		if (value == correctAnswer) {
			return getMaximalMark();
		} else {
			return 0;
		}
	}

	/**
	 * toString method for the ExamQuestionNumberic Class, uses the super class
	 * ExamQuestion toString method for the exam question and maximum mark.
	 * Concatenates the correct answer from the ExamQuestionNumeric Class
	 * 
	 * @return a string representation of the numerical exam question
	 */
	@Override
	public String toString() {
		return super.toString() + " Correct Answer is: " + correctAnswer;
	}
}
