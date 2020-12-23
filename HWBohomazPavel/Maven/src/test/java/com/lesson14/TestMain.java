package com.lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain {

    @Test
    void testAverage() {
        List<Integer> test = List.of(1, 2, 3, 4, 5, 6, 7);
        Assertions.assertEquals(4, Main.average(test));
    }

    @Test
    void testToUpper() {
        List<String> testToUpperIn = List.of("happy", "new", "year");
        List<?> testToUpperOut = List.of(new Pair("happy"), new Pair("new"), new Pair("year"));

        Assertions.assertEquals(testToUpperOut, Main.toUpper(testToUpperIn));
    }

    @RepeatedTest(5)
    void testFilter() {
        List<String> testFilterIn;
        String testFilterOut;
        String parameterFilterIn = "No more champagne And the fireworks are through Here we are, me and you Feeling lost" +
                " and feeling blue It's the end of the party And the morning seems so grey So unlike yesterday Now's the" +
                " time for us to say Happy new year Happy new year May we all have a vision now and then" +
                " Of a world where every neighbor is a friend Happy new year Happy new year May we all have our hopes" +
                " our will to try If we don't we might as well lay down and die You and I Sometimes I see How the brave" +
                " new world arrives And I see how it thrives In the ashes of our lives Oh yes, man is a fool And he thinks" +
                " he'll be OK Dragging on feet of clay Never knowing he's astray Keeps on going anyway Happy new year Happy" +
                " new year May we all have a vision now and then Of a world where every neighbor is a friend Happy new year" +
                " Happy new year May we all have our hopes our will to try If we don't we might as well lay down and die You" +
                " and I Seems to me now That the dreams we had before Are all dead nothing more Than confetti on the floor" +
                " It's the end of a decade In another ten years time Who can say what we'll find What lies waiting down the" +
                " line In the end of eighty-nine Happy new year Happy new year May we all have a vision now and then Of a world" +
                " where every neighbor is a friend Happy new year Happy new year May we all have our hopes our will to try If we" +
                " don't we might as well lay down and die You and I";
        String[] s = parameterFilterIn.replace(",", "").split(" ");
        testFilterIn = Arrays.asList(s);
        testFilterOut = testFilterIn.stream().filter(e -> e.equals(e.toLowerCase()) && e.length() == 4).collect(Collectors.joining(", ", "[", "]"));

        Assertions.assertEquals(testFilterOut, Main.filter(testFilterIn));
        Assertions.assertEquals(testFilterOut.length(), Main.filter(testFilterIn).length());
    }

}
