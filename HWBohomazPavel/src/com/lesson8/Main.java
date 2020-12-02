package com.lesson8;

public class Main {
    public static void main(String[] args) {

        CreateArrayList<String> arrayList = new CreateArrayList<>();

        arrayList.add("Green");
        arrayList.add(0, "Value");
        for (int i = 0; i < 10; i++) {
            arrayList.add("" + i);
        }
        System.out.println(arrayList.toString());
        System.out.println("Размер коллекции = " + arrayList.size());

        arrayList.remove("2");
        arrayList.remove(3);
        System.out.println(arrayList.toString());
        System.out.println("Размер коллекции = " + arrayList.size());
        System.out.println("Получаемое значение = " + arrayList.get(2));

        System.out.println("Коллекция содержит = " + arrayList.contain("Green"));

        CreateArrayList<String> test = new CreateArrayList<>();
        System.out.println("Коллекции равны? == " + arrayList.equals(test));

        arrayList.clear();
        test.add("1");
        arrayList.add("1");
        System.out.println("Коллекции равны? == " + arrayList.equals(test));

    }
}
