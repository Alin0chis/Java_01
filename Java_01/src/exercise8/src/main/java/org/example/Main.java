package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        input();
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int previous = 0;
        while (true) {
            try {
                int current = scanner.nextInt();
                if (count != 0 && current < previous) {
                    System.out.print("The sequence is not ordered from the ordinal number of the number " + count);
                    break;
                }
                previous = current;
                count++;
            } catch (InputMismatchException e) {
                if (count == 0) {
                    System.out.print("Input error");
                } else {
                    System.out.print("The sequence is ordered in ascending order");
                }
                break;
            }
        }
    }
}