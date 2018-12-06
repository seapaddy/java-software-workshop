import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BuildClassTests {
	public Var var1, var2, var3, var4;
	ArrayList<Var> variables, personName, noVariables;
	public BuildClass class1, class2, class3;

	@Before
	public void setUp() {
		var1 = new Var("String", "name");
		var2 = new Var("int", "age");
		var3 = new Var("char", "favouriteLetter");
		var4 = new Var("long", "greatestKnownPrime");

		variables = new ArrayList<Var>(Arrays.asList(var1, var2, var3, var4));
		personName = new ArrayList<Var>(Arrays.asList(var1));
		noVariables = new ArrayList<Var>();

		class1 = new BuildClass("Person", variables);
		class2 = new BuildClass("SmallClass", personName);
		class3 = new BuildClass("EmptyClass", noVariables);
	}

	/**
	 * tests the makeFields method of the BuildClass object
	 */
	@Test
	public void test1() {
		String expected = "\tprivate String name;\n" + "\tprivate int age;\n" + "\tprivate char favouriteLetter;\n"
				+ "\tprivate long greatestKnownPrime;\n\t\n";
		String actual = class1.makeFields();

		assertEquals(expected, actual);
	}

	/**
	 * tests the makeConstructor method of the BuildClass object
	 */
	@Test
	public void test2() {
		String expected = "\tpublic Person(String name, int age, char favouriteLetter, long greatestKnownPrime) {\n"
				+ "\t\tthis.name = name;\n" + "\t\tthis.age = age;\n" + "\t\tthis.favouriteLetter = favouriteLetter;\n"
				+ "\t\tthis.greatestKnownPrime = greatestKnownPrime;\n\t}\n\n";
		String actual = class1.makeConstructor();

		assertEquals(expected, actual);
	}

	/**
	 * tests the makeGetters method of the BuildClass object
	 */
	@Test
	public void test3() {
		String expected = "\tpublic String getName() {\n\t\treturn name;\n\t}\n\n"
				+ "\tpublic int getAge() {\n\t\treturn age;\n\t}\n\n"
				+ "\tpublic char getFavouriteLetter() {\n\t\treturn favouriteLetter;\n\t}\n\n"
				+ "\tpublic long getGreatestKnownPrime() {\n\t\treturn greatestKnownPrime;\n\t}\n\n";
		String actual = class1.makeGetters();

		assertEquals(expected, actual);
	}

	/**
	 * tests the makeSetters method of the BuildClass object
	 */
	@Test
	public void test4() {
		String expected = "\tpublic void setName(String newName) {\n\t\tthis.name = newName;\n\t}\n\n"
				+ "\tpublic void setAge(int newAge) {\n\t\tthis.age = newAge;\n\t}\n\n"
				+ "\tpublic void setFavouriteLetter(char newFavouriteLetter) {\n\t\tthis.favouriteLetter = newFavouriteLetter;\n\t}\n\n"
				+ "\tpublic void setGreatestKnownPrime(long newGreatestKnownPrime) {\n\t\tthis.greatestKnownPrime = newGreatestKnownPrime;\n\t}\n\n";
		String actual = class1.makeSetters();

		assertEquals(expected, actual);
	}

	/**
	 * tests the buildClass method of BuildClass object
	 */
	@Test
	public void test5() {
		String expected = "public class SmallClass { \n" + "\tprivate String name;\n\t\n"
				+ "\tpublic SmallClass(String name) {\n\t\tthis.name = name;\n\t}\n\n"
				+ "\tpublic String getName() {\n\t\treturn name;\n\t}\n\n"
				+ "\tpublic void setName(String newName) {\n\t\tthis.name = newName;\n\t}\n\n}";
		String actual = class2.buildClass();

		assertEquals(expected, actual);
	}
	
	/**
	 * tests the buildClass method for Class with no field variables
	 */
	@Test
	public void test6() {
		String expected = "public class EmptyClass { \n\t\n\tpublic EmptyClass() {\n\t\t\t}\n\n}";
		String actual = class3.buildClass();

		assertEquals(expected, actual);
	}

}
