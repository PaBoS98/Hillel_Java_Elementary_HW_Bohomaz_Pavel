package com.lesson6.wildAnimals;

import com.lesson6.Animal;
import com.lesson6.Voice;

public class WildAnimal extends Animal implements Voice {

    private boolean predator; // corrected

    public WildAnimal(String color, boolean isPredator) {
        super(color);
        this.predator = isPredator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    @Override
    public String voice() {
        String makeVoice = Voice.super.voice() + "I am a wild animal";
        if (this.predator) makeVoice += " and I am angry.";
        return  makeVoice;
    }

    @Override
    public String toString() {
        return super.toString() + ", predator=" + predator;
    }
}
