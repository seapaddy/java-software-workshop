import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for Chess Object
 * 
 * @author Seapaddy
 * @version 2017-11-29
 *
 */
public class ChessTest {
	private Chess game1 = new Chess();

	/**
	 * test getPiece that returns a String of the grid position
	 */
	@Test
	public void test1() {
		String a2Expected = "PAWN";
		String a2Actual = game1.getPiece(0, 6);

		assertEquals(a2Expected, a2Actual);
	}

	/**
	 * test getPiece that returns a String of an empty grid position
	 */
	@Test
	public void test2() {
		String e5Expected = "";
		String e5Actual = game1.getPiece(4, 4);

		assertEquals(e5Expected, e5Actual);
	}

	/**
	 * test move changes chessPiece array position
	 */
	@Test
	public void test3() {
		String a2BeforeExpected = "PAWN";
		String a2BeforeActual = game1.getPiece(0, 6);

		assertEquals(a2BeforeExpected, a2BeforeActual);

		game1.move("a2a4");

		String a2AfterExpected = "";
		String a2AfterActual = game1.getPiece(0, 6);

		assertEquals(a2AfterExpected, a2AfterActual);
	}

	/**
	 * test move checks chessPiece new array position
	 */
	@Test
	public void test4() {
		String a4BeforeExpected = "";
		String a4BeforeActual = game1.getPiece(0, 4);

		assertEquals(a4BeforeExpected, a4BeforeActual);

		game1.move("a2a4");

		String a4AfterExpected = "PAWN";
		String a4AfterActual = game1.getPiece(0, 4);

		assertEquals(a4AfterExpected, a4AfterActual);
	}

	/**
	 * tests move onto previously moved piece checks chessPiece new array position,
	 * empty -> PAWN -> queen
	 */
	@Test
	public void test5() {
		String a4BeforeExpected = "";
		String a4BeforeActual = game1.getPiece(0, 4);

		assertEquals(a4BeforeExpected, a4BeforeActual);

		game1.move("a2a4");

		String a4AfterExpected = "PAWN";
		String a4AfterActual = game1.getPiece(0, 4);

		assertEquals(a4AfterExpected, a4AfterActual);
		
		game1.move("d8a4");
		
		String a4QueenExpected = "queen";
		String a4QueenActual = game1.getPiece(0, 4);

		assertEquals(a4QueenExpected, a4QueenActual);
	}
	
	/**
	 * tests no move from initial empty position
	 * empty -> queen does nothing
	 */
	@Test
	public void test6() {
		String d8BeforeExpected = "queen";
		String d8BeforeActual = game1.getPiece(3, 0);

		assertEquals(d8BeforeExpected, d8BeforeActual);

		game1.move("a4d8");

		String d8AfterExpected = "queen";
		String d8AfterActual = game1.getPiece(3, 0);

		assertEquals(d8AfterExpected, d8AfterActual);
	}
}
