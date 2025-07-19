package org.example;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public Animal createAnimalOverTenYearsOld(Animal animal) {
        return new Dog(animal.getName(), animal.getAge() + 1);
    }

    @Override
    public String toString() {
        return "Cat name = " + getName() + ", age = " + getAge();
    }
}
