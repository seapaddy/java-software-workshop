/**	The class ClubMember which creates ClubMember objects
 *	Each ClubMember object has 4 String parameters, name, date of birth, registration number and membership type
 *	
 *	ClubMember class has 4 getters, to return the name, date of birth, registration number and membership type
 *	ClubMember class has a toString() method to print an objects attributes
 *
 *	@author Seapaddy
 *	@version 2017-10-05, last changed 2017-10-18
 */

public class ClubMember {
	private String name;
	private String dateOfBirth;
	private String registrationNumber;
	private String membershipType;
	
	/**
	 * Constructor for the ClubMember class, to initialise a club member objects attributes
	 * 
	 * @param name The name of the club member
	 * @param dateOfBirth The date of birth of the club member
	 * @param registrationNumber The registration number of the club member
	 * @param membershipType The membership type of the club member
	 */
	public ClubMember(String name, String dateOfBirth, String registrationNumber, String membershipType) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.registrationNumber = registrationNumber;
		this.membershipType = membershipType;
	}

	/**
	 * Returns the name of the club member object
	 * 
	 * @return Returns the name of the club member
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the date of birth of the club member object
	 * 
	 * @return Returns the date of birth of the club member
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Returns the registration number of the club member object
	 * 
	 * @return Returns the registration number of the club member
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * Returns the membership type of the club member
	 * 
	 * @return Returns the membership type of the club member
	 */
	public String getMembershipType() {
		return membershipType;
	}

	/**
	 * @return Returns the club member objects attributes to a readable string
	 */
	@Override
	public String toString() {
		return "[" + name + ", " + dateOfBirth + ", ID: " + registrationNumber 
				+ ", " + membershipType + "]";
	}
}
