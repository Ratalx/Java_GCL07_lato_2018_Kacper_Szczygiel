package com.example.calculator.logic;

import com.example.calculator.basic.Calculator;

import java.util.Scanner;

public class CircleCalculator implements Calculator {

    public double calculatePerimeter() {
        System.out.println("Podaj dlugosc promienia");
        Scanner reader = new Scanner(System.in);
        double r=reader.nextDouble();
        return (2*r*3.14);
    }
}
