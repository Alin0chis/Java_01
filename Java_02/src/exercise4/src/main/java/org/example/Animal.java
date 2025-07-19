package org.example;

import java.util.List;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static Animal createNewObject(Animal animal) {
        if (animal.getAge() > 10) {
            return animal.createAnimalOverTenYearsOld(animal);
        } else return animal;
    }

    public abstract Animal createAnimalOverTenYearsOld(Animal animal);
}
