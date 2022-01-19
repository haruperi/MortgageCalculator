package com.haruperi;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final DecimalFormat toFixed2 = new DecimalFormat("0.00");

        System.out.println("Welcome to The Bank Mortgage Calculator!!!");
        int principal = (int) Console.readNumber("Enter the loan amount (P) or principal: ", 1000, 1_000_000);
        float monthlyInterest  = (float) Console.readNumber("Enter interest rate: ", 0, 30) / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = (byte) Console.readNumber("Enter number of years: ", 0, 30) * MONTHS_IN_YEAR;
        var calculator = new MortgageCalculator(principal, monthlyInterest, numberOfPayments);

        System.out.println("Your monthly payment is: $"+toFixed2.format(calculator.calculateMortgage()));

        System.out.println("The remaining balance is: ");
        for (short month = 1; month <= numberOfPayments ; month++) {
            System.out.print("Month "+month+" : ");
            System.out.println("$"+toFixed2.format(calculator.calculateBalance(month)));
        }
    }


}
