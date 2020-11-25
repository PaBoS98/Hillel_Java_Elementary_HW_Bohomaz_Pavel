package com.lesson6.wildAnimals;

import com.lesson6.Animal;

public class WildAnimal extends Animal {

    private boolean isPredator;

    public WildAnimal(String color, boolean isPredator) {
        super(color);
        this.isPredator = isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    @Override
    public String voice() {
        String makeVoice = super.voice() + "I am a wild animal";
        if (this.isPredator) makeVoice += " and I am angry.";
        return  makeVoice;
    }

    @Override
    public String toString() {
        return super.toString() + ", isPredator=" + isPredator;
    }
}
