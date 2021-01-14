package com.lesson18.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Date;

public interface Conversion {

    void conversion(File path);

    default void saveConversion(String fName, String fType, String obj, long timeStart, File path) {
        String newFileName = fName.substring(0, fName.lastIndexOf(".")) + fType;
        File conversionDir = new File(FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
//                .toString() + "\\HW_BohomazPavel\\HWBohomazPavel\\Maven\\src\\main\\java\\com\\lesson18\\converted");
                .toString() + "\\converted");
        conversionDir.mkdir();

        try (FileWriter file = new FileWriter(conversionDir + "\\" + newFileName)) {
            file.write(String.valueOf(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date timeFinish = new Date();

        double conversionTime = timeFinish.getTime() - timeStart;
        double newWeight = new File(conversionDir + "\\" + newFileName).length();

        ConversionResults.conversionResults(path.getName(), newFileName, conversionTime, path.length(), newWeight);
    }
}
