package com.lesson6;

public abstract class Animal implements Voice, Move {

    private static int id = -1;
    private byte age;
    private int weight;
    private String color;

    public Animal(String color) {
        id++;
        this.color = color;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() { // заменил все геттеры, перегруженным toString'ом
        return getClass().getSimpleName() +
                ": id=" + id +
                ", age=" + age +
                ", weight=" + weight +
                ", color='" + color + '\'';
    }

    @Override
    public void move() {
        System.out.println("runs on 4 legs");
    }

    @Override
    public String voice() {
        String makeVoice = "Hello, ";
        return makeVoice;
    }
}
