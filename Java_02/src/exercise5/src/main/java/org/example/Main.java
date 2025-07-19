package org.example;


import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Animal> pets = inputAnimals();
        ExecutorService executorService = Executors.newCachedThreadPool(); // создает пул потоков
        Instant startTime = Instant.now(); // возвращает текущее время

        pets.forEach(pet -> executorService.submit(() -> {
            Instant walkStart = Instant.now();
            pet.goToWalk();
            Instant walkEnd = Instant.now();
            double startTimeSeconds = Duration.between(startTime, walkStart).toMillis() / 1000.0;
            double endTimeSeconds = Duration.between(startTime, walkEnd).toMillis() / 1000.0;

            System.out.printf("%s, start time = %.2f, end time = %.2f%n",
                    pet, startTimeSeconds, endTimeSeconds);
        }));

        executorService.shutdown(); // закрывает пул потоков

        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.err.println("Executor was interrupted");
        }
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
        if (!typeAnimal.equals("dog") && !typeAnimal.equals("cat")) {
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
}