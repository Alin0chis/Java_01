package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arrNumber = input();
        int[] newArr = makeNewArray(arrNumber);
        if (newArr.length == 0) {
            System.out.print("There are no such elements");
        } else {
            output(newArr);
        }
    }

    private static int[] input() {
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
                System.out.print("Couldn't parse a number. Please, try again");
                scanner.next();
            }
        }

        int[] arrNumber = new int[count];
        for (int i = 0; i < count; i++) {
            while (true) {
                try {
                    arrNumber[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Couldn't parse a number. Please, try again");
                    scanner.next();
                }
            }

        }

        return arrNumber;
    }

    private static int[] makeNewArray(int[] arrNumber) {
        int i = 0;
        for (int num : arrNumber) {
            if (isNumbersMatch(num))
                i++;
        }
        int[] newArr = new int[i];
        int j = 0;
        for (int num : arrNumber) {
            if (isNumbersMatch(num)) {
                newArr[j++] = num;
            }
        }
        return newArr;
    }

    private static boolean isNumbersMatch(int num) {
        if (num < 0)
            num = -num;

        int last = num % 10;

        int first = num;
        while (first >= 10) {
            first /= 10;
        }
        return first == last;
    }

    private static void output(int[] arrNumber) {
        for (int j : arrNumber) {
            System.out.print(j + " ");
        }
    }
}