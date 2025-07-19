package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sec = input();
        if(sec >= 0){
            int[] time = findingTime(sec);
            getTime(time);
        } else {
            System.out.print("Incorrect time");
        }
    }

    private static int input(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
                return scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.next();
            }
        }
    }

    private static int[] findingTime(int sec){
        int h = sec / 60 / 60;
        int m = sec / 60 - (h * 60);
        int s = sec - (h * 60 * 60) - (m * 60);
        return new int[]{h, m, s};
    }

    private static void getTime(int[] time){
        System.out.printf("%02d:%02d:%02d", time[0], time[1], time[2]);
    }
}