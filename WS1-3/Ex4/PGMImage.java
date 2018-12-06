import java.io.*;
import java.util.Scanner;

/**
 * The class creates a PGMImage, which is read in from a file. It contains the
 * crop method, crops the left upper half of the picture and write it out again.
 * 
 * The quarter method, takes the average of 4 adjacent cells replacing with a
 * single cell in a PGMImage by averaging and rounding. Returns a
 * two-dimensional array and writes the array out to filename
 * 
 * The rotate method, rotates a received array 90 degrees. Returns the two
 * dimensional array and writes it out to filename
 * 
 * The bw method, converts a received P2 image in grey-scale into a black and
 * white image of type P1. Returns an array of 1's and 0's and writes the array
 * out to filename
 *
 * @version 2015-10-19, last changed 2017-11-02
 * @author Seapaddy
 */
public class PGMImage {
	private int width;
	private int height;
	private int maxShade;
	private String typeOfFile;
	private short[][] pixels;

	/**
	 * @param filename
	 *            The name of a file that contains an image in pgm format of type
	 *            P2.
	 *
	 */
	public PGMImage(String filename) {
		// try since the file may not exist.
		try {
			// we read from the scanner s which is linked to the file filename.
			Scanner s = new Scanner(new File(filename));

			/*
			 * The field variables are assigned by reading in from a file. The file should
			 * start with something like P2 150 176 255
			 * 
			 * where P2 is the file type, 150 the width of the image, 176 the height, and
			 * 255 the maximal grey value. Then follow 150*176 grey values between 0 and
			 * 255.
			 */

			// We read the initial element that is in our case "P2"
			typeOfFile = s.next();
			// Next we read the width, the height, and the maxShade.
			width = s.nextInt();
			height = s.nextInt();
			maxShade = s.nextInt();
			// We initialise and read in the different pixels.
			pixels = new short[height][width];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					pixels[i][j] = s.nextShort();
				}
			}
			// We finished reading and close the scanner s.
			s.close();
		} catch (IOException e) {
			// If the file is not found, an error message is printed,
			// and an empty image is created.
			System.out.println("File not found.");

			typeOfFile = "P2";
			width = 0;
			height = 0;
			maxShade = 0;
			pixels = new short[width][height];
		}
	}

	/**
	 * @return The width of the image.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return The height of the image.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return The maximal grey value of the image.
	 */
	public int getMaxShade() {
		return maxShade;
	}

	/**
	 * @return The file type of the image.
	 */
	public String getTypeOfFile() {
		return typeOfFile;
	}

	/**
	 * @return The matrix representing the pixels of the image.
	 */
	public short[][] getPixels() {
		return pixels;
	}

	/**
	 * The method writes out a PGMImage file, and throws an
	 * IllegalArgumentException() if errors are present
	 * 
	 * @param filename
	 *            The filename that the output PGMImage is saved
	 * @param typeOfFile
	 *            Type of PGMImage eg. P1 or P2
	 * @param imageMatrix
	 *            Array of output PGMImage pixel values
	 * @param newImageWidth
	 *            Written PGMImage width
	 * @param newImageHeight
	 *            Written PGMImage height
	 */
	public void writeOut(String filename, String typeOfFile, int[][] imageMatrix, int newImageWidth,
			int newImageHeight) {
		try {

			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			// We write the file type to out.
			out.write(typeOfFile + "\n");

			// We write the dimensions to out.
			out.write(newImageWidth + " " + newImageHeight + "\n");

			// We write maximal number.
			if (typeOfFile != "P1") {
				out.write(getMaxShade() + "\n");
			}

			// write out new image height and width
			byte counter = 0;
			for (int i = 0; i < newImageHeight; i++) {
				for (int j = 0; j < newImageWidth; j++) {
					out.write(imageMatrix[i][j] + " ");
					counter++;
					if (counter == 15) {
						out.write("\n");
						counter = 0;
					}
				}
			}
			out.write("\n");
			// We close the file.
			out.close();
		} catch (IOException e) {
			// Errors are caught.
			throw new IllegalArgumentException();
		}
	}

	/**
	 * The method crops the left upper half of an image.
	 * 
	 * @param filename
	 *            The filename of the file in which the cropped image should be
	 *            saved.
	 */
	public void crop(String filename) {
		int[][] cropMatrix = new int[getHeight() / 2][getWidth() / 2];
		for (int i = 0; i < getHeight() / 2; i++) {
			for (int j = 0; j < getWidth() / 2; j++) {
				cropMatrix[i][j] = getPixels()[i][j];
			}
		}
		writeOut(filename, typeOfFile, cropMatrix, getWidth() / 2, getHeight() / 2);
	}

	/**
	 * quarter method averages four adjacent cells replacing them with a single cell
	 * in a PGMImage by averaging and rounding, returnedArray has half the pixels,
	 * therefore, is half height and width of the received array
	 * 
	 * @param filename
	 *            Name of the written file, where the quartered image is saved
	 * @return Returns two-dimensional matrix (outputArray) with the averaged values
	 */
	public int[][] quarter(String filename) {
		int[][] outputMatrix = new int[getHeight() / 2][getWidth() / 2];
		double sum;
		int totalPixels;

		for (int i = 0; i < getHeight() / 2; i++) {
			for (int j = 0; j < getWidth() / 2; j++) {
				sum = 0;
				totalPixels = 0;
				for (int xPixel = i * 2; xPixel < ((i * 2) + 2); xPixel++) {
					for (int yPixel = j * 2; yPixel < ((j * 2) + 2); yPixel++) {
						sum += getPixels()[xPixel][yPixel];
						totalPixels++;
					}
				}
				sum /= totalPixels;
				outputMatrix[i][j] = (int) Math.round(sum);
			}
		}
		writeOut(filename, typeOfFile, outputMatrix, getWidth() / 2, getHeight() / 2);

		return outputMatrix;
	}

	/**
	 * rotate method rotates a matrix 90 degrees, this is done through re-mapping
	 * the received array, new matrix's width equals old matrix's height, new
	 * matrix's height equals old array's width
	 * 
	 * to rotate 90 degrees use the formula below (i,j) -> (j, (array.height-1)-i))
	 * 
	 * rotate also writes a file, in PGMImage format, to filename
	 * 
	 * @param filename
	 *            Name of the written file, where the rotated image is saved
	 * @return Returns two-dimensional array, 90 degrees from received array
	 */
	public int[][] rotate(String filename) {
		int[][] outputMatrix = new int[getWidth()][getHeight()];
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				outputMatrix[j][(getHeight() - 1) - i] = getPixels()[i][j];
			}
		}
		writeOut(filename, typeOfFile, outputMatrix, getHeight(), getWidth());

		return outputMatrix;

	}

	/**
	 * bw method converts a grey-scale matrix from a "P2" PGMImage into a black and
	 * white matrix (1's and 0's) used in "P1" PGMImages, the method averages the
	 * gray-scale value of the received matrix, converts to 1's and 0's, and returns
	 * outputMatrix. (Black is less than or equal to gray-scale (converts to 1),
	 * White is greater than gray-scale (converts to 0).
	 * 
	 * Using writeFile() method, saves a file with "P1" PGMImage format to filename.
	 * 
	 * @param filename
	 *            Name of the written file, where the black and white image is saved
	 * @return Returns matrix of 1's and 0's, (black and white)
	 */
	public int[][] bw(String filename) {
		/**
		 * grayAverage returns the average gray value, double sum is the total of arrays
		 * pixel values, elementNumber number of elements in the array average is the
		 * gray value average
		 */
		int[][] outputMatrix = new int[getHeight()][getWidth()];

		double sum = 0;
		int elementNumber = 0;
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				sum += getPixels()[i][j];
				elementNumber++;
			}
		}
		double grayAverage = sum / elementNumber;

		/**
		 * using the grey average, below or equal is black, above is white, outputArray
		 * is matrix of 1 (black) and 0 (white) pixels
		 */
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				if (getPixels()[i][j] <= grayAverage) {
					outputMatrix[i][j] = 1;
				} else {
					outputMatrix[i][j] = 0;
				}
			}
		}
		writeOut(filename, "P1", outputMatrix, getWidth(), getHeight());

		return outputMatrix;

	}

	/*
	 * An example.
	 */
	public static void main(String[] args) {
		PGMImage cs = new PGMImage("ComputerScience.pgm");
		cs.crop("ComputerScienceCrop.pgm");
	}
}
