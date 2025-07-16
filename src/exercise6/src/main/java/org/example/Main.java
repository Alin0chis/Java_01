package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        double[] arrNumbers = input();
        output(insertionSort(arrNumbers));
    }

    private static double[] input() {
        Scanner scanner = new Scanner(System.in);
        int count;
        while (true) {
            try {
                count = scanner.nextInt();
                if (count > 0) {
                    break;
                } else {
                    System.out.println("Input error. Size <= 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.next();
            }
        }

        double[] arrNumbers = new double[count];
        while (true) {
            try {
                for (int i = 0; i < arrNumbers.length; i++) {
                    arrNumbers[i] = scanner.nextDouble();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.next();
            }
        }
        return arrNumbers;
    }

    private static double[] insertionSort(double[] arrNumbers) {
        int j;
        for (int i = 1; i < arrNumbers.length; i++) {
            double swap = arrNumbers[i];
            for (j = i; j > 0 && swap < arrNumbers[j - 1]; j--) {
                arrNumbers[j] = arrNumbers[j - 1];
            }
            arrNumbers[j] = swap;
        }
        return arrNumbers;
    }

    private static void output(double[] arrNumbers) {
        for (double v : arrNumbers) {
            System.out.print(v + " ");
        }
    }
}