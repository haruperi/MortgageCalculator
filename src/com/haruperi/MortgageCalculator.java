package com.haruperi;

public class MortgageCalculator {
    private final int principal;
    private final float monthlyInterest;
    private final int numberOfPayments;

    public MortgageCalculator(int principal, float monthlyInterest, int numberOfPayments) {
        this.principal = principal;
        this.monthlyInterest = monthlyInterest;
        this.numberOfPayments = numberOfPayments;
    }

    public double calculateMortgage() {
        return principal *
                (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                / ( Math.pow(1+monthlyInterest,numberOfPayments) -1);
    }

    public double calculateBalance( short numberOfPaymentsMade) {
        return principal *
                (Math.pow(1+monthlyInterest,numberOfPayments) - Math.pow(1+monthlyInterest,numberOfPaymentsMade))
                / ( Math.pow(1+monthlyInterest,numberOfPayments) -1);
    }
}
