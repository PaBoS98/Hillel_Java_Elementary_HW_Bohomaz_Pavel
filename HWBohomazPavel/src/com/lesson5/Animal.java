package com.lesson5;

public class Animal {

    private int id;
    private byte age;
    private int weight;
    private String color;

    public Animal(int id, String color) { // сделал эти поля обязательными
        this.id = id; // Id - для учета животных
        this.color = color; // а цвет т.к по факту раз мы знаем об этом животном, значит и его цвет
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String voice() {
        String makeVoice = "Hello, ";
        return makeVoice;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", age=" + age +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
