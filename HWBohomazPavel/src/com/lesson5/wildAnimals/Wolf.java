package com.lesson5.wildAnimals;

public class Wolf extends WildAnimal{

    private boolean isHungry = true;

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public Wolf(int id, String color, boolean isPredator) {
        super(id, color, isPredator);
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
}
