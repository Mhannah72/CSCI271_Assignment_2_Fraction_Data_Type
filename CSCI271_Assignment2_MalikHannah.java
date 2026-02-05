import java.io.*;


public class CSCI271_Assignment2_MalikHannah {

    public static void main (String [] args)
    {
        System.out.println("FRACTION CLASS TESTING\n");

        /* =====================================================
           Task 1: Fraction reduction test
           ===================================================== */

        System.out.println("1. Constructor normalization tests");

        Fraction f1 = new FractionQueue(6, -24);    // Creates a fraction of numerator = -1 and denominator = 4
        Fraction f2 = new FractionQueue(0, 8);  // Creatres a fraction of numerator = 0, denominator = 1 (not 8)
        Fraction f3 = new FractionQueue(8, -6);     

        System.out.println("    new Fraction(6, -24) = " + f1);
        System.out.println("    new Fraction(0, 8) = " + f2);
        System.out.println("    new Fraction(8, -6) = " + f3);

        /* =====================================================
           Task 2: toString implementation
           ===================================================== */

        System.out.println("2. toString() special values:");
        Fraction f4 = new FractionQueue(8, -6);  // fr.toString() is "4/3"
        Fraction f5 = new FractionQueue(23, 0);  // fr.toString() is "Infinity"
        Fraction f6 = new FractionQueue(-6, 0);  // fr.toString() is "-Infinity"
        Fraction f7 =  new FractionQueue(7, 1);   // fr.toString() is "7" (not "7/1")
        Fraction f8 = new FractionQueue(0,0);    // fr.toString() is "NaN"

        System.out.println("    new Fraction(8, -6) = " + f4);
        System.out.println("    new Fraction(23, 0) = " + f5);
        System.out.println("    new Fraction(-6, 0) = " + f6);
        System.out.println("    new Fraction(7, 1) = " + f7);
        System.out.println("    newFraction(0, 0) = " + f8);

        /* ======================================================
           Task 3: Implementation of various methods (divide, multiply, subtract, add, negate, pow)
           ====================================================== */


        System.out.println("3. Division tests: ");

        Fraction d1 = new FractionQueue(5,6);
        Fraction d2 = new FractionQueue(2, 3);
        System.out.println("    5/6 / 2/3 = " + d1.divide(d2));

        Fraction d3 = new FractionQueue(1,2);
        Fraction d4 = new FractionQueue(0, 1);
        System.out.println("    1/2 / 0/1 = " + d3.divide(d4));


        System.out.println("4. Multiplication tests: ");

        Fraction m1 = new FractionQueue(5, 6);
        Fraction m2 = new FractionQueue(2, 3);
        System.out.println("  5/6 * 2/3 = " + m1.multiply(m2));

        Fraction m3 = new FractionQueue(1, 2);
        Fraction m4 = new FractionQueue(0, 1);
        System.out.println("  1/2 * 0/1 = " + m3.multiply(m4));

        


        System.out.println("8. Power tests:");

        Fraction p1 = new FractionQueue(2, 3);
        System.out.println("    (2/3)^2 = " + p1.pow(2));
        System.out.println("    (2/3)^0 = " + p1.pow(0));
        System.out.println("    (2/3)^-2 = " + p1.pow(-2));




        /* =================================================== 
            Assi
           =================================================== */
        System.out.println("9. Assignment Example:");

        /*Fraction a = new FractionQueue(16);
        Fraction b = new FractionQueue(3,5).add(new FractionQueue(7));
        Fraction c = new FractionQueue(6, 7);
        Fraction result = c.multiply(a.divide(b));

        System.out.println("    Result = " + result);

*/


        

        

        


    }

    
}
