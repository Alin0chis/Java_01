package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> arrUser = inputUser();
        List<User> userSort = arrUser.stream()
                .filter(user -> user.getAge() > 18)
                .toList();
        for (int i = 0; i < userSort.size(); i++) {
            System.out.print(userSort.get(i).getName());
            if (i != userSort.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private static ArrayList<User> inputUser() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> arrUser = new ArrayList<>();
        int count = 0;
        while (true) {
            try {
                count = scanner.nextInt();
                scanner.nextLine();
                if (count > 0) {
                    break;
                } else {
                    System.out.println("Couldn't parse a number. Please, try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.next();
            }
        }

        for (int i = 0; i < count; i++) {
            String name = null;
            int age = 0;
            while (true) {
                try {
                    name = scanner.nextLine();
                    age = scanner.nextInt();
                    scanner.nextLine();
                    if (age > 0) {
                        break;
                    } else {
                        System.out.println("Incorrect input. Age <= 0");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect input. Age <= 0");
                    scanner.next();
                }
            }
            arrUser.add(new User(name, age));
        }
        return arrUser;
    }
}