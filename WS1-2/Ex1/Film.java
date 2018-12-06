/**	The class Film which creates Film objects
 *	Each Film object has 3 parameters, String title, int year and int length
 *	
 *	Film class has 3 getters, to get the Title, Year and Length of the film
 *	Film class has a toString() method to print an objects attributes
 *
 *	@author Seapaddy
 *	@version 2017-10-05, last changed 2017-10-18
 */

public class Film {
	private String title;
	private int year;
	private int length;
	
	/**
	 * Constructor for the Film class, to initialise a film objects attributes
	 * 
	 * @param title Initialises the title of the film
	 * @param year Initialises the year of the film
	 * @param length Initialises the length of the film
	 */
	public Film (String title, int year, int length) {
		this.title = title;
		this.year = year;
		this.length = length;
	}
	
	/**
	 * Returns the title of the film object
	 * 
	 * @return Returns the Title of the film
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Returns the Year of the film object
	 * 
	 * @return Returns the year the film was made
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Returns the duration of the film object
	 * 
	 * @return Returns the length of the film
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Sets the length for the film object
	 * 
	 * @param newLength Sets a new length for the film object
	 */
	public void setLength(int newLength) {
		this.length = newLength;
	}
	@Override
	/**
	 * @return Returns the film objects variables to a readable string
	 */
	public String toString() {
		return "Film [title=" + title + ", year=" + year + ", length=" + length + "]";
	}
}
