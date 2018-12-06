/*
 * Exercise 1
 * Calculates the area of a circle with radius r
 * 
 * @author  SeaPaddy
 * @version 2017-09-29
 */

public class Ex1 {
	public static void main(String[] args) {
		int radius = 5;
		double area;
		area = Math.PI * square(radius);
		System.out.println("The area of a circle with radius " + radius + " is " + area);
	}
	public static int square(int x) {
		return x * x;
	}
}
