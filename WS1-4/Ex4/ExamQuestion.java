/**
 * The class ExamQuestion consists of the fields questionText (String of the
 * exam question), and maximumMark (integer of the maximum mark of the
 * question).
 * 
 * The class consists of a constructor, getters and setters for the field
 * variables and a toString method.
 * 
 * @author Seapaddy
 * @version 2017-11-03
 */
public class ExamQuestion {
	private String questionText;
	private int maximumMark;

	/**
	 * Constructor for the ExamQuestion class
	 * 
	 * @param questionText
	 *            The String of the question
	 * @param maximumMark
	 *            The maximum mark of the question
	 */
	public ExamQuestion(String questionText, int maximumMark) {
		super();
		this.questionText = questionText;
		this.maximumMark = maximumMark;
	}

	/**
	 * getter for the question text
	 * 
	 * @return The String of the question
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * setter for the question
	 * 
	 * @param questionText
	 *            The String of the new question
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * getter for the maximum mark of the question
	 * 
	 * @return The value maximum mark for the question
	 */
	public int getMaximalMark() {
		return maximumMark;
	}

	/**
	 * setter for the maximum mark of the question
	 * 
	 * @param maximumMark
	 *            The new value of the maximum mark for the question
	 */
	public void setMaximalMark(int maximumMark) {
		this.maximumMark = maximumMark;
	}

	/**
	 * toString method for the exam question
	 * 
	 * @return A String representation of the exam question
	 */
	@Override
	public String toString() {
		return "Question (Maximal mark: " + maximumMark + "): " + questionText;
	}

}
