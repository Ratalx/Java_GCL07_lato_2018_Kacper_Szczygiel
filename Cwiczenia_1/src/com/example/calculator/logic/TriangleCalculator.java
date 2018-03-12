package com.example.calculator.logic;

import com.example.calculator.basic.Calculator;

import java.util.Scanner;

public class TriangleCalculator implements Calculator {

    public double calculatePerimeter() {
        System.out.println("Podaj bok a");
        Scanner reader = new Scanner(System.in);
        double a=reader.nextDouble();
        System.out.println("Podaj bok b ");
        double b = reader.nextDouble();
        System.out.println("Podaj bok c ");
        double c = reader.nextDouble();
        return (a+b+c);
    }
}
