import java.util.ArrayList;

/**
 * Build class contains a blueprint to create a Class object. It can be used to
 * produce a string representation of java classes. Build class objects contains
 * methods that receive Var objects, and return Strings of field variables,
 * constructors, getters, and setters, to produce a string representation of the
 * set up of a class in java.
 * 
 * @author Seapaddy
 * @version 2017-11-28
 */
public class BuildClass {
	private String className;
	private ArrayList<Var> fields;

	/**
	 * Constructor of the BuildClass object
	 * 
	 * @param className
	 *            receives the objects class name
	 * @param fields
	 *            receives the objects fields in an array list of Var objects
	 */
	public BuildClass(String className, ArrayList<Var> fields) {
		super();
		this.className = className;
		this.fields = fields;
	}

	/**
	 * Returns a String of the fields of a Class
	 * 
	 * @return the String representation of a classes fields
	 */
	public String makeFields() {
		String output = "\t";
		for (Var var : fields) {
			output += "private " + var.getTypeOfVar() + " " + var.getNameOfVar() + ";\n\t";
		}
		output += "\n";
		return output;
	}

	/**
	 * Returns a String of the constructor of a class
	 * 
	 * @return the String representation of a classes constructor
	 */
	public String makeConstructor() {
		String output = "\tpublic ";
		output += className + "(";
		for (int i = 0; i < fields.size(); i++) {
			output += fields.get(i).getTypeOfVar() + " " + fields.get(i).getNameOfVar();
			if (i == fields.size() - 1) {
				break;
			} else {
				output += ", ";
			}
		}
		output += ") {\n\t\t";
		for (int i = 0; i < fields.size(); i++) {
			output += "this." + fields.get(i).getNameOfVar() + " = " + fields.get(i).getNameOfVar() + ";\n";
			if (i == fields.size() - 1) {
				break;
			} else {
				output += "\t\t";
			}
		}
		output += "\t}\n\n";
		return output;
	}

	/**
	 * Returns a String of the getters of a class
	 * 
	 * @return the String representation of all field variable getters within a
	 *         class
	 */
	public String makeGetters() {
		String output = "";
		for (Var var : fields) {
			output += "\tpublic " + var.getTypeOfVar() + " get" + var.getNameOfVar().substring(0, 1).toUpperCase()
					+ var.getNameOfVar().substring(1) + "() {\n\t\treturn " + var.getNameOfVar() + ";\n\t}\n\n";
		}
		return output;
	}

	/**
	 * Returns a String of the setters of a class
	 * 
	 * @return the String representation of all field variable setters within a
	 *         class
	 */
	public String makeSetters() {
		String output = "";
		for (Var var : fields) {
			output += "\tpublic void set" + var.getNameOfVar().substring(0, 1).toUpperCase()
					+ var.getNameOfVar().substring(1) + "(" + var.getTypeOfVar() + " new"
					+ var.getNameOfVar().substring(0, 1).toUpperCase() + var.getNameOfVar().substring(1)
					+ ") {\n\t\tthis." + var.getNameOfVar() + " = new"
					+ var.getNameOfVar().substring(0, 1).toUpperCase() + var.getNameOfVar().substring(1) + ";\n\t}\n\n";
		}
		return output;
	}

	/**
	 * Returns a String of the entire class
	 * 
	 * @return the String representation of the entire class, class name, field
	 *         variables, constructor, getters and setters
	 */
	public String buildClass() {
		String output = "public class ";
		output += className + " { \n";
		output += makeFields();
		output += makeConstructor();
		output += makeGetters();
		output += makeSetters();
		output += "}";
		return output;
	}
}
