/**
 * The class StarRating contains a method to interpret ratings, interpret
 * receives a rating between 1.0 and 5.0, and returns a string based on the
 * rating.
 * 
 * 1.0 up to, but excluding 4.0 returns "CRAP" || 4.0 up to, but excluding 4.5
 * returns "OK" || 4.5 up to, but excluding 5.0 returns "EXCELLENT" || 5.0
 * returns "[HAS ONLY ONE REVIEW]". If the received rating is outside the range
 * 1.0 to 5.0, interpret throws an IllegalArgumentException()
 * 
 * @author Seapaddy
 * @version 2017-10-26, last changed 2017-10-29
 */
public class StarRating {
	/**
	 * interpret method interprets received ratings
	 * 
	 * @param rating
	 *            The received rating (double)
	 * @return Returns String with the interpreted rating
	 */
	public static String interpret(double rating) {
		if (1.0 <= rating && rating < 4.0) {
			return "CRAP";
		} else if (4.0 <= rating && rating < 4.5) {
			return "OK";
		} else if (4.5 <= rating && rating < 5.0) {
			return "EXCELLENT";
		} else if (rating == 5.0) {
			return "[HAS ONLY ONE REVIEW]";
		} else {
			throw new IllegalArgumentException();
		}
	}
}
