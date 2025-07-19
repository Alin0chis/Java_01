package org.example;


import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countAnimals = inputAnimalsCount(scanner);
        List<Animal> animals = IntStream.range(0, countAnimals)
                .mapToObj(i -> {
                    String typeAnimal = scanner.nextLine();
                    if (!typeAnimal.equals("dog") && !typeAnimal.equals("cat")) {
                        System.out.println("Incorrect input. Unsupported pet type");
                        return null;
                    }
                    String name = scanner.nextLine();
                    int age;
                    try {
                        age = scanner.nextInt();
                        scanner.nextLine();
                        if (age <= 0) {
                            System.out.println("Incorrect input. Age <= 0");
                            return null;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Could not parse a number. Please, try again");
                        scanner.nextLine();
                        return null;
                    }
                    return typeAnimal.equals("dog") ? new Dog(name, age) : new Cat(name, age);
                })
                .filter(Objects::nonNull)
                .toList();

        List<Animal> newAnimalsList = animals.stream()
                .map(Animal::createNewObject)
                .toList();

        newAnimalsList.forEach(System.out::println);
    }

    private static int inputAnimalsCount(Scanner scanner) {
        int countAnimals;
        while (true) {
            try {
                countAnimals = scanner.nextInt();
                scanner.nextLine();
                if (countAnimals <= 0)
                    System.out.println("Incorrect input. Count <= 0");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.nextLine();
            }
        }
        return countAnimals;
    }
}