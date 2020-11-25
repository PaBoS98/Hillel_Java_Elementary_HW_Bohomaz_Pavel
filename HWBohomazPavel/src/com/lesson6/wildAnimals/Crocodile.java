package com.lesson6.wildAnimals;

public class Crocodile extends WildAnimal {

    public Crocodile(String color, boolean isPredator) {
        super(color, isPredator);
    }

    @Override
    public void move() {
        System.out.println("runs on 4 legs and swims");
    }
}
