package org.example;

public interface BaseIterator<T> {
    T next();

    public boolean hasNext();

    public void reset();
}
