/**
 * Class Var is the blueprint for Var objects. The Var objects represent
 * variables. BuildClass function can use Var objects to produce strings of a
 * class with constructors, getters and setters with the correct indentation.
 * Contains a constructor to set the variables type and name, and to get methods
 * to return the variables type and name
 * 
 * @author Seapaddy
 * @version 2017-11-28
 */
public class Var {
	private String typeOfVar;
	private String nameOfVar;

	/**
	 * Constructor of the Var object
	 * 
	 * @param typeOfVar
	 *            receives the type of variable Var object represents
	 * @param nameOfVar
	 *            receives the name of variable Var object represents
	 */
	public Var(String typeOfVar, String nameOfVar) {
		super();
		this.typeOfVar = typeOfVar;
		this.nameOfVar = nameOfVar;
	}

	/**
	 * Gets the type of variable of the Var object
	 * 
	 * @return the variables type
	 */
	public String getTypeOfVar() {
		return typeOfVar;
	}

	/**
	 * Gets the name of variable of the Var object
	 * 
	 * @return the variables name
	 */
	public String getNameOfVar() {
		return nameOfVar;
	}

}
