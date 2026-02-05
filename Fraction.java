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
