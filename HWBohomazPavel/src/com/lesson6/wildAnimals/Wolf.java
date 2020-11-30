package com.lesson6.wildAnimals;

public class Wolf extends WildAnimal {

    private boolean hungry = true; // corrected

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public Wolf(String color, boolean isPredator) {
        super(color, isPredator);
    }

    @Override
    public String voice() {
        String makeVoice = super.voice();
        if (this.hungry) {
            makeVoice += " I'll eat you little red riding hood!!";
        } else makeVoice += " I'll eat you later";
        return makeVoice;
    }

    public void getSomeFood() {
        hungry = false;
    }

    @Override
    public String toString() {
        return super.toString() + ", hungry=" + hungry;
    }
}
