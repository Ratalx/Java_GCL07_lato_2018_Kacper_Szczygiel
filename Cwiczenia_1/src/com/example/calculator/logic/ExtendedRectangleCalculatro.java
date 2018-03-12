package com.example.calculator.logic;

import com.example.calculator.basic.ExtendedCalculator;

import java.util.Scanner;

public class ExtendedRectangleCalculatro extends RectangleCalculator implements ExtendedCalculator {

    public void calculateArea() throws Exception {
        System.out.println("Podaj dlugosc boku a");
        Scanner reader = new Scanner(System.in);
        double a=reader.nextDouble();
        System.out.println("Podaj dlugosc boku  b");
        double b = reader.nextDouble();
        System.out.print(a*b);
    }
}
