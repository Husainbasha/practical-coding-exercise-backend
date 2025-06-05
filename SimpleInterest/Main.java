import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input principal and rate
        System.out.print("Enter Principal Amount (P): ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Rate of Interest (R per annum): ");
        double rate = scanner.nextDouble();

        // Input start and end dates
        System.out.print("Enter Start Date (yyyy-mm-dd): ");
        String startDateStr = scanner.next();

        System.out.print("Enter End Date (yyyy-mm-dd): ");
        String endDateStr = scanner.next();

        // Convert to LocalDate
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        // Calculate duration
        Period period = Period.between(startDate, endDate);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        // Calculate interest for each time unit
        double interestYears = (principal * rate * years) / 100;
        double interestMonths = (principal * rate * (months / 12.0)) / 100;
        double interestDays = (principal * rate * (days / 365.0)) / 100;

        double totalInterest = interestYears + interestMonths + interestDays;
        double totalAmount = principal + totalInterest;

        // Output results

        System.out.println("Years : " + years);
        System.out.println("Months: " + months);
        System.out.println("Days  : " + days);

        System.out.println("\n--- Interest Breakdown ---");
        System.out.printf("Interest for Years : ₹%.2f\n", interestYears);
        System.out.printf("Interest for Months: ₹%.2f\n", interestMonths);
        System.out.printf("Interest for Days  : ₹%.2f\n", interestDays);
        System.out.printf("Total Interest     : ₹%.2f\n", totalInterest);
        System.out.printf("Total Amount       : ₹%.2f\n", totalAmount);

        scanner.close();
    }
}
