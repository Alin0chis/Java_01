package org.example;

import java.util.List;

public class AnimalIterator implements BaseIterator {

    private List<Animal> listAnimals;
    private int currentIndex;

    public AnimalIterator(List<Animal> listAnimals) {
        this.listAnimals = listAnimals;
    }

    @Override
    public Animal next() {
        return listAnimals.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < listAnimals.size();
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }
}
