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

public class FractionQueue implements Fraction {


    private long numerator;
    private long denominator;


    /*
    CONSTRUCTOR
    - Runs when a new object is created (for example Fraction f1 = new Fraction())
    - Ensures the oject starts in a valid state

    This constructor specifically...
    - Prevents denominator = 0 errors
    - Normalizes signs (negative only in numerator)
    - Fraction reduction using GCD (given in instructions)
    
    */

    public FractionQueue(long num, long denom) 
    {

        // Case 1: Denominator is zero, fraction is undefined. Values are still stored for output later
        if (denom == 0) 
        {
            numerator = num;
            denominator = 0;
        }

        // Case 2: Numerator is zero, fraction must be 0/1
        else if (num == 0)
        {
            numerator = 0;
            denominator = 1;
        }

        //Case 3: Normal fraction
        else {

            // Moves any negative sign to the numerator only
            if (denom < 0)
            {
                num = -num;
                denom = -denom;

            }

            // Reduces the fraction using greatest common divisor
            long g = gcd(num, denom);
            numerator = num / g;
            denominator = denom / g;
        }
    }

    //Overloaded constructor for whole numbers
    public FractionQueue(long num)
    {
        this(num, 1);
    }

    /*
    PRIVATE HELPER METHOD

    This is a private method due to:
    - Being an internal implementation detail
    - Users of the class don't need to see it (An example of abstraction and encapsulation)

    Computes the greatest common divisor using Euclid's algorithm (provided in the instructions)
    */

    private static long gcd(long a, long b)
    {
        long remainder;

        // Ensures values are positive;
        if (a < 0) a = -a;
        if (b < 0) b = -b;

        // Implemntation of Euclid's algorithm
        while (b != 0)
        {
            remainder = a % b;
            a = b;
            b = remainder;
        }

        // Prevents division by zero
        if (a == 0) return 1;
        return a;
    }

    /*
    ACCESSOR METHODS (GETTERS)
    
    - These allow READ-ONLY access to private fields (numerator & denominator)
    - Preserves encapsulation 
    */

    public long getNumerator()
    {
        return numerator;
    }

    public long getDenominator()
    {
        return denominator;
    }

    /*
    FRACTION OPERATORS

    Each operation:
    - Does NOT modify the current object
    - Instead returns a NEW Fraction object
    
    */


    /*
    Adds this fraction to another fraction.

    Formula:
        a/b + c/d = (ad + bc) / bd
    
    */
    public Fraction add(Fraction f)
    {
        return new FractionQueue(numerator * f.getDenominator() + f.getNumerator() * denominator, denominator * f.getDenominator());
    }

    /*
    Subtracts another fraction from this fraction.

    Formula:
        a/b - c/d = (ad - bc) / bd
    
    */

    public Fraction subtract(Fraction f)
    {
        return new FractionQueue(numerator * f.getDenominator() - f.getNumerator() * denominator, denominator * f.getDenominator()); 
    }

    /*
    Multipies two fractions.

    Formula:
        a/b * c/d = (ac) / (bd)
    
    */

      public Fraction multiply(Fraction f)
    {
        return new FractionQueue(numerator * f.getNumerator(), denominator * f.getDenominator());
    }

    /*
    Divides two fractions

    Formula:
        a/b / c/d = (a/b) * (d/c) Reciprocal multiplication
    
    */

    public Fraction divide(Fraction f)
    {
        return new FractionQueue(numerator * f.getDenominator(), denominator * f.getNumerator());
    }

    /*
    Returns the NEGATION of this fraction

    Example:
        3/4 -> -3/4
    
    */

    public Fraction negate()
    {
        return new FractionQueue(-numerator, denominator);
    }

    /* 
    Raises fraction to the power n

    Conditions:
    - n = 0 -> result is 1/1
    - n > 0 -> raise numerator and denominator to n
    - n < 0 -> invert fraction and use n
    
    */


    public Fraction pow(int n)
    {
        
        // Any number to power of 0 is 1
        if (n == 0)
        {
            return new FractionQueue(1,1);
        }

        Fraction result = new FractionQueue(1,1);
        Fraction base = this;

        // If exponent is negative, the base is inverted
        if (n < 0)
        {
            base = new FractionQueue(denominator, numerator);
            n = -n;
        }

        // Repeated multiplication using multiply()
        for (int i = 0; i < n; i++)
        {
            result = result.multiply(base);
        }

        return result;

    }

    @Override
    public String toString()
    {
        // Whole number case
        if (denominator == 1)
        {
            return Long.toString(numerator);
        }

        // Special undefined cases
        if (denominator == 0 && numerator > 0)
        {
            return "Infinity";
        }

        if (denominator == 0 && numerator < 0)
        {
            return "-Infinity";
        }

        if (denominator == 0 && numerator == 0)
        {
            return "NaN";
        }

        // Normal fraction case
        return numerator + "/" + denominator;
    }
    
}
