
import java.util.Scanner;

public class ComputeTax {
    private static Scanner sc = new Scanner(System.in);
    private static int status;
    // private static final incomeRates[] = {};
    private static final int[][] brackets =
        {{8350, 33950, 82250, 171550, 372950}, // Single filer
        {16700, 67900, 137050, 20885, 372950}, // Married jointly// -or qualifying widow(er)
        {8350, 33950, 68525, 104425, 186475},  // Mariied filing separately
        {11950, 45500, 117450, 190200, 372950} // Head of the household
    };
    private static final double[] rates = {0.1, 0.15, 0.24, 0.28, 0.33, 0.35};
    private static double income;
    private static double tax = 0;

    public static void main(String[] args) {

        getStatus();
        getIncome();
        taxable();
        System.out.println("Tax is $" + tax);
        //  ANSWER FOR STATUS: 0, INCOME: 400,000.00 IS 117200.50 !!!!!!
        
    }

    public static void taxable() {
        int x = status;
        if(income <= brackets[x][0]) {
            tax = brackets[x][0]*rates[0];
        } else if(income <= brackets[x][1]) {
            tax = (brackets[x][0]*rates[0]) + (income - brackets[x][0]) * rates[0];
        } else if(income <= brackets[x][2]) {
            tax = (brackets[x][0]*rates[0]) + (brackets[x][1] - brackets[x][0]) * rates[1] + (income - brackets[x][1]) * rates[1];
        } else if(income <= brackets[x][3]) {
            tax = (brackets[x][0]*rates[0]) + (brackets[x][1] - brackets[x][0]) * rates[1] + (brackets[x][2] - brackets[x][1]) * rates[2] + (income - brackets[x][3]) * rates[3];
        } else if(income <= brackets[x][4]) {
            tax = (brackets[x][0]*rates[0]) + (brackets[x][1] - brackets[x][0]) * rates[1] + (brackets[x][2] - brackets[x][1]) * rates[2] + (brackets[x][3] - brackets[x][2]) * rates[3] + (income - brackets[x][3]) * rates[4];
        } else {
            tax = (brackets[x][0]*rates[0]) + (brackets[x][1] - brackets[x][0]) * rates[1] + (brackets[x][2] - brackets[x][1]) * rates[2] + (brackets[x][3] - brackets[x][2]) * rates[3] + (brackets[x][4] - brackets[x][3]) * rates[4] + (income - brackets[x][4]) * rates[5];
        }
    }

    public static void getStatus() {
        while(true) {
            System.out.println("Filing Status:\n"
            +                "(0): Single Filer\n"
            +                "(1): Married jointly \n"
            +                "(2): Qualifying Widow(er)\n"
            +                "(3): Married filing separately\n"
            +                "(4): head of household\n");
            status = sc.nextInt();

            if(status < 0 || status > 4) {
                System.out.println("The filing status you entered was an incorrect option! Try again!");
                continue;
            }
            break;
        }
    }

    public static void getIncome() {
        System.out.print("Enter the taxable income: ");
        income = sc.nextDouble();
    } 
}