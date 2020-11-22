package com.lesson5.pets;

public class GuideDoge extends Dog{

    private boolean isTrained;

    public GuideDoge(int id, String color, String name, boolean isTrained) {
        super(id, color, name);
        this.isTrained = isTrained;
    }


    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    @Override
    public String voice() {
        String makeVoice = super.voice();
        return makeVoice;
    }

    public void takeHome () {
        if (isTrained) System.out.println("I can take you home. Wooof woof!");
    }
}
