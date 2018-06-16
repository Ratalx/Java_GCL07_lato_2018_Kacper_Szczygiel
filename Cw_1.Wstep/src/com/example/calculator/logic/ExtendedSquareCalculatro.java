package com.example.calculator.logic;

import com.example.calculator.basic.ExtendedCalculator;

import java.util.Scanner;

public class ExtendedSquareCalculatro extends SquareCalculator implements ExtendedCalculator {
    public void calculateArea() throws Exception {
        System.out.println("Podaj dlugos boku a");
        Scanner reader = new Scanner(System.in);
        double a=reader.nextDouble();
        System.out.print(a*a);
    }
}
