package com.lesson6.pets;

public class Cat extends Pet {


    public Cat(String color, String name) {
        super(color, name);
    }

    @Override
    public String voice() {
        String makeVoice = super.voice() + ", MeeeEEOOOoow!!";
        return makeVoice;
    }
}
