package com.haruperi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float annualInterest = 0;
        byte years  = 0;
        final DecimalFormat toFixed2 = new DecimalFormat("0.00");

        System.out.println("Welcome to The Bank Mortgage Calculator!!!");

        System.out.println("Enter the loan amount (P) or principal: ");
        while (true) {
             principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a Value Between 1000 and 1 000 000");
        }


        System.out.println("Enter interest rate: ");
        while (true) {
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30) {
                break;
            }
            System.out.println("Enter a Value greater than 0 and less than 30");
        }

         float monthlyInterest  = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.println("Enter number of years: ");
        while (true) {
            years  = scanner.nextByte();
            if (years > 0 && years <= 30) {
                break;
            }
            System.out.println("Enter a Value greater than 0 and less than 30");
        }
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double payment = principal *
                                    (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                                    / ( Math.pow(1+monthlyInterest,numberOfPayments) -1);

        System.out.println("Your monthly payment is: $"+toFixed2.format(payment));


    }
}
