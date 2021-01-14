package com.lesson18.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.*;

public class ConversionYamlToJson implements Conversion {

    @Override
    public void conversion(File path) {
        Date timeStart = new Date();
        String yamlStr = ReadFromFile.readToString(String.valueOf(path));
        Yaml yaml = new Yaml();

//        try {
//            List<String> obj = yaml.load(yamlStr);
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            saveConversion(path.getName(), ".json", gson.toJson(obj), timeStart.getTime(), path);
//        } catch (ClassCastException e) {
//            Map<String, Object> obj = yaml.load(yamlStr);
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            saveConversion(path.getName(), ".json", gson.toJson(obj), timeStart.getTime(), path);
//        }

        Object obj = yaml.load(yamlStr);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        saveConversion(path.getName(), ".json", gson.toJson(obj), timeStart.getTime(), path);
    }

}
