package com.lesson6.wildAnimals;

public class Wolf extends WildAnimal {

    private boolean isHungry = true;

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public Wolf(String color, boolean isPredator) {
        super(color, isPredator);
    }

    @Override
    public String voice() {
        String makeVoice = super.voice();
        if (this.isHungry) {
            makeVoice += " I'll eat you little red riding hood!!";
        } else makeVoice += " I'll eat you later";
        return makeVoice;
    }

    public void getSomeFood() {
        isHungry = false;
    }

    @Override
    public String toString() {
        return super.toString() + ", isHungry=" + isHungry;
    }
}
