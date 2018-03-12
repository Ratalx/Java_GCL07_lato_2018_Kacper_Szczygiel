package com.example.calculator.logic;

import com.example.calculator.basic.ExtendedCalculator;

import java.util.Scanner;

public class ExtendedTriangleCalculator extends TriangleCalculator implements ExtendedCalculator {
    public void calculateArea() throws Exception {
        System.out.println("Podaj wysokosc h");
        Scanner reader = new Scanner(System.in);
        double h=reader.nextDouble();
        System.out.println("Podaj podstawe a  ");
        double a = reader.nextDouble();
        System.out.print(0.5*a*h);
    }
}
