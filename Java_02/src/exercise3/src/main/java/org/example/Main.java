package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        List<Animal> animals = inputAnimals();
        output(animals);
    }

    private static List<Animal> inputAnimals() {
        Scanner scanner = new Scanner(System.in);

        int countAnimals = inputAnimalsCount(scanner);
        List<Animal> animals = new ArrayList<>(countAnimals);

        for (int i = 0; i < countAnimals; i++) {
            String typeAnimal = inputAnimalType(scanner);
            if (typeAnimal == null) continue;

            String name = inputAnimalName(scanner);

            Integer age = inputAnimalAge(scanner);
            if (age == null) continue;

            switch (typeAnimal) {
                case "dog" -> animals.add(new Dog(name, age));
                case "cat" -> animals.add(new Cat(name, age));
                case "hamster" -> animals.add(new Hamster(name, age));
                default -> animals.add(new GuineaPig(name, age));
            }
        }
        return animals;
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

    private static String inputAnimalType(Scanner scanner) {
        String typeAnimal = scanner.nextLine();
        if (!typeAnimal.equals("dog") && !typeAnimal.equals("cat")
                && !typeAnimal.equals("hamster") && !typeAnimal.equals("guinea")) {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }
        return typeAnimal;
    }

    private static String inputAnimalName(Scanner scanner) {
        return scanner.nextLine();
    }

    private static Integer inputAnimalAge(Scanner scanner) {
        try {
            int age = scanner.nextInt();
            scanner.nextLine();
            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                return null;
            }
            return age;
        } catch (InputMismatchException e) {
            System.out.println("Could not parse a number. Please, try again");
            scanner.nextLine();
            return null;
        }
    }

    private static void output(List<Animal> animals) {
        for (Animal animal : animals) {
            if (animal instanceof Herbivore)
                System.out.println(animal.toString());
        }

        for (Animal animal : animals) {
            if (animal instanceof Omnivore)
                System.out.println(animal.toString());
        }
    }
}