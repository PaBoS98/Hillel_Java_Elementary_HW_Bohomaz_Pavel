package com;

import com.service.Cache;
import com.service.CacheForStudent;
import com.service.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static final Logger loggerDebug = LoggerFactory.getLogger("logger.debug");
    public static final Logger loggerInfo = LoggerFactory.getLogger("logger.info");

    public static void main(String[] args) {

        Cache cache = new CacheForStudent();
        Student s = new Student("Fedor", 22);

        System.out.println(cache.put("name", "key", s));
        System.out.println(cache.put("name1", "key", s));
        System.out.println(cache.getFromCache("name", "key"));
        cache.put();
        cache.getRest();
        cache.clearRest();
    }
}
