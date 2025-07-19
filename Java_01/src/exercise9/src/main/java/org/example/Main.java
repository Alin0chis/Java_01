package org.example;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> arrStr = input();
        print(filterStrings(arrStr));
    }

    private static ArrayList<String> input() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrStr = new ArrayList<>();
        while (true) {
            try {
                int count = scanner.nextInt();
                scanner.nextLine();
                if (count > 0) {
                    for (int i = 0; i < count; i++) {
                        arrStr.add(scanner.nextLine());
                    }
                    //strFilter = scanner.nextLine();
                    arrStr.add(scanner.nextLine());
                } else {
                    System.out.print("Input error. Size <= 0");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.next();
            }
        }
        return arrStr;
    }

    private static ArrayList<String> filterStrings(ArrayList<String> arrStr) {
        ArrayList<String> result = new ArrayList<>();
        for (String str : arrStr) {
            if (str.contains(arrStr.get(arrStr.size() - 1))) {
                result.add(str);
            }
        }
        return result;
    }

    private static void print(ArrayList<String> arrResult) {
        for (int i = 0; i < arrResult.size() - 1; i++) {
            System.out.print(arrResult.get(i));
            if (i < arrResult.size() - 2) {
                System.out.print(", ");
            }
        }
    }
}