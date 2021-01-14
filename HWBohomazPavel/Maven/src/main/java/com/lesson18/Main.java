package com.lesson18;

import com.lesson18.service.*;

import java.io.*;
import java.nio.file.FileSystems;

public class Main {

    private static final String FILE = "[f] : ";
    private static final String DIR = "[D] : ";

    public static void main(String[] args) {
        File dir;

        if (args.length == 0) {
            dir = new File(FileSystems.getDefault()
                    .getPath("")
                    .toAbsolutePath()
                    .toString());
        } else {
            dir = new File(args[0]);
        }

        System.out.println(dir);

        for (File f : dir.listFiles()){
            getFileStructure(f, "");
        }

        ConversionResults.saveResult();
    }

    private static void validate(File file) {
        String typeFile = GetFileExtension.getFileExtension(file);

        if (typeFile.equals(".json")) {
            ConversionJsonToYaml conJson = new ConversionJsonToYaml();
            conJson.conversion(file);
        } else if (typeFile.equals(".yaml")) {
            ConversionYamlToJson conYaml = new ConversionYamlToJson();
            conYaml.conversion(file);
        } else {
            ConversionResults.failedConversion(file.getName());
        }
    }

    private static void getFileStructure(File file, String prefix) {
        if (file.isFile()) {
            System.out.println(prefix + FILE.concat(file.getName()));
            validate(file);
        } else {
            System.out.println(prefix + DIR.concat(file.getName()));
        }
    }
}
