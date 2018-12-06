/*
 * Exercise 4
 * Calculates the sum and product of 2 fractions
 * 
 * @author  Seapaddy
 * @version 2017-09-29
 */

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * Use the SumFractions function
		 * or ProductFractions function
		 * with 4 variables
		 * SumFractions (enumerator 1, denominator 1, enumerator 2, denominator 2)
		 * ProductFractions (enumerator 1, denominator 1, enumerator 2, denominator 2)
		 */
		int e1, e2, d1, d2;
		
		e1 = 1; d1 = 2;
		e2 = 1; d2 = 3;	
		sumFractions(e1, d1, e2, d2);
		
		e1 = 1; d1 = 3;
		e2 = 3; d2 = 4;	
		sumFractions(e1, d1, e2, d2);
		
		e1 = 1; d1 = 2;
		e2 = 2; d2 = 3;	
		productFractions(e1, d1, e2, d2);
		
		e1 = 1; d1 = 4;
		e2 = 2; d2 = 3;	
		productFractions(e1, d1, e2, d2);
		
	}
	/*
	 * Function to calculate the enumerator and denominator, from the sum of 2 fractions
	 */
	public static void sumFractions(int e1, int d1, int e2, int d2) {
		int es, ds; //sum enumerator and denominator respectively
		
		es = (e1 * d2) + (e2 * d1); //sum enumerator
		ds = d1 * d2; //sum denominator
		
		System.out.print("Sum of " + e1 + "/" + d1);
		System.out.print(" and " + e2 + "/" + d2);
		System.out.print(" is " + es + "/" + ds);
		System.out.println(" where es is " + es + " and ds is " + ds + ".");
	}
	
	/*
	 * Function to calculate the enumerator and denominator, from the product of 2 fractions
	 */
	public static void productFractions(int e1, int d1, int e2, int d2) {
		int ep, dp; //product enumerator and denominator respectively
		
		ep = e1 * e2; //product enumerator
		dp = d1 * d2; //product denominator
		
		System.out.print("Product of " + e1 + "/" + d1);
		System.out.print(" and " + e2 + "/" + d2);
		System.out.print(" is " + ep + "/" + dp);
		System.out.println(" where ep is " + ep + " and dp is " + dp + ".");
	}

}
