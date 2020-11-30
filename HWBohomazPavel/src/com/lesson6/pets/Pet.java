package com.lesson6.pets;

import com.lesson6.Animal;
import com.lesson6.Voice;

public class Pet extends Animal implements Voice {

    private String name;
    private boolean vaccinated; // corrected

    public Pet( String color, String name) {
        super(color);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    @Override
    public String voice() {
        String makeVoice = Voice.super.voice();
        if (name != null) makeVoice += "my name is " + name;
        return makeVoice;
    }

    @Override
    public String toString() {
        return super.toString() + ", name='" + name + "'" +
                ", vaccinated=" + vaccinated;
    }
}
