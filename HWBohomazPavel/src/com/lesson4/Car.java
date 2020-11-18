package com.lesson4;

public class Car {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    private float value;
    private float residue;
    private float fuelConsumption;

    public Car(float value, float residue, float fuelConsumption) {
        this.value = value;
        this.residue = residue;
        this.fuelConsumption = fuelConsumption;

    }

    public float fillTankFull() {
        float fillValue = value - residue;
        System.out.println(ANSI_GREEN + "<<Заливаем " + fillValue + "л. ...>>" + ANSI_RESET);
        residue += fillValue;
        return fillValue;
    }

    public float forecastFuelRemaining(float km) {
        float forecastValue = residue - (fuelConsumption * km / 100);
        return forecastValue;
    }

    public float forecastRefueling(float km) {
        float forecastFillValue = value - forecastFuelRemaining(km);
        return forecastFillValue;
    }


}
