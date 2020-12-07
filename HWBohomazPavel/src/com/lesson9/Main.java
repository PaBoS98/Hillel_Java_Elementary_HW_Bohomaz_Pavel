package com.lesson9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        linkedList.add("Pooof");
        linkedList.add("BoOOoM");
        linkedList.add(1,"Crash");
        System.out.println(linkedList.toString() + " size = " + linkedList.size());
        System.out.println("\n_____________________________________________________\n");

        String word = "LinkedList";
        char[] c = word.toCharArray();
        String[] letters = new String[c.length];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = String.valueOf(c[i]);
        }
        linkedList.addAll(letters);
        System.out.println(linkedList.toString() + " size = " + linkedList.size());
        System.out.println("\n_____________________________________________________\n");

        CustomLinkedList<String> coll = new CustomLinkedList<>();
        coll.add(null);
        coll.add("from_Coll");
        linkedList.addAll(coll);
        System.out.println(linkedList.toString() + " size = " + linkedList.size());
        System.out.println("\n_____________________________________________________\n");

        linkedList.delete(null);
        linkedList.delete(0);
        System.out.println(linkedList.toString() + " size = " + linkedList.size());
        System.out.println("\n_____________________________________________________\n");

        for (int i = 2; i <= 11; i++) {
            System.out.print(linkedList.get(i));
        }
        System.out.println("\nSearch Pooof " + linkedList.contains("Pooof"));
        System.out.println("Search BoOOoM " + linkedList.contains("BoOOoM"));
        System.out.println(linkedList.toString() + " size = " + linkedList.size());
        System.out.println("\n_____________________________________________________\n");

        System.out.println("Compare two different collection - " + linkedList.compare(coll));
        System.out.println("Clear both collection");
        coll.clear();
        linkedList.clear();
        System.out.println(coll.toString());
        System.out.println(linkedList.toString());
        System.out.println("add - '1'");
        coll.add("1");
        linkedList.add("1");
        System.out.println("Compare two same collection - " + linkedList.compare(coll));
        System.out.println(coll.toString() + " size = " + coll.size());
        System.out.println(linkedList.toString() + " size = " + linkedList.size());



    }

}
