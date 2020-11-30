package com.lesson7;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        CreateArrayList createArrayList = new CreateArrayList("Car, Plane, Name, Get, Pull, dog, cat, gAmE");
        System.out.println("Размер коллекции " + createArrayList.size());
        System.out.println(createArrayList.toString());

        System.out.println("\n" + "add two new values");
        createArrayList.add("example value");
        createArrayList.add(5, "new value");
        System.out.println("Размер коллекции " + createArrayList.size());
        System.out.println(createArrayList.toString());

        System.out.println("\n" + "Remove - 3 index and object dog");
        createArrayList.remove(3);
        createArrayList.remove("dog");
        System.out.println("Размер коллекции " + createArrayList.size());
        System.out.println(createArrayList.toString());

        System.out.println("\n" + "Get first object");
        System.out.println(createArrayList.get(0));
        System.out.println(createArrayList.toString());

        System.out.println("\n" + "test growing");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        createArrayList.add("!*!*!*!");
        System.out.println(createArrayList.size());
        System.out.println(createArrayList.toString());

        System.out.println("\nTest create empty array");
        CreateArrayList emptyArrayList = new CreateArrayList();
        System.out.println("Как можно увидеть размер коллеции 0, а на самом деле 10 ячеек есть, специально не убиарал эту видимость для наглядности");
        System.out.println(emptyArrayList.toString());
        System.out.println("Размер коллекции " + emptyArrayList.size());


    }
}

class CreateArrayList {
    public static final int DEFAULT_SIZE = 10;
    public static final float MAGNIFICATION_FACTOR = 2.3f;

    private int count = 0; // счетчик, защиты от вставки через null

    private String[] arrayList;

    public CreateArrayList() { // создание пустой коллекции
        arrayList = new String[DEFAULT_SIZE];
    }
    public CreateArrayList(String cell) { // создание коллекции с заранее заданым содержимым
        this.arrayList = cell.split(","); // разбивка на слова

        for (int i = 0; i < arrayList.length; i++) { // удаление пробелов перед словами, если таковые имеются
            arrayList[i] = arrayList[i].trim();
        }
        count = arrayList.length;
        if (arrayList.length < DEFAULT_SIZE) { // дефолтное значение массива 10, если меньше 10 увеличивает до 10
            arrayList = Arrays.copyOf(arrayList, DEFAULT_SIZE);
        } else { // если >= 10 увеличивает на 2.3
            grow();
        }
    }

    public void add(String o) { // вставка после последнего значения
        if (count == arrayList.length) grow();
        arrayList[count] = o;
        count++;
    }
    public void add(int index, String o) { // вставка в любое место, но не с пробелом к примеру:
                                            // не даст вставить вот так {'кот', 'собака', null, 'попугай'}
        if (count == arrayList.length) grow();
        count++;
        for (int i = arrayList.length - 2; i >= index; i--) {
            arrayList[i + 1] = arrayList[i];
        }
        arrayList[index] = o;
    }

    public void remove(int index) { // удаляет объект по индексу
        count--;
        for (int i = index; i < arrayList.length - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[arrayList.length - 1] = null;
    }
    public void remove(String o) { // удаляет объект по значению
        count--;
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i].equals(o)) {
                remove(i);
                break;
            }
        }
    }

    public String get(int index) { // возвращает по индексу
        return arrayList[index];
    }

    private void grow() { // если при добавлении кол-во объектов равно размеру коллекции, увеличивает на 2.3
        int increaseValue = Math.round(arrayList.length * MAGNIFICATION_FACTOR);
        arrayList = Arrays.copyOf(arrayList, increaseValue);
    }

    public int size() { // показывает кол-во объектов в коллекции, а не полностью ячеек
        return count;
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayList);
    }
}
