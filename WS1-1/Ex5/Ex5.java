/*
 * Exercise 5
 * Calculates the angle between the hour hand and minute hand on a analogue clock face
 * angles are measured counterclockwise from hour to minute hand
 * 
 * @author  Seapaddy
 * @version 2017-09-29
 */


public class Ex5 {

	public static void main(String[] args) {
		
		angleBetweenHands(9, 00);
		angleBetweenHands(3, 00);
		angleBetweenHands(18, 00);
		angleBetweenHands(1, 00);
		angleBetweenHands(2, 30);
		angleBetweenHands(4, 41);

	}
	
	public static void angleBetweenHands(int hours, int minutes) {
		int minuteHandDegreesPerMinute = 6; 		//degrees minute hand moves every minute
		int hourHandDegreesPerHour = 30; 		// degrees hour hand moves every hour
		int maxHours = 12; 				// maximum number of hours on analogue clock
		int maxMinutes = 60; 				// maximum number of minutes per hour
		double hourHandDegreesPerMinute = 0.5; 		//degrees hour hand moves every minute
		double minuteDegreeFrom12, hourDegreeFrom12; 	//degrees from 12 of the minute hand and hour hand
		double angleHourToMinute; 			//angle between the hour hand and the minute hand	
		
		/*
		 * modulus(%) maxMinutes sets minute hand from 0 to 59
		 * modulus(%) maxHours sets hours hand from 0 to 11 (needed for hours such as 14 to produce 2)
		 */
		minuteDegreeFrom12 = (minutes%maxMinutes) * minuteHandDegreesPerMinute;
		hourDegreeFrom12 = ((hours%maxHours) * hourHandDegreesPerHour) + (minutes * hourHandDegreesPerMinute); 
		
		/*
		 * finds angle between hands
		 * converts degrees to positive integer
		 * modulus maxDegrees produces angle between hands, between 0 and 359 degrees
		 */
		int maxDegrees = 360;
		
		angleHourToMinute = hourDegreeFrom12 - minuteDegreeFrom12;
		angleHourToMinute = Math.round(angleHourToMinute + maxDegrees); 	//Math.round before using %, otherwise get 360 degrees for 2hr 11min
		angleHourToMinute = angleHourToMinute%maxDegrees; 

		/*
		 * Math.round function produces no decimal angles
		 */
		System.out.print("At " + hours + " hours and " + minutes + " minutes, ");	
		System.out.println("the angle between the hour hand and minute hand is " + (int) (angleHourToMinute) + " Degrees.");
	}

}
