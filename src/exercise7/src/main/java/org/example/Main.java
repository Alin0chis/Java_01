package org.example;


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Double> arrNumbers = input();
        if (!arrNumbers.isEmpty()) {
            output(arrNumbers);
            writeToFile(arrNumbers);
        }
    }

    private static List<Double> input() {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = 0;
        int sizeArr = 0;
        List<Double> arrNumbers = new ArrayList<>();
        String pathFile = scanner.nextLine();
        int error = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (lineNumber == 0) {
                    try {
                        sizeArr = Integer.parseInt(line);
                        if (sizeArr <= 0) {
                            System.out.print("Input error. Size <= 0");
                            error = 1;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        //empty
                    }
                }

                if (lineNumber != 0) {
                    for (String str : line.split(" ")) {
                        try {
                            arrNumbers.add(Double.parseDouble(str));
                        } catch (NumberFormatException e) {
                            // empty
                        }
                    }
                }
                lineNumber++;
            }
            if (sizeArr > arrNumbers.size() && error == 0) {
                System.out.print("Input error. Insufficient number of elements");
                arrNumbers.clear();
            }
        } catch (IOException e) {
            System.out.print("Input error. File isn't exist");
        }
        return arrNumbers;
    }

    private static void output(List<Double> arrNumbers) {
        System.out.println(arrNumbers.size());
        for (double num : arrNumbers) {
            System.out.print(num + " ");
        }
    }

    private static void writeToFile(List<Double> arrNumbers) {
        double min = Collections.min(arrNumbers);
        double max = Collections.max(arrNumbers);
        try {
            FileWriter writer = new FileWriter("result.txt");
            writer.write(min + " " + max);
            writer.close();
            System.out.print("\nSaving min and max values in file");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }
}