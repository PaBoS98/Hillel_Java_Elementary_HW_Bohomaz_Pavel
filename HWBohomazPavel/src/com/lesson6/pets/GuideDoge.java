package com.lesson6.pets;

import com.lesson6.SpecialFunction;

public class GuideDoge extends Dog implements SpecialFunction {

    private boolean trained; // corrected

    public GuideDoge(String color, String name, boolean isTrained) {
        super(color, name);
        this.trained = isTrained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    @Override
    public String voice() {
        String makeVoice = super.voice();
        return makeVoice;
    }

    @Override
    public String toString() {
        return super.toString() + ", trained=" + trained;
    }

    @Override
    public void specialFunction() {
        if (trained) System.out.println("I can take you home. Wooof woof!");
    }
}
