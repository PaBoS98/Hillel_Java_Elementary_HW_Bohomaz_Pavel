package com.lesson5.pets;

public class Cat extends Pet{


    public Cat(int id, String color, String name) {
        super(id, color, name);
    }

    @Override
    public String voice() {
        String makeVoice = super.voice() + ", MeeeEEOOOoow!!";
        return makeVoice;
    }
}
