package com.lesson5.pets;

import com.lesson5.Animal;

public class Pet extends Animal {

    private String name;
    private boolean isVaccinated;

    public Pet(int id, String color, String name) {
        super(id, color);
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVaccinated() {
        return isVaccinated;
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
}
