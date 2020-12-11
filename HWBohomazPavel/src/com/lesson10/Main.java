package com.lesson10;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> coll = new ArrayList<>();
        coll.add(1);
        coll.add(2);
        coll.add(3);
        coll.add(4);
        coll.add(4);
        coll.add(5);
        coll.add(5);
        coll.add(1);
        System.out.println(coll);
        System.out.println(unique(coll));
        System.out.println("---------------------------------------------");

        Iter iter = new Iter(10);
        for (int i = 0; i < iter.size(); i++) {
            iter.add(i, "" + i + 1);
        }

        System.out.println(iter.hasNext());
        while (iter.hasNext()) {
            System.out.println("+");
            iter.next();
        }
        System.out.println("---------------------------------------------");

        Roots r = new Roots(5, -8, 3);
    }

    public static Collection<Integer> unique(List<Integer> coll) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < coll.size(); i++) {
            set.add(coll.get(i));
        }
        return set;
    }
}
