package com.example.calculator.logic;

import com.example.calculator.basic.Calculator;

import java.util.Scanner;

public class RectangleCalculator implements Calculator {
    public double calculatePerimeter() {
        System.out.println("Podaj dlugosc boku a");
        Scanner reader = new Scanner(System.in);
        double a=reader.nextDouble();
        System.out.println("Podaj dlugosc boku  b");
        double b = reader.nextDouble();
        return (2*a+2*b);
    }
}
