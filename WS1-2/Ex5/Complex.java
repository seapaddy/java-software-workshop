/**	The class Complex which creates Complex objects
 *	Each Complex object has 2 double parameters, complex numbers real part and its imaginary part
 *
 *	Complex class has 2 getters, to return the real and imaginary parts of complex objects
 *
 *	Complex numbers consist of real part and the so-called imaginary part. They are written as z = a + bi.
 *	Addition and multiplication of two complex numbers z1 = a1 + b1i and z2 = a2 + b2i are defined as:
 *	add(z1,z2)=(a1+a2)+(b1+b2)i
 *	multiply(z1,z2)=(a1∗a2 − b1∗b2)+(a1∗b2 + a2∗b1)i
 *
 *	add function computes complex number addition of 2 complex numbers and returns the resulting complex number 
 *	multiply function computes complex number multiplication of 2 complex numbers and returns the resulting complex number
 *
 *	@author Seapaddy
 *	@version 2017-10-05, last changed 2017-10-18
 */
public class Complex {
	private double realPart;
	private double imaginaryPart;

	/**
	 * Constructor for the Complex class, initialises a complex objects attributes
	 * 
	 * @param realPart The real part of the Complex object
	 * @param imaginaryPart The imaginary part of the Complex object
	 */
	public Complex(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	/**
	 * Returns the real part of a Complex object
	 * 
	 * @return Returns the real part of a complex number
	 */
	public double getRealPart() {
		return realPart;
	}

	/**
	 * Returns the imaginary part of a Complex object
	 * 
	 * @return Returns the imaginary part of a complex number
	 */
	public double getImaginaryPart() {
		return imaginaryPart;
	}

	/**
	 * @return Returns the complex number in a readable string, real part and imaginary part
	 */
	@Override
	public String toString() {
		return  realPart + " + " + imaginaryPart + "i";
	}

	/**
	 * Computes and returns the addition of 2 Complex objects
	 * Addition of two complex numbers z1 = a1 + b1i and z2 = a2 + b2i is defined as:
	 * add(z1,z2)=(a1+a2)+(b1+b2)i
	 * 
	 * @param summand One Complex object for addition
	 * @return Returns the calculated complex number, as a Complex object
	 */
	public Complex add(Complex summand) {
		Complex addition = new Complex((this.realPart + summand.realPart), 
				(this.imaginaryPart + summand.imaginaryPart));
		
		return addition;
	}

	/**
	 * Computes and returns the multiplication of 2 Complex objects
	 * Multiplication of two complex numbers z1 = a1 + b1i and z2 = a2 + b2i is defined as:
	 * multiply(z1,z2)=(a1∗a2 − b1∗b2)+(a1∗b2 + a2∗b1)i
	 * 
	 * @param factor One Complex object for multiplication
	 * @return Returns the calculated complex number, as a Complex object
	 */
	 public Complex multiply(Complex factor) {
		 Complex multiplication = new Complex(((this.realPart * factor.realPart)
				 - (this.imaginaryPart * factor.imaginaryPart)), 
				 (this.realPart * factor.imaginaryPart) + (this.imaginaryPart * factor.realPart));
		 
		 return multiplication;
	 }
}
