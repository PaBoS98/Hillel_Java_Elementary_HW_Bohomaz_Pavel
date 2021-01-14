package com.lesson18.service;

import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class ConversionJsonToYaml implements Conversion{
    @Override
    public void conversion(File path) {
        Date timeStart = new Date();
        String json = ReadFromFile.readToString(String.valueOf(path));
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
        Yaml yaml = new Yaml();
        saveConversion(path.getName(), ".yaml", yaml.dump(map), timeStart.getTime(), path);

    }
}
