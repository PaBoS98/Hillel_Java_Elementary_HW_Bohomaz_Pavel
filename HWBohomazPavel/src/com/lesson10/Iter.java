package com.lesson10;

public class Iter {

    private String[] array;
    private int current = 0;

    public Iter(int size) {
        array = new String[size];
    }

    public boolean add (int index, String o) {
        array[index] = o;
        return true;
    }

    public int size() {
        return array.length;
    }

    public boolean hasNext() {
        if (current+1 != array.length) {
            return true;
        } else current = 0;
        return false;
    }

    public void next() {
        current++;
    }

}
