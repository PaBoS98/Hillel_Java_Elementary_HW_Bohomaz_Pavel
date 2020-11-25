package com.lesson6.pets;

import com.lesson6.Animal;

public class Pet extends Animal {

    private String name;
    private boolean isVaccinated;

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
        isVaccinated = vaccinated;
    }

    @Override
    public String voice() {
        String makeVoice = super.voice();
        if (name != null) makeVoice += "my name is " + name;
        return makeVoice;
    }

    @Override
    public String toString() {
        return super.toString() + ", name='" + name + "'" +
                ", isVaccinated=" + isVaccinated;
    }
}
