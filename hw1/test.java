

public class test {

    private static final int[][] brackets =
        {{8350, 33950, 82250, 171550, 372950}, // Single filer
        {16700, 67900, 137050, 20885, 372950}, // Married jointly// -or qualifying widow(er)
        {8350, 33950, 68525, 104425, 186475},  // Mariied filing separately
        {11950, 45500, 117450, 190200, 372950} // Head of the household
    };
    private static final double[] rates = {0.1, 0.15, 0.24, 0.28, 0.33, 0.35};
    public static void main(String[] args) {
        double tax;
tax = brackets[0][0] * rates[0];
tax+= (brackets[0][1] - brackets[0][0]) * rates[1] ;
tax+= (brackets[0][2] - brackets[0][1]) * rates[2];
tax+= (brackets[0][3] - brackets[0][2]) * rates[3] ;
tax+= (brackets[0][4] - brackets[0][3]) * rates[4];
tax+= (400000 - brackets[0][4]) * rates[5];
System.out.println(tax);
}
}