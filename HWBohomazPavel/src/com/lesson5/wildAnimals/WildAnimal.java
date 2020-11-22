package com.lesson5.wildAnimals;

import com.lesson5.Animal;

public class WildAnimal extends Animal {

    private boolean isPredator;

    public WildAnimal(int id, String color, boolean isPredator) {
        super(id, color);
        this.isPredator = isPredator;
    }

    public boolean isPredator() {
        return isPredator;
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
}
