package com.lesson18.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;

public class ConversionResults {

    private static StringBuilder stringBuilder = new StringBuilder("");

    public static void conversionResults(String fName, String newFName, double timeConversion, double oldWeight, double newWeight) {
        stringBuilder.append("Original name: " + fName + " -> ")
                .append("New name: " + newFName + ": ")
                .append("Time conversion: " + timeConversion + "s., ")
                .append("old weight: " + oldWeight + " bytes - ")
                .append("new weight: " + newWeight + " bytes")
                .append("\n");
    }

    public static void failedConversion(String fName) {
        stringBuilder.append(fName + " -> Impossible conversion!").append("\n");
    }

    public static void saveResult() {
        File dir = new File(FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
//                .toString() + "\\HW_BohomazPavel\\HWBohomazPavel\\Maven\\src\\main\\java\\com\\lesson18");
                .toString());
        try (FileWriter result = new FileWriter(dir + "\\results.txt", true)){
            result.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
