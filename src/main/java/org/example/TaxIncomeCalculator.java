package org.example;

public class TaxIncomeCalculator {

    private final double assPersonalAllowance = 12570.00;
    private double yourPersonalAllowance = 12570.00;
    private double taxToPay = 0;
    private double incomeAfterTax = 0;
    private double basicRateTax = 0;
    private double higherRateTax = 0;
    private double addRateTax = 0;

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

        personalTaxDeductions(taxIncome);

        if (assPersonalAllowance < taxIncome && taxIncome < higherRateUpperLimit) {
            taxableFundsBR = taxIncome - higherRateLowerLimit;

        } else {
            taxableFundsBR = higherRateUpperLimit - higherRateLowerLimit;
        }

        higherRateTax = 0.4 * taxableFundsBR;

        System.out.println("The tax you have to pay in the additional rate is: " + higherRateTax);
        System.out.println("Your personal allowance: " + yourPersonalAllowance);
    }

    // Method to return higher tax rate
    public void addRateTax(double taxIncome) {
        double addRateLowerLimit = 125140.00;
        double taxableFundsBR = 0;


        personalTaxDeductions(taxIncome);

        if (assPersonalAllowance < taxIncome && taxIncome > addRateLowerLimit) {
            taxableFundsBR = taxIncome - addRateLowerLimit;

        } else {
            return;
        }

        addRateTax = 0.45 * taxableFundsBR;

        System.out.println("The tax you have to pay in the additional rate is: " + addRateTax);
        System.out.println("Your personal allowance: " + yourPersonalAllowance);
    }

    // Method to calculate total tax leftover + tax you need to pay
    public void ReturnTaxAndIncome(double taxIncome) {

        basicRateTax(taxIncome);
        addRateTax(taxIncome);
        higherRateTax(taxIncome);

        taxToPay = basicRateTax +  addRateTax + higherRateTax;
        incomeAfterTax = taxIncome - taxToPay;

        System.out.println("The total tax you have to pay is: " + taxToPay);
        System.out.println("Your remaining income after tax is: " + incomeAfterTax);
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
        } else if (taxIncome > 125140.00) {
            yourPersonalAllowance = 0;
            personalAllowanceDeductions = 0;
        } else {
            taxIncrease = taxIncome - 100000;
            personalAllowanceDeductions = taxIncrease/2;
        }

        yourPersonalAllowance = yourPersonalAllowance - personalAllowanceDeductions;
    }
}
