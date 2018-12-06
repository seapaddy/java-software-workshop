/*
 * Exercise 2
 * Conversion of imperial masses into kilogrames
 * 
 * @author  SeaPaddy
 * @version 2017-09-29
 */

public class Ex2 {

	public static void main(String[] args) {
		int ton, hundredweight, quarter, stone, ounce, drachm, grain, pounds;
		double kilograms;
		
		ton = 0;
		hundredweight = 0;
		quarter = 0;
		stone = 11;
		ounce = 0;
		drachm = 0;
		grain = 0;
		pounds = 6;
		
		/*
		 * using conversion table
		 * 1 ton					2240 pounds
		 * 1 hundredweight 		112 pounds
		 * 1 quarter				28 pounds
		 * 1 stone				14 pounds
		 * 1 ounce				1/16 pounds
		 * 1 drachm				1/256 pounds
		 * 1 grain				1/7000 pounds
		 * 1 pound				0.45359237 kilograms
		 */
		kilograms = ((ton*2240) + (hundredweight*112) + (quarter*28) + (stone*14) + (ounce/16) + (drachm/256) + (grain/7000) + (pounds)) * 0.45359237;
		
		System.out.print("A weight of ");
		System.out.print(ton + " tons, ");
		System.out.print(hundredweight + " hundredweights, "); 
		System.out.print(quarter + " quarters, ");
		System.out.print(stone + " stones, "); 
		System.out.print(+ ounce + " ounces, ");
		System.out.print(drachm + " drachm, ");
		System.out.print(grain + " grain and ");
		System.out.println(pounds + " pounds, is");
		System.out.println(kilograms + " kilograms.");

	}

}
