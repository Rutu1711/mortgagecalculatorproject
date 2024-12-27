import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Scanner;
import java.text.NumberFormat;
public class Main {
    public static void main(String[]args) {

        Scanner scanner = new Scanner(System.in);
        NumberFormat.getCurrencyInstance();
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        final byte percent = 100;
        final byte noOfMonths = 12;
        int principal = 0;
        double rateOfInterest = 0;
        double time = 0;

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();

            if (principal >= 10_000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a value between $10000 and $1000000");
        }

        while (true) {
            System.out.print("Time(years): ");
            time = scanner.nextDouble();

            if (time >= 1 && time <= 30) {
                break;
            }
            System.out.println("Enter value between 1 and 30!");
        }

        while (true) {
            System.out.print("Rate of interest: ");
            rateOfInterest = scanner.nextDouble();

            if (rateOfInterest > 0) {
                break;
            }
            System.out.println("Enter a value greater than zero.");
        }
        double numerator = (principal*rateOfInterest*Math.pow((percent+rateOfInterest)/
                rateOfInterest, time/noOfMonths)) / percent;

        double denominator = (Math.pow((percent+rateOfInterest)/percent, time/noOfMonths)) - 1;
        double mortgage = (numerator / denominator);

        System.out.print("Mortgage: " +currency.format(Math.round(mortgage)));
    }
}