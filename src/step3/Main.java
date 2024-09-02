package step3;

import java.text.DecimalFormat;

/**
 * محاسبه با کسر مقداری از پول در هر سال و لحاظ نرخ رشد در هر سال
 */
public class Main {
    public static void main(String args[]) {
        // # Initial parameters
        long P = 5_00_000_000; // # Initial investment (in Toman)
        double r = 0.40; // # Annual interest rate (40%)
        int n = 4; // # Number of compounding periods per year
        int t = 1; // # Number of years
        int year = 1403;

        System.out.println("\n\n\n\n\n");

        calc(572_000_000L, 0.40, 4, 30, 1403, 100_000_000, 30_000_000);

        System.out.println("\n\n\n\n\n");


        calc(1_000_000_000L, 0.40, 4, 30, 1403, 100_000_000, 20_000_000);

        System.out.println("\n\n\n\n\n");


    }

    public static void calc(long P, double rate, int n, int t, int year, int bardasht, int nerkheRoshd) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        String priceFormat = formatter.format(P);
        //# Compound interest formula
        System.out.println(STR."\{year} \{priceFormat} Toman");
        double nextPrice = P;
        int years = 1;
        while (years < t) {
            double result = getResultPerYear(nextPrice, rate);
            double sood = result - nextPrice;

            if (bardasht != 0) {
                if (years > 1) {
                    bardasht = bardasht + nerkheRoshd;
                }

                nextPrice = result - bardasht;

            } else {
                nextPrice = result;
            }

            sood = (long) sood;
            String soodFormat = formatter.format(sood);

            // Convert to a long to remove decimals
            long finalAmount = (long) result;

            // Format the number with commas
            priceFormat = formatter.format(finalAmount);
            System.out.println();
            System.out.println(STR."\{++year} \{priceFormat} Toman ....-> sood = \{soodFormat} Toman   bardasht ...-> \{formatter.format(bardasht)}");
            String nextPriceFormat = formatter.format(nextPrice);

            System.out.println(STR." nextPrice \{nextPriceFormat}");
            years++;
        }
    }

    private static double getResultPerYear(double P, double r) {
        double A = 1 + r / 4;
        double pow = Math.pow(A, 4);
        return pow * P;
    }
}

