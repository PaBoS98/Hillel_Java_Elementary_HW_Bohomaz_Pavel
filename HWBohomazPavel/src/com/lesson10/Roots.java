package com.lesson10;

public class Roots {

    float a;
    float b;
    float c;

    public Roots(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        res();
    }

    private void res() {
        float x1;
        float x2;

        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");
        float disc = (float) (Math.pow(b, 2) - 4 * a * c);
        System.out.println("D = " + disc);
        if (disc > 0) {
            x1 = (float) ((-b + Math.sqrt(disc)) / (2 * a));
            x2 = (float) ((-b - Math.sqrt(disc)) / (2 * a));
            System.out.println("x1 = " + x1 + " | x2 = " + x2);
        } else if (disc == 0) {
            x1 = -b / (2 * a);
            System.out.println("x1 = " + x1);
        } else System.out.println("No roots");

    }
}
