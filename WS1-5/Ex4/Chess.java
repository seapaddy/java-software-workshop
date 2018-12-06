import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class Chess contains the blueprint for Chess objects. The chess object
 * constructor creates an array that represents a chess board, which can be
 * output to the console using the toString method.
 * 
 * The chess object contains several methods, getPiece and setPiece to reassign
 * piece locations within the chessBoard array. initialiseChessBoard which will
 * initialise the chessBoard for starting a game. chessInteraction allows input
 * from the console to manipulate the chess piece positions. inputMove reassigns
 * chess piece positions with using Sting input.
 * 
 * @author Seapaddy
 * @version 2017-11-28
 */
public class Chess {
	private String[][] chessBoard = new String[8][8];
	private static Scanner s;
	public static final Pattern inputMove = Pattern.compile("[a-h][1-8][a-h][1-8]|q");
	private static int checkEmpty = 0;

	/**
	 * Constructor calls the initialiseChessBoard function which initialises the
	 * chess pieces within the chessBoard array.
	 */
	public Chess() {
		super();
		initialiseChessBoard();
	}

	/**
	 * initialiseChessBoard sets the chess board pieces to their starting positions
	 * within the array for a game of chess. To distinguish the pieces without black
	 * and white we have used uppercase and lowercase pieces.
	 */
	private void initialiseChessBoard() {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[i].length; j++) {
				this.chessBoard[i][j] = "";
			}
		}

		this.chessBoard[0][0] = "rook";
		this.chessBoard[0][7] = "rook";

		this.chessBoard[0][1] = "knight";
		this.chessBoard[0][6] = "knight";

		this.chessBoard[0][2] = "bishop";
		this.chessBoard[0][5] = "bishop";

		this.chessBoard[0][3] = "queen";
		this.chessBoard[0][4] = "king";

		for (int i = 0; i < chessBoard[1].length; i++) {
			this.chessBoard[1][i] = "pawn";
		}

		this.chessBoard[7][0] = "ROOK";
		this.chessBoard[7][7] = "ROOK";

		this.chessBoard[7][1] = "KNIGHT";
		this.chessBoard[7][6] = "KNIGHT";

		this.chessBoard[7][2] = "BISHOP";
		this.chessBoard[7][5] = "BISHOP";

		this.chessBoard[7][3] = "QUEEN";
		this.chessBoard[7][4] = "KING";

		for (int i = 0; i < chessBoard[6].length; i++) {
			this.chessBoard[6][i] = "PAWN";
		}
	}

	/**
	 * Returns the String name of the chess piece in the position xCoordinate,
	 * yCoordinate
	 * 
	 * @param xCoordinate
	 *            is the chessBoard array horizontal index position
	 * @param yCoordinate
	 *            is the chessBoard array vertical index position
	 * @return the chess piece String name in the selected array location
	 */
	public String getPiece(int xCoordinate, int yCoordinate) {
		return chessBoard[yCoordinate][xCoordinate];
	}

	/**
	 * Replaces the array location String at location xCoordinate, yCoordinate with
	 * the String chessPiece
	 * 
	 * @param chessPiece
	 *            is String overwriting the current array String
	 * @param xCoordinate
	 *            is the chessBoard array horizontal index position
	 * @param yCoordinate
	 *            is the chessBoard array vertical index position
	 */
	public void setPiece(String chessPiece, int xCoordinate, int yCoordinate) {
		chessBoard[yCoordinate][xCoordinate] = chessPiece;
	}

	/**
	 * ChessInteraction method allows users to input coordinates to move chess
	 * pieces to other board locations. This is achieved using the Scanner input
	 * function which receives input from the console. The Pattern class has been
	 * used to limit user input to the specific locations on the board. If incorrect
	 * input is received the method throws an input exception error and looks for
	 * new input from the console. The command q from the console will quit the
	 * chess interaction. Chess Interaction uses the move method to reassign piece
	 * locations.
	 */
	public void chessInteraction() {
		System.out.println(toString());
		System.out.println(
				"Welcome to this game of chess!\nPlease input your move in the format \"a2a4\".\nThis move would move the piece at grid position 'a2' to grid position 'a4'.\nIf you would like to quit the game enter \"q\".");
		s = new Scanner(System.in);
		String input = "";
		while (!input.equals("q")) {
			try {
				input = s.next(inputMove);
				if (input.equals("q")) {
					break;
				}
				move(input);
				System.out.println(toString());
				if (checkEmpty == 0) {
					System.out.println("Good Move!!");
				} else {
					System.out.println(
							"This input is allowed, but no pieces have moved as the initial grid position was empty.");
					checkEmpty = 0;
				}
				System.out.println("Please enter another coordinate to move the next piece.");
			} catch (InputMismatchException e2) {
				System.out.println(
						"This is incorrect input for this game.\nPlease enter coordinates in the format \"a2a4\", to move a piece from a2 to a4.\nAlternatively enter q to quit the game.");
				s = new Scanner(System.in);
			}
		}
		System.out.println("You have quit the game using the command \"q\"."
				+ "\nThe final chess board and piece locations are shown above.\n");
	}

	/**
	 * inputMove reassigns piece locations within the ChessBoard array. It converts
	 * the input from the console into array locations. It can then use the
	 * functions getPiece and setPiece to reassign the piece locations within the
	 * array. If a piece is moved to the location of another piece the current piece
	 * in the array is overwritten with the moved piece. If the starting position is
	 * empty the method does nothing. Else it overwrite the new position with the
	 * current piece and resets the old position to an empty String.
	 * 
	 * String inputMove is changed to array locations using manipulation of char,
	 * -'a' changes an alphabetical character to its corresponding index point
	 * within an alphabet array. And -49 changes the char value converted from a
	 * String integer into an integer. Ycoordinate also has to be reversed as array
	 * indexes start from 0 top and increase downwards (reason for 7-...).
	 * 
	 * @param inputMove
	 *            the String received from the console by the user
	 */
	public void move(String inputMove) {
		int coordinateXStart = inputMove.charAt(0) - 'a';
		int coordinateYStart = 7 - (inputMove.charAt(1) - 49);

		int coordinateXEnd = inputMove.charAt(2) - 'a';
		int coordinateYEnd = 7 - (inputMove.charAt(3) - 49);

		String piece = getPiece(coordinateXStart, coordinateYStart);
		if (piece.equals("")) {
			checkEmpty = 1;
		} else {
			setPiece(piece, coordinateXEnd, coordinateYEnd);
			setPiece("", coordinateXStart, coordinateYStart);
		}
	}

	/**
	 * toString should change as array of chessBoard pieces is changed. The board
	 * layout should stay constant throughout.
	 * 
	 * @return the String representation of the ChessBoard object
	 */
	@Override
	public String toString() {
		String output = "\t    a\t    b\t    c\t    d\t    e\t    f\t    g\t    h\n";

		for (int i = 0; i < chessBoard.length; i++) {
			output += "\t";
			for (int k = 0; k < chessBoard.length; k++) {
				output += "+-------";
				if (k == chessBoard.length - 1) {
					output += "+\n";
				}
			}
			output += "      " + (chessBoard.length - i) + "\t";
			for (int j = 0; j < chessBoard.length; j++) {
				if (j == chessBoard.length - 1) {
					output += "|" + chessBoard[i][j] + "\t| " + (chessBoard.length - i) + "\n";
				} else
					output += "|" + chessBoard[i][j] + "\t";
			}
		}
		
		output += "\t";
		for (int k = 0; k < chessBoard.length; k++) {
			output += "+-------";
			if (k == chessBoard.length - 1) {
				output += "+\n";
			}
		}
		output += "\t    a\t    b\t    c\t    d\t    e\t    f\t    g\t    h\n";
		return output;
	}
}
