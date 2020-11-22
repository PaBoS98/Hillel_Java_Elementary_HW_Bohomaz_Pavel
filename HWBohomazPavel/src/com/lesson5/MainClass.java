package com.lesson5;

import com.lesson5.pets.Cat;
import com.lesson5.pets.Dog;
import com.lesson5.pets.GoldFish;
import com.lesson5.pets.GuideDoge;
import com.lesson5.wildAnimals.Giraffe;
import com.lesson5.wildAnimals.Wolf;

public class MainClass {

    public static void main(String[] args) {

        Animal animal = new Animal(0, "brown");
        animal.setWeight(50);
        animal.setAge((byte) 12);
        System.out.println(animal.toString());
        System.out.println(animal.voice());

        System.out.println("____________________________________________");

        Cat cat = new Cat(1, "White-Black", "Tima");
        cat.setAge((byte) 5);
        cat.setWeight(10);
        cat.setVaccinated(true);
        System.out.println(cat.voice());

        System.out.println("____________________________________________");

        Dog dog = new Dog(2, "black", "Graf");
        dog.setVaccinated(true);
        System.out.println(dog.voice());

        System.out.println("____________________________________________");

        GuideDoge guideDoge = new GuideDoge(3, "white", "Bobik", true);
        System.out.println(guideDoge.voice());
        guideDoge.takeHome();

        System.out.println("____________________________________________");

        GoldFish goldFish = new GoldFish(4, "gold", "Aqua");
        System.out.println(goldFish.voice());

        System.out.println("____________________________________________");

        Wolf wolf = new Wolf(5, "black", true);
        System.out.println(wolf.voice());
        wolf.getSomeFood();
        System.out.println(wolf.voice());

        System.out.println("____________________________________________");

        Giraffe giraffe = new Giraffe(6, "Spotted", false);
        System.out.println(giraffe.voice());
    }
}
