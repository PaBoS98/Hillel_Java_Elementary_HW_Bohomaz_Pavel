package com.lesson6.pets;

public class Fish extends Pet {

    public Fish(String color, String name) {
        super(color, name);
    }

    @Override
    public String voice() {
        return ".....";
    }

    @Override
    public void move() {
        System.out.println("Swims in water");
    }
}
