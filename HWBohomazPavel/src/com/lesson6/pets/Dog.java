package com.lesson6.pets;

public class Dog extends Pet {


    public Dog(String color, String name) {
        super(color, name);
    }

    @Override
    public String voice() {
        String makeVoice = super.voice() + ", Woof woof!!";
        return makeVoice;
    }
}
