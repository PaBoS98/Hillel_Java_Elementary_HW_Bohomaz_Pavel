package com.lesson5.pets;

public class Fish extends Pet{

    public Fish(int id, String color, String name) {
        super(id, color, name);
    }

    @Override
    public String voice() {
        return ".....";
    }
}
