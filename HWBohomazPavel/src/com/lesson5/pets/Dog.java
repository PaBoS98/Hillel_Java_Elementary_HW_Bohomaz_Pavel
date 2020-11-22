package com.lesson5.pets;

public class Dog extends Pet{


    public Dog(int id, String color, String name) {
        super(id, color, name);
    }

    @Override
    public String voice() {
        String makeVoice = super.voice() + ", Woof woof!!";
        return makeVoice;
    }
}
