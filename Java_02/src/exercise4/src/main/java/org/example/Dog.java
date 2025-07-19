package org.example;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public Animal createAnimalOverTenYearsOld(Animal animal) {
        return new Dog(animal.getName(), animal.getAge() + 1);
    }

    @Override
    public String toString() {
        return "Dog name = " + getName() + ", age = " + getAge();
    }
}
