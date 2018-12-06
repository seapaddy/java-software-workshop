import java.util.ArrayList;
import java.util.Arrays;

/**
 * BuildClassMain class contains a main method to test the Var and BuildClass
 * objects. We create some Var and BuildClass objects and print output to the
 * console.
 * 
 * @author Seapaddy
 * @version 2017-11-28
 */
public class BuildClassMain {

	/**
	 * main method to test BuildClass and Var objects
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Var var1 = new Var("double", "lemon");
		Var var2 = new Var("double", "fish");
		Var var3 = new Var("String", "igloo");
		Var var4 = new Var("int", "union");

		ArrayList<Var> variables = new ArrayList<Var>(Arrays.asList(var1, var2, var3, var4));
		BuildClass class1 = new BuildClass("PracticeClass", variables);
		// test buildclass
		System.out.println(class1.buildClass());
		System.out.println("-----------------------------------------------------");
		// test makefields
		System.out.println(class1.makeFields());
		System.out.println("-----------------------------------------------------");
		// test makeconstructor
		System.out.println(class1.makeConstructor());
		System.out.println("-----------------------------------------------------");
		// test makegetters
		System.out.println(class1.makeGetters());
		System.out.println("-----------------------------------------------------");
		// test makesetters
		System.out.println(class1.makeSetters());
		System.out.println("-----------------------------------------------------");

		// test empty class
		ArrayList<Var> emptyArray = new ArrayList<Var>();
		BuildClass emptyClass = new BuildClass("EmptyClass", emptyArray);
		System.out.println(emptyClass.buildClass());
	}

}
