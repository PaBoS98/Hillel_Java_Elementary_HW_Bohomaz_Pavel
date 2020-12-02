package com.lesson8;

import java.util.Arrays;

public class CreateArrayList<E> implements Collection<E> {

    private static final int DEFAULT_SIZE = 10;

    private int size = 0; // счетчик, защиты от вставки через null

    private Object[] arrayList;

    public CreateArrayList() {
        arrayList = new Object[DEFAULT_SIZE];
    }

    @Override
    public boolean add(E o) {
        if (size == arrayList.length) grow();
        arrayList[size] = o;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E o) {
        if (size == arrayList.length) grow();
        size++;
        for (int i = arrayList.length - 2; i >= index; i--) {
            arrayList[i + 1] = arrayList[i];
        }
        arrayList[index] = o;
        return true;
    }

    @Override
    public boolean remove(int index) {
        size--;
        for (int i = index; i <= size; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[arrayList.length - 1] = null;
        return true;
    }

    @Override
    public boolean remove(E o) { // corrected: if doesn't find, return false
        for (int i = 0; i <= size; i++) {
            if (arrayList[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        return (E) arrayList[index];
    }

    @Override
    public boolean contain(E o) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Collection o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateArrayList<?> that = (CreateArrayList<?>) o;
        if (size == that.size) {
            return equal(o);
        }
        return false;
    }

    @Override
    public boolean clear() { // changed:
//        for (int to = size, i = size = 0; i < to; i++) {
//            arrayList[i] = null;
//        }
        size = 0;
        Object[] temp = new Object[DEFAULT_SIZE];
        arrayList = temp;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String collection = "[";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                collection += arrayList[i];
            } else collection += arrayList[i] + ", ";
        }
        collection += "]";
        return collection;
    }

    // corrected: all private method moved after public methods
    private void grow() { // если при добавлении кол-во объектов равно размеру коллекции, увеличивает >> 1
        arrayList = Arrays.copyOf(arrayList, arrayList.length + (arrayList.length >> 1));
    }

    private boolean equal(Collection<?> o) {
        for (int i = 0; i < size; i++) {
            if (!arrayList[i].equals(o.get(i))) return false;
        }
        return true;
    }
}
