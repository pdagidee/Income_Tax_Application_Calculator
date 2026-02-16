package org.example;

public class TaxIncomeCalculator {

    private final double assPersonalAllowance = 12570.00;
    private double yourPersonalAllowance = 12570.00;
    private double totalAmountAfterTax = 0;

    // Method to check if salary is less than personal allowance
    public void returnUnalteredTaxIncome(double taxIncome) {
        if (taxIncome < assPersonalAllowance) {
            System.out.println("Your salary after deductions is: " + taxIncome);
        } else {
            System.out.println("Your salary is above the personal allowance rate");
        }
    }

    // Method: Basic Rate Tax
    public void basicRateTax(double taxIncome) {
        double basicRateLowerLimit = 12571.00;
        double basicRateUpperLimit = 50270.00;
        double taxableFundsBR = 0;
        double basicRateTax = 0;

        if (assPersonalAllowance < taxIncome && taxIncome < basicRateUpperLimit) {
            taxableFundsBR = taxIncome - basicRateLowerLimit;

        } else {
            taxableFundsBR = basicRateUpperLimit - basicRateLowerLimit;
        }

        basicRateTax = 0.2 * taxableFundsBR;

        System.out.println("The tax you have to pay in basic rate is: " + basicRateTax);
    }

    // Method to return additional tax rate
    public void higherRateTax(double taxIncome) {
        double higherRateLowerLimit = 50271.00;
        double higherRateUpperLimit = 125140.00;
        double taxableFundsBR = 0;
        double higerRateTax = 0;

        personalTaxDeductions(taxIncome);

        if (assPersonalAllowance < taxIncome && taxIncome < higherRateUpperLimit) {
            taxableFundsBR = taxIncome - higherRateLowerLimit;

        } else {
            taxableFundsBR = higherRateUpperLimit - higherRateLowerLimit;
        }

        higerRateTax = 0.4 * taxableFundsBR;

        System.out.println("The tax you have to pay in the additional rate is: " + higerRateTax);
        System.out.println("Your personal allowance: " + yourPersonalAllowance);
    }

    // Method to return higher tax rate
    public void addRateTax(double taxIncome) {
        double additionalRateLowerLimit = 50271.00;
        double additionalRateUpperLimit = 125140.00;
        double taxableFundsBR = 0;
        double higerRateTax = 0;

        personalTaxDeductions(taxIncome);

        if (assPersonalAllowance < taxIncome && taxIncome < additionalRateUpperLimit) {
            taxableFundsBR = taxIncome - additionalRateLowerLimit;

        } else {
            taxableFundsBR = additionalRateUpperLimit - additionalRateLowerLimit;
        }

        higerRateTax = 0.4 * taxableFundsBR;

        System.out.println("The tax you have to pay in the additional rate is: " + higerRateTax);
        System.out.println("Your personal allowance: " + yourPersonalAllowance);
    }


    // Method to deduct personal allowance
    public void personalTaxDeductions(double taxIncome) {
        // This method reduces personal tax after certain incomes
        // Your personal allowance goes down by £1 for every £2 that your adjusted net income is above £100,000.
        double taxIncrease = 0;
        double personalAllowanceDeductions = 0;

        // Check if income has reached £100,000

        // Reduce Personal Income by £1 for every £2 added to your ANI=
        if (taxIncome < 100000 || taxIncome == 100000) {
            return;
        } else {
            taxIncrease = taxIncome - 100000;
            personalAllowanceDeductions = taxIncrease/2;
        }

        yourPersonalAllowance = yourPersonalAllowance - personalAllowanceDeductions;
    }
}
