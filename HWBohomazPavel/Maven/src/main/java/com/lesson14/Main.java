package com.lesson14;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> collection = List.of(1, 5, 6, 125, 6, 12, 6, 7, 12, 5);
        System.out.println("Average = " + average(collection));

        System.out.println("____________________________________________________________");

        List<String> collectionString = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        System.out.println(toUpper(collectionString));

        System.out.println("____________________________________________________________");

        List<String> string = List.of("january", "february", "March", "April", "May", "June", "july", "august", "September", "November", "December",
                "monday", "Tuesday", "Wednesday", "thursday", "Friday", "Saturday", "Sunday", "one", "two", "three", "four", "five", "six", "seven",
                "yeAr", "month", "week", "day", "hour", "minute", "second", "happy", "NEW", "year", "2", "0", "2", "1");

        System.out.println(filter(string));
    }

    public static double average(Collection<?> coll) {
        return coll.stream()
                .mapToInt(e -> (int) e)
                .average().getAsDouble();
    }

    public static List<Pair> toUpper(Collection<?> coll) {
        List<Pair> pair;
        pair = coll.stream().map(e -> new Pair((String) e)).collect(Collectors.toList());
        return pair;
    }

    public static String filter(Collection<String> coll) {
        return coll.stream()
                .filter(e -> e.equals(e.toLowerCase()) && e.length() == 4)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}

