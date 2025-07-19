package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        double[] x = new double[3];
        double[] y = new double[3];
        input(x, y);
        if (isThisTriangle(x, y)) {
            System.out.printf("%.3f", perimeterTriangle(x, y));
        }
    }

    private static void input(double[] x, double[] y) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            try {
                x[i] = scanner.nextDouble();
                y[i] = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.next();
                i--;
            }
        }
    }

    private static boolean isThisTriangle(double[] x, double[] y) {
        boolean isTriangle = false;
        if ((x[0] == x[1] && y[0] == y[1]) ||
                (x[0] == x[2] && y[0] == y[2]) ||
                (x[1] == x[2] && y[1] == y[2]) || ((x[1] - x[0]) * (y[2] - y[0]) == (y[1] - y[0]) * (x[2] - x[0]))) {
            System.out.print("It isn't triangle");
        } else {
            isTriangle = true;
        }
        return isTriangle;
    }

    private static double perimeterTriangle(double[] x, double[] y) {
        double AB = lengthCalculation(x[0], x[1], y[0], y[1]);
        double BC = lengthCalculation(x[1], x[2], y[1], y[2]);
        double AC = lengthCalculation(x[0], x[2], y[0], y[2]);
        return AB + AC + BC;
    }

    private static double lengthCalculation(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
    }
}