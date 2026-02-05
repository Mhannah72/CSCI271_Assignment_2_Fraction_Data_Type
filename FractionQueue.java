public class FractionQueue implements Fraction {

    private long numerator;
    private long denominator;

    // Constructors

    public FractionQueue(long num, long denom) 
    {
        if (denom == 0)
        {
            numerator = num;
            denominator = 0;
        }
        else if (num == 0)
        {
            numerator = 0;
            denominator = 1;
        }
        else {
            if (denom < 0)
            {
                num = -num;
                denom = -denom;

            }
            long g = gcd(num, denom);
            numerator = num / g;
            denominator = denom / g;

        }
    }

    private static long gcd(long a, long b)
    {
        long remainder;

        if (a < 0) a = -a;
        if (b < 0) b = -b;

        while (b != 0)
        {
            remainder = a % b;
            a = b;
            b = remainder;
        }

        if (a == 0) return 1;
        return a;
    }


    public long getNumerator()
    {
        return numerator;
    }

    public long getDenominator()
    {
        return denominator;
    }

    

    public Fraction add(Fraction f)
    {
        return new FractionQueue(this.numerator * f.getDenominator() + f.getNumerator() * this.denominator, this.denominator * f.getDenominator());
    }

    public Fraction subtract(Fraction f)
    {
        return new FractionQueue(this.numerator * f.getDenominator() - f.getNumerator() * this.denominator, denominator * f.getDenominator()); 
    }

      public Fraction multiply(Fraction f)
    {
        return new FractionQueue(numerator * f.getNumerator(), denominator * f.getDenominator());
    }

    public Fraction divide(Fraction f)
    {
        return new FractionQueue(numerator * f.getDenominator(), denominator * f.getDenominator()); // Reciprocal multiplication, numerator and denominator are flipped
    }

    public Fraction negate()
    {
        return new FractionQueue(-numerator, denominator);
    }


    public Fraction pow(int n)
    {
        long num = numerator;
        long denom = denominator;
        long newNum = 1;
        long newDenom = 1;
        

        if (n == 0)
        {
            return new FractionQueue(1,1);
        }


        for (int i = 0; i < n; i++)
        {
            newNum *= num;
            newDenom *= denom;
        }

        if (n < 0)
        {
            long temp = num;
            num = denom;
            denom = temp;
        }

        return new FractionQueue(newNum, newDenom);

    }

    @Override
    public String toString()
    {
        String output = "";
        
        if (denominator == 1)
        {
            output = Long.toString(numerator);
        }

        else if (denominator == 0 && numerator > 0)
        {
            output = "Infinity";
        }

        else if (denominator == 0 && numerator < 0)
        {
            output = "-Infinity";
        }

        else if (denominator == 0 && numerator == 0)
        {
            output = "NaN";
        }

        else if (denominator < 0 || numerator < 0)
        {
            output = + numerator + "/" + denominator;
        }

        return output;
    }

    
}
