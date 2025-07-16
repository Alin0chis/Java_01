package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static final int MAX_NUMBER = 46;

    public static void main(String[] args) {
        int num = input();
        if (num > MAX_NUMBER) {
            System.out.println("Too large n");
        } else {
            System.out.println(fibonacciSearch(num));
        }
    }

    private static int input() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.next();
            }
        }
    }

    private static int fibonacciSearch(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciSearch(n - 1) + fibonacciSearch(n - 2);
    }
}