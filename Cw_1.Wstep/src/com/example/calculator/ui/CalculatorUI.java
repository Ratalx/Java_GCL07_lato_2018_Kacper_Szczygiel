package com.example.calculator.ui;

import com.example.calculator.basic.Calculator;
import com.example.calculator.basic.ExtendedCalculator;
import com.example.calculator.logic.*;

import java.util.Scanner;

public class CalculatorUI {
    public  static void main(String args[])  {
        while (true){
            System.out.println("\n1.Oblicz obwod kwadratu\n2.Oblicz obwod kola\n3.Oblicz obwod trojkata\n4.Oblicz obwod prostokata \n5.Oblicz pole kwadratu\n6.Oblicz pole kola\n7.Oblicz pole trojkata\n8.Oblicz pole prostokata \n 0.Exit ");
            Scanner reader=new Scanner(System.in);
            ExtendedCalculator extendedCalculator;
            Calculator calculator;
            int choice = reader.nextInt();
            try {


                switch (choice) {
                    case 1:
                        calculator = new SquareCalculator();
                        System.out.print(calculator.calculatePerimeter());
                        break;
                    case 2:
                        calculator = new CircleCalculator();
                        System.out.print(calculator.calculatePerimeter());
                        break;
                    case 3:
                        calculator = new TriangleCalculator();
                        System.out.print(calculator.calculatePerimeter());
                        break;
                    case 4:
                        calculator = new RectangleCalculator();
                        System.out.print(calculator.calculatePerimeter());
                        break;
                    case 5:
                        extendedCalculator = new ExtendedSquareCalculatro();
                        extendedCalculator.calculateArea();
                        break;
                    case 6:
                        extendedCalculator = new ExtendedCircleCalculatro();
                        extendedCalculator.calculateArea();
                        break;
                    case 7:
                        extendedCalculator = new ExtendedTriangleCalculator();
                        extendedCalculator.calculateArea();
                        break;
                    case 8:
                        extendedCalculator = new ExtendedRectangleCalculatro();
                        extendedCalculator.calculateArea();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Bledny wybor");


                }
            }
            catch (Exception e){
                System.out.println("Blad Operacji");
            }


        }
    }
}
