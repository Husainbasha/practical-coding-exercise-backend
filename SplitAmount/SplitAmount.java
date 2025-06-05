import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the no of person");
        int n=scanner.nextInt();
        double[] spent = new double[n];
        double total = 0;

        // amount spent by each person
        for (int i = 0; i < n; i++) {
            System.out.print("Enter amount spent by Person " + (i + 1) + ": ");
            spent[i] = scanner.nextDouble();
            total += spent[i];
        }

        double average = total / n;
        double[] balance = new double[n];

        // how much each person spent
        System.out.println("\n--- Amount Spent by Each Person ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d spent: ₹%.2f\n", i + 1, spent[i]);
        }

        // Calculate balance (positive = should receive, negative = should pay)
        for (int i = 0; i < n; i++) {
            balance[i] = spent[i] - average;
        }

        // person should pay or receive
        System.out.println("\n--- Balance Summary ---");
        for (int i = 0; i < n; i++) {
            if (balance[i] > 0) {
                System.out.printf("Person %d should receive ₹%.2f\n", i + 1, balance[i]);
            } else if (balance[i] < 0) {
                System.out.printf("Person %d should pay ₹%.2f\n", i + 1, -balance[i]);
            } else {
                System.out.printf("Person %d is settled.\n", i + 1);
            }
        }

        // Settlements
        System.out.println("\n--- Settlements ---");
        for (int i = 0; i < n; i++) {
            if (balance[i] < 0) { // Person i pays
                for (int j = 0; j < 4; j++) {
                    if (balance[j] > 0) { // Person j receives
                        double amount = Math.min(-balance[i], balance[j]);
                        if (amount > 0) {
                            System.out.printf("Person %d pays ₹%.2f to Person %d\n", i + 1, amount, j + 1);
                            balance[i] += amount;
                            balance[j] -= amount;
                            if (balance[i] == 0) break; // Done paying
                        }
                    }
                }
            }
        }

        scanner.close();
    }
}