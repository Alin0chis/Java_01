package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arrNumber = input();
        arithmeticMean(arrNumber);
    }

    private static int[] input() {
        Scanner scanner = new Scanner(System.in);
        int count;
        int[] arrNumber;

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

        arrNumber = new int[count];
        for (int i = 0; i < count; i++) {
            while (true) {
                try {
                    arrNumber[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Couldn't parse a number. Please, try again");
                    scanner.next();
                }
            }
        }
        return arrNumber;
    }

    private static void arithmeticMean(int[] arrNumber) {
        int flag = 0;
        int sum = 0;
        for (int j : arrNumber) {
            if (j < 0) {
                sum += j;
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("There are no negative elements");
        } else {
            System.out.println(sum / flag);
        }
    }
}