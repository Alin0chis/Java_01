package org.example;

import java.util.concurrent.TimeUnit;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public double goToWalk() {
        double timeWalk = getAge() * 0.5;
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
        return "Dog name = " + getName() + ", age = " + getAge();
    }
}
