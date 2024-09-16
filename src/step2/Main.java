package step2;

import java.text.DecimalFormat;
/**
 * محسابه سود بدون کسر از پول در هر سال
 */
public class Main {
    public static void main(String args[]) {
        // # Initial parameters
        int P = 6_00_000_000; // # Initial investment (in Toman)
        double r = 0.40; // # Annual interest rate (40%)
        int n = 4; // # Number of compounding periods per year
        int t = 1; // # Number of years
        int year = 1403;

        System.out.println("\n\n\n\n\n");

        calc(572_000_000, 0.40, 4, 1, 1403);

        System.out.println("\n\n\n\n\n");

        calc(1_000_000_000, 0.40, 4, 1, 1403);

    }

    public static void calc(int P, double r, int n, int t, int year) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        String priceFormat = formatter.format(P);
        //# Compound interest formula
        System.out.println(STR."\{year} \{priceFormat} Toman");
        double intPrice = P;
        while (t < 31) {
            double A = 1 + r / n;
            double pow = Math.pow(A, n * t);
            double result = pow * P;
            double sood = result - intPrice;
            sood = (long) sood;
            String soodFormat = formatter.format(sood);
            intPrice = result;
            // Convert to a long to remove decimals
            long finalAmount = (long) result;

            // Format the number with commas
            priceFormat = formatter.format(finalAmount);
            System.out.println(STR."\{++year} \{priceFormat} Toman ....-> sood = \{soodFormat} Toman");
            t++;
        }
    }
}

