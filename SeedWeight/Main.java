import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("enter the prise per 100kg:");
                double prise = scanner.nextDouble();
                System.out.println("enter the weight you get from (AV) :");
                double weight = scanner.nextDouble();
                double Actualweight = (weight / 100) * 3;
                double Realweight = weight - Actualweight;
                Double Amount = Realweight * prise / 100;
                System.out.println("Actual weight:" + Actualweight);
                System.out.println("original weight:" + Realweight);
                System.out.println("Actual Amout you get:" + Amount);
        }

}
