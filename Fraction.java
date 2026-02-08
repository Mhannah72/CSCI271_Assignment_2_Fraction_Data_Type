/*************************************************************************
* Assignment 2 for CSCI 271-001 Spring 2026
*
* Author: Malik Hannah
* OS: Ubuntu Debian Linux 21.1
* Compiler: javac 25.0.1
* Date: February 6, 2026
*
* Purpose
* This program performs arithmetic calculations for fractions by calling various methods using a object-oriented class
*
*************************************************************************/
/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* <Malik Hannah>
* <W30626500>
********************************************************************/

public interface Fraction {
     long getNumerator();
     long getDenominator();

     public Fraction multiply(Fraction f); // Returns a new fraction of this fraction multiplied by f
     public Fraction divide(Fraction f); // Returns a new fraction of this fraction divided by f 
     public Fraction add(Fraction f); // Returns a new fraction of this fraction plus f
     public Fraction subtract(Fraction f); // Returns a new fraction of this fraction minus f
     public String toString(); // Converts computed fraction into a output string
     public Fraction pow(int n); // Returns a new fraction of this fraction raise ot the n power (n may be zero or negatiev)
     public Fraction negate(); // Reutrns a new fraction that is the negative of this Fraction (for example negate of Infinity is -Infinity, negate of NaN is NaN.
}
