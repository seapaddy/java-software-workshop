/*
 * Exercise 3
 * Calculations of capital over time with a fixed interest rate 
 * 
 * @author  Seapaddy
 * @version 2017-09-29
 */

public class Ex3 {

	public static void main(String[] args) {
		int years;
		double capital, interestRate, total, roundedTotal;
		
		capital = 100;
		interestRate = 2.3;
		years = 0;
		
		/*
		 * find total money using, total = capital ∗ (1 + 0.01 ∗ interest rate)^years
		 * Math.round(total*100)/100 gives answers to 2 decimal places
		 */
		years = 1;
		total = capital * Math.pow((1+0.01*interestRate),years);
		roundedTotal = Math.round(total*100);
		roundedTotal = roundedTotal / 100;
		System.out.println("The balance after " + years + " year is \u00A3" + roundedTotal + "0"); // 0 added for 2dp
		
		years = 2;
		total = capital * Math.pow((1+0.01*interestRate),years);
		roundedTotal = Math.round(total*100);
		roundedTotal = roundedTotal / 100;
		System.out.println("The balance after " + years + " year is \u00A3" + roundedTotal);
		
		years = 3;
		total = capital * Math.pow((1+0.01*interestRate),years);
		roundedTotal = Math.round(total*100);
		roundedTotal = roundedTotal / 100;
		System.out.println("The balance after " + years + " year is \u00A3" + roundedTotal);
		
		years = 4;
		total = capital * Math.pow((1+0.01*interestRate),years);
		roundedTotal = Math.round(total*100);
		roundedTotal = roundedTotal / 100;
		System.out.println("The balance after " + years + " year is \u00A3" + roundedTotal);
		
		years = 5;
		total = capital * Math.pow((1+0.01*interestRate),years);
		roundedTotal = Math.round(total*100);
		roundedTotal = roundedTotal / 100;
		System.out.println("The balance after " + years + " year is \u00A3" + roundedTotal);
		
		years = 500;
		total = capital * Math.pow((1+0.01*interestRate),years);
		roundedTotal = Math.round(total*100);
		roundedTotal = roundedTotal / 100;
		System.out.println("The balance after " + years + " year is \u00A3" + roundedTotal);
	}

}
