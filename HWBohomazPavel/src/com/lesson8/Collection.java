package com.lesson8;

public interface Collection<E> {

    boolean add(E o);

    boolean add(int index, E o);

    boolean remove (int index);

    boolean remove (E o);

    E get(int index);

    boolean contain(E o);

    boolean equals (Collection o);

    boolean clear();

    int size();
}
