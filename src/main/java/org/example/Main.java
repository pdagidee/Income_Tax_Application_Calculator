package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        TaxIncomeCalculator taxIncomeCalculator = new TaxIncomeCalculator();
        System.out.println("Please enter your salary:" + "\n");
        Scanner sc = new Scanner(System.in);
        double userSalary = sc.nextDouble();

        taxIncomeCalculator.returnUnalteredTaxIncome(userSalary);
        taxIncomeCalculator.basicRateTax(userSalary);
        taxIncomeCalculator.higherRateTax(userSalary);

    }
}