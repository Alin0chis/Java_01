package org.example;

import java.util.concurrent.TimeUnit;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public double goToWalk() {
        double timeWalk = getAge() * 0.25;
        try {
            TimeUnit.SECONDS.sleep((long) timeWalk);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Walk was interrupted for " + getName());
        }
        return timeWalk;
    }

    @Override
    public String toString() {
        return "Cat name = " + getName() + ", age = " + getAge();
    }
}
