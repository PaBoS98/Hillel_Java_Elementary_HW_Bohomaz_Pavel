package com.lesson6.pets;

public class GuideDoge extends Dog {

    private boolean isTrained;

    public GuideDoge(String color, String name, boolean isTrained) {
        super(color, name);
        this.isTrained = isTrained;
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

    @Override
    public String toString() {
        return super.toString() + ", isTrained=" + isTrained;
    }
}
