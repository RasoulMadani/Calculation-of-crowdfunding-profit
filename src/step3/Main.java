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
        //615,000,000;
        // الباقی ۳۸۵


        System.out.println("\n\n\n\n\n");

        calc(963_500_000L, 0.43,  30, 1403, 0, 0,1_000_000_000);



        System.out.println("\n\n\n\n\n");

        calc(928_000_000L, 0.42,  30, 1403, 0, 0,0);



        System.out.println("\n\n\n\n\n");

        calc(2_000_000_000L, 0.42,  10, 1403, 0, 0,0);


    }

    public static void calc(long P, double rate, int t, int year, int bardasht, int nerkheRoshd,int afzodan) {
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
            nextPrice = nextPrice + afzodan;

            sood = (long) sood;
            String soodFormat = formatter.format(sood);

            // Convert to a long to remove decimals
            long finalAmount = (long) result;

            // Format the number with commas
            priceFormat = formatter.format(finalAmount);
            System.out.println();
            System.out.println(STR."\{++year} \{priceFormat} Toman ....-> sood = \{soodFormat} Toman   bardasht ...-> \{formatter.format(bardasht)} Toman  afzodan...-> \{formatter.format(afzodan)}");
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

