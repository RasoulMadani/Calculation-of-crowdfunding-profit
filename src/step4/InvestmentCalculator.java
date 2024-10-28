package step4;


import java.text.DecimalFormat;

public class InvestmentCalculator {
    public static void main(String[] args) {
        // پارامترهای اولیه
        long initialInvestment = 1_000_000_000; // سرمایه‌گذاری اولیه (به تومان)
        double quarterlyRate = 0.10; // نرخ سود سه ماهه (10%)
        int totalYears = 30; // تعداد سال‌ها
        long monthlyContribution = 3_0_000_000L; // مبلغ ماهانه‌ای که اضافه می‌شود (به تومان)

        // محاسبه تعداد ماه‌ها
        int totalMonths = totalYears * 12;

        // مقدار اولیه سرمایه‌گذاری
        double totalValue = initialInvestment;

        // حلقه برای محاسبه هر ماه
        for (int month = 1; month <= totalMonths; month++) {
            // افزودن مبلغ ماهانه
            totalValue += monthlyContribution;

            // اعمال سود هر سه ماه یک بار
            if (month % 3 == 0) {
                totalValue *= (1 + quarterlyRate);
            }
            DecimalFormat formatter = new DecimalFormat("#,###");
            String formattedValue = formatter.format(totalValue);
            System.out.println("مقدار نهایی بعد از " + month + " ماه: " + formattedValue + " تومان");
            System.out.println();
        }

        // فرمت خروجی برای نمایش مبلغ نهایی
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedValue = formatter.format(totalValue);
        System.out.println("مقدار نهایی بعد از " + totalYears + " سال: " + formattedValue + " تومان");
    }
}