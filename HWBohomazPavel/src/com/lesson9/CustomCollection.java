package com.lesson9;

import com.lesson8.Collection;

import java.util.LinkedList;

public interface CustomCollection<E> {

    boolean add(E o);
    boolean add(int index,E o);
    boolean addAll(E[] array);
    boolean addAll(CustomCollection<E> coll);
    boolean delete(int index);
    boolean delete(E o);
    E get(int index);
    boolean contains(E o);
    boolean clear();
    int size();
    boolean trim();
    boolean compare(CustomCollection<E> coll);
    E getFirst();
    E getLast();
}
