package com.haruperi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final DecimalFormat toFixed2 = new DecimalFormat("0.00");

        System.out.println("Welcome to The Bank Mortgage Calculator!!!");
        int principal = (int) readNumber("Enter the loan amount (P) or principal: ", 1000, 1_000_000);
        float monthlyInterest  = (float) readNumber("Enter interest rate: ", 0, 30) / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = (byte) readNumber("Enter number of years: ", 0, 30) * MONTHS_IN_YEAR;

        System.out.println("Your monthly payment is: $"+toFixed2.format(calculateMortgage(principal, monthlyInterest,numberOfPayments)));

    }

    public static double readNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        System.out.println(prompt);
        while (true) {
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                 break;
                System.out.println("Enter a Value Between "+min+ " and "+max);
        }
        return value;
    }

    public static double calculateMortgage (int principal, float monthlyInterest, int numberOfPayments) {
        return principal *
                (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                / ( Math.pow(1+monthlyInterest,numberOfPayments) -1);
    }


}
