import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        final byte months = 12;
        final byte percent = 100;

        int principal = 0;
        float monthlyInterestRate = 0;
        int numberOfPayments = 0;

        byte period = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value Between $1000 and $1000000.");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / percent / months;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");

        }

        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextByte();
            if (period >= 1 && period <= 30) {
                numberOfPayments = period * months;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }
        double mortgage =
                principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, period) / Math.pow(1 + monthlyInterestRate , period) - 1;

        String finalMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Your Mortgage will be: " + finalMortgage);





    }





}
