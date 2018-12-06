import java.util.ArrayList;

/**
 * The class ExamQuestionMultipleChoice extends the class ExamQuestion. It
 * inherits all the methods from the superclass. It has additional fields
 * possibleAnswers (an ArrayList of possible answers to the question) and
 * CorrectAnswers (an ArrayList of correct answers for the question).
 * 
 * The class consists of a constructor, a toString method, and the mark method.
 * 
 * The mark method, calculates and returns the mark determined through comparing
 * an ArrayList of answersProvided to the ArrayList of correctAnswers with the
 * maximum mark for the question.
 * 
 * @author Seapaddy
 * @version 2017-11-03, last changed 2017-11-10
 */
public class ExamQuestionMultipleChoice extends ExamQuestion {
	private ArrayList<String> possibleAnswers;
	private ArrayList<Integer> correctAnswers;

	/**
	 * Constructor for ExamQuestionMultipleChoice class
	 * 
	 * @param questionText
	 *            is a String of the question to be answered
	 * @param maximumMark
	 *            is the integer maximum mark of the question
	 * @param possibleAnswers
	 *            is the ArrayList of answer choices for the question
	 * @param correctAnswers
	 *            is the ArrayList of correct answers for the question
	 */
	public ExamQuestionMultipleChoice(String questionText, int maximumMark, ArrayList<String> possibleAnswers,
			ArrayList<Integer> correctAnswers) {
		super(questionText, maximumMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswers = correctAnswers;
	}

	/**
	 * mark computes the points by scaling the difference between the correct
	 * answers and incorrect answers to the maximal points and rounding the points
	 * to the closest integer
	 * 
	 * it does this by looping through the answers provided, comparing each one in
	 * turn to the correct answers, if they are equal it adds one to the correct
	 * answers, if none match before the end of the correct answer ArrayList then
	 * one is added to the wrong answer. the difference between correct answer and
	 * wrong answer is calculated, if it is less than or equal to zero, the points
	 * returned is 0. Else the points are calculated as the maximum mark multiplied
	 * by the correct point percentage of total correct answers
	 * 
	 * @param answersProvided
	 *            is the ArrayList of Integer answers, received by the method
	 * @return the integer mark calculated from answers provided to correct answers
	 */
	int mark(ArrayList<Integer> answersProvided) {
		// if the array is equal, returns full marks, no need for the calculating loops
		if (answersProvided.equals(correctAnswers)) {
			return getMaximalMark();
		}
		double maximumCorrectness = correctAnswers.size();
		double correct = 0;
		double wrong = 0;
		for (int i = 0; i < answersProvided.size(); i++) {
			for (int j = 0; j < correctAnswers.size(); j++) {
				if (answersProvided.get(i).equals(correctAnswers.get(j))) {
					for (int k = 0; k < i; k++) {
						if (answersProvided.get(k).equals(answersProvided.get(i))) {
							wrong++;
						}
					}
					correct++;
					break;
				}
				if (j == correctAnswers.size() - 1) {
					wrong++;
				}
			}
		}
		double difference = correct - wrong;
		if (difference <= 0) {
			return 0;
		} else {
			return (int) Math.round((getMaximalMark() * (difference / maximumCorrectness)));
		}
	}

	/**
	 * @return a string representation of the multiple choice question
	 */
	@Override
	public String toString() {
		return super.toString() + "\nPossible answers are: " + possibleAnswers + "\nCorrect answers are: "
				+ correctAnswers;
	}
}
