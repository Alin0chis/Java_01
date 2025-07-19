package org.example;

public class Cat extends Animal {

    public Cat(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public double getFeedInfoKg(double weight) {
        return weight * 0.1;
    }

    @Override
    public String toString() {
        return String.format(
                "Cat name = %s, age = %d, mass = %.2f, feed = %.2f",
                getName(),
                getAge(),
                getWeight(),
                getFeedInfoKg(getWeight())
        );
    }
}
