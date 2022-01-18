package com.haruperi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final DecimalFormat toFixed2 = new DecimalFormat("0.00");

        System.out.println("Welcome to The Bank Mortgage Calculator!!!");

        System.out.println("Enter the loan amount (P) or principal: ");
        int principal = scanner.nextInt();

        System.out.println("Enter interest rate: ");
        float interest  = (scanner.nextFloat())/ PERCENT / MONTHS_IN_YEAR;

        System.out.println("Enter number of years: ");
        byte years  = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double payment = principal *
                                    (interest * Math.pow(1+interest,numberOfPayments))
                                    / ( Math.pow(1+interest,numberOfPayments) -1);

        System.out.println("Your monthly payment is: $"+toFixed2.format(payment));


    }
}
