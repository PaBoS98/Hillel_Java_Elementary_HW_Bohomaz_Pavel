package com.service;

import com.Main;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.enums.LogMassage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bohomaz Pavel
 * @version 0.0.2
 * <p>Class for creating a cache</p>
 */
public class Cache implements CacheInterface{

    private Map<String, Map<String, Object>> caches;
    private boolean deathSwitch = false;
    private int deadTime;

    protected Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Default constructor create immortal cache
     */
    public Cache() {
        this.caches = new HashMap<>();
        Main.loggerDebug.debug(LogMassage.IMMORTAL_CACHE.toString());
    }

    /**
     * Constructor with param for create mortal Cache
     *
     * @param t - Set milliseconds to cache life
     */
    public Cache(int t) {
        this.caches = new HashMap<>();
        this.deathSwitch = true;
        this.deadTime = t;
        Main.loggerDebug.debug(String.format(LogMassage.MORTAL_CACHE.toString(), deadTime));
    }

    @Override
    public boolean put(String cache, String key, Object o) {
        Map<String, Object> cacheObject = new HashMap<>();
        if (this.caches.get(cache) == null) {
            if (deathSwitch) {
                class CacheObject implements Runnable {
                    private long time;
                    private Thread t;

                    CacheObject() {
                        t = new Thread(this);
                        time = new Date().getTime() + deadTime;
                        t.start();
                    }

                    @Override
                    public void run() {
                        while (true) {
                            if ((time) <= new Date().getTime()) {
                                break;
                            }
                        }
                        caches.get(cache).remove(key);
                    }

                    public HashMap createCashObject() {
                        cacheObject.put(key, o);
                        return (HashMap) cacheObject;
                    }
                }
                this.caches.put(cache, new CacheObject().createCashObject());
            } else {
                cacheObject.put(key, o);
                this.caches.put(cache, cacheObject);
            }
        } else {
            this.caches.get(cache).put(key, o);
        }
        Main.loggerInfo.info(String.format(LogMassage.ADD_CACHE.toString(), cache, cacheObject));
        return true;
    }

    @Override
    public Object getFromCache(String cache, String key) {
        Object o;
        try {
            o = this.caches.get(cache).get(key);
        } catch (NullPointerException e) {
            o = null;
        }
        if (o != null) Main.loggerInfo.info(String.format(LogMassage.GET_CACHE.toString(), cache, o));
        else {
            Main.loggerInfo.info(String.format(LogMassage.GET_CACHE.toString(), cache, "not found"));
            Main.loggerWarn.info(String.format(LogMassage.GET_CACHE.toString(), cache, "not found"));
        }
        return o;
    }

    @Override
    public void clear() {
        this.caches = new HashMap<>();
        Main.loggerInfo.info(String.format(LogMassage.CLEAR_CACHE.toString(), "all"));
    }

    @Override
    public void clear(String cache) {
        this.caches.remove(cache);
        Main.loggerInfo.info(String.format(LogMassage.CLEAR_CACHE.toString(), cache));
    }

    /**
     * Method for return count cache
     *
     * @return - int value which means count cache
     */
    public int size() {
        return this.caches.size();
    }

    @Override
    public String toString() {
        return "Cache{" +
                "caches=" + caches +
                '}';
    }
}
