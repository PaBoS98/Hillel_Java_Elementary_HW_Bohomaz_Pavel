package com.lesson6;

import com.lesson6.pets.*;
import com.lesson6.wildAnimals.Crocodile;
import com.lesson6.wildAnimals.Giraffe;
import com.lesson6.wildAnimals.Line;
import com.lesson6.wildAnimals.Wolf;

public class MainClass {

    public static void main(String[] args) {

        Cat cat = new Cat("White-Black", "Tima");
        cat.setAge((byte) 5);
        cat.setWeight(10);
        cat.setVaccinated(true);
        System.out.println(cat.toString());
        System.out.println(cat.voice());
        cat.move();
        System.out.println();

        System.out.println("____________________________________________");

        Dog dog = new Dog("black", "Graf");
        dog.setVaccinated(true);
        System.out.println(dog.toString());
        System.out.println(dog.voice());
        dog.move();

        System.out.println("____________________________________________");

        GuideDoge guideDoge = new GuideDoge("white", "Bobik", true);
        System.out.println(guideDoge.toString());
        System.out.println(guideDoge.voice());
        guideDoge.specialFunction();
        guideDoge.move();

        System.out.println("____________________________________________");

        GoldFish goldFish = new GoldFish("gold", "Aqua");
        System.out.println(goldFish.toString());
        System.out.println(goldFish.voice());
        goldFish.move();

        System.out.println("____________________________________________");

        Wolf wolf = new Wolf("black", true);
        System.out.println(wolf.toString());
        System.out.println(wolf.voice());
        wolf.getSomeFood();
        System.out.println(wolf.voice());
        wolf.move();


        System.out.println("____________________________________________");

        Giraffe giraffe = new Giraffe("Spotted", false);
        System.out.println(giraffe.toString());
        System.out.println(giraffe.voice());
        giraffe.move();

        System.out.println("____________________________________________");

        for (int i = 0; i < 100; i++) { // цикл для проверки присвоения id
            Animal an = new Pet("test", "test");
        }

        Crocodile crocodile = new Crocodile("green", true);
        crocodile.setAge((byte) 7);
        crocodile.setWeight(25);
        System.out.println(crocodile.toString());
        crocodile.voice();
        crocodile.move();
    }
}
