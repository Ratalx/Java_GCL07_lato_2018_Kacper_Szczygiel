package com.example.calculator.logic;

import com.example.calculator.basic.ExtendedCalculator;

import java.util.Scanner;

public class ExtendedCircleCalculatro extends CircleCalculator implements ExtendedCalculator {

    public void calculateArea() throws Exception {
        System.out.println("Podaj dlugosc promienia");
        Scanner reader = new Scanner(System.in);
        double r=reader.nextDouble();
        System.out.print(3.14*r*r);
    }
}
