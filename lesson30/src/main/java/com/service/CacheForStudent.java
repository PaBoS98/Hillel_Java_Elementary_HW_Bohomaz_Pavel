package com.service;

import com.Main;
import com.service.entity.Student;
import com.service.enums.LogMassage;

import static spark.Spark.*;

public class CacheForStudent extends Cache implements RestCacheInterface{

    public CacheForStudent() {
    }

    public CacheForStudent(int t) {
        super(t);
    }

    /**
     * Method keeps the student object in the cache using rest request
     * Request example (http://localhost:4567/post/nameCache/keyCache/studentName/22)
     */
    @Override
    public void put() {
        post("/post/:cache/:key/:name/:age", (request, response) -> {
            Student s = new Student(request.params(":name"), Integer.valueOf(request.params(":age")));
            Main.loggerInfo.info(LogMassage.ADD_CACHE_USING_REST.toString());
            return put(request.params(":cache"), request.params(":key"), s);
        });
    }

    /**
     * Method get the student object stored in the cache using rest request
     * Request example (http://localhost:4567/get/nameCache/keyCache)
     */
    @Override
    public void getRest() {
        get("/get/:cache/:key", (request, response) -> {
            Object o = getFromCache(request.params(":cache"), request.params(":key"));

            if (o != null) {
                Main.loggerInfo.info(String.format(LogMassage.GET_CACHE_USING_REST.toString(), "SUCCESS", ""));
                return o;
            } else {
                Main.loggerInfo.info(String.format(LogMassage.GET_CACHE_USING_REST.toString(), "ERROR", response.status()));
                Main.loggerWarn.info(String.format(LogMassage.GET_CACHE_USING_REST.toString(), "ERROR", response.status()));
                return "ERROR " + response.status();
            }
        }, super.gson::toJson);
    }

    /**
     * Method delete cache using rest request
     * Request example (http://localhost:4567/clear/all) - for delete all cache
     * Request example (http://localhost:4567/clear/cacheName) - for delete desired cache
     */
    @Override
    public void clearRest() {
        delete("/clear/:params", (request, response) -> {
            if (request.params(":params").equals("all")) {
                Main.loggerInfo.info(String.format(LogMassage.CLEAR_CACHE_USING_REST.toString(), "all"));
                clear();
            } else {
                Main.loggerInfo.info(String.format(LogMassage.CLEAR_CACHE_USING_REST.toString(), request.params(":params")));
                clear(request.params(":params"));
            }
            return true;
        });
    }
}
