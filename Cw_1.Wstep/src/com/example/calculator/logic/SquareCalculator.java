package com.example.calculator.logic;

import com.example.calculator.basic.Calculator;

import java.util.Scanner;

public class SquareCalculator implements Calculator {

    public double calculatePerimeter() {
        System.out.println("Podaj dlugos boku a");
        Scanner reader = new Scanner(System.in);
        double a=reader.nextDouble();
        return (4*a);
    }
}
