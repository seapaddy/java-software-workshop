import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Tests for PGMImage Class
 * 
 * @author Seapaddy
 * @version 2017-10-29
 *
 */
public class PGMImageTest {
	private PGMImage image1, image2, image3;

    @Before
    /**
     * initialise the variables
     */
    public void setUp() {
        image1 = new PGMImage("image1.pgm");
        image2 = new PGMImage("image2.pgm");
        image3 = new PGMImage("image3.pgm");
    }

	@Test
	/**
	 * tests for image1 rotation
	 */
	public void test1() {
		int[][] expected = {{85, 34, 87, 14}, 
				{93, 83, 94, 8}, 
				{77, 40, 97, 110}, 
				{54, 27, 40, 86}};

		int[][] actual = image1.rotate("image1-rotate.pgm");
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests for image1 bw
	 */
	public void test2() {
		int[][] expected = {{1, 1, 0, 0},
				{0, 0, 0, 1}, 
				{1, 0, 1, 1}, 
				{0, 0, 0, 1}};

		int[][] actual = image1.bw("image1-bw.pgm");
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests for image2 quarter
	 */
	public void test3() {
		int[][] expected = {{20, 25, 30, 35, 40, 45, 50, 55, 60}, 
				{110, 115, 120, 125, 130, 135, 140, 145, 150}, 
				{200, 205, 210, 215, 220, 225, 230, 235, 240}};

		int[][] actual = image2.quarter("image2-quarter.pgm");
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests for image3 bw
	 */
	public void test4() {
		int[][] expected = {{0, 0, 0, 0}, 
				{1, 1, 1, 1}};

		int[][] actual = image3.bw("image3-bw.pgm");
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests for double rotation using image2
	 */
	public void test5() {
		int[][] expected = {{20, 158, 141, 174}, 
				{207, 220, 250, 243}};
		
		image3.rotate("rotation1.pgm");
		PGMImage firstRotation = new PGMImage("rotation1.pgm");
		int[][] actual = firstRotation.rotate("rotation2.pgm");
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	/**
	 * tests rotate, quarter then bw
	 */
	public void test6() {
		int[][] expected = {{0, 1}, {1, 0}};
		
		image1.rotate("step1.pgm");
		PGMImage rotation = new PGMImage("step1.pgm");
		rotation.quarter("step2.pgm");
		PGMImage quart = new PGMImage("step2.pgm");
		int[][] actual = quart.bw("finalstep.pgm");
		
		assertArrayEquals(expected, actual);
	}


}
