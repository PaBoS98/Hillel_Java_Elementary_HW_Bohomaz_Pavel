package com.service;

import com.Main;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bohomaz Pavel
 * @version 0.0.1
 * <p>Class for creating a cache</p>
 */
public abstract class Cache {

    private Map<String, Map<String, Object>> caches;
    private boolean deathSwitch = false;
    private int deadTime;

    protected Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Default constructor create immortal cache
     */
    public Cache() {
        this.caches = new HashMap<>();
        Main.loggerDebug.debug("Create immortal cache");
    }

    /**
     * Constructor with param for create mortal Cache
     * @param t - Set milliseconds to cache life
     */
    public Cache(int t) {
        this.caches = new HashMap<>();
        this.deathSwitch = true;
        this.deadTime = t;
        Main.loggerDebug.debug("Create mortal cache, lifetime = " + deadTime);
    }

    /**
     * Method keeps the object in the cache
     * @param cache - Set name cache
     * @param key - Set key cache
     * @param o - Set object cache
     * @return - return boolean value
     */
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
        Main.loggerInfo.info("Add new cache: " + cache + " - " + cacheObject);
        return true;
    }

    /**
     * Method keeps the object in the cache using rest request
     * Needs to be overridden according to your request
     */
    abstract public void put();

    /**
     * Method get the object stored in the cache
     * @param cache - Specifies the name of the desired cache
     * @param key - Specifies the key of the desired cache
     * @return - Returns the object that was saved in the cache If there is no such object, it will return null
     */
    public Object getFromCache(String cache, String key) {
        Object o;
        try {
            o = this.caches.get(cache).get(key);
        } catch (NullPointerException e) {
            o = null;
        }
        if (o != null) Main.loggerInfo.info("Get cache: " + cache + " - " + o);
        else Main.loggerInfo.info("Get cache: " + cache + " - not found");
        return o;
    }

    /**
     * Method get the object stored in the cache using rest request
     * Needs to be overridden according to your request
     */
    abstract public void getRest();

    /**
     * Method delete all cache
     */
    public void clear() {
        this.caches = new HashMap<>();
        Main.loggerInfo.info("Clear All cache");
    }

    /**
     * Method delete cache which is specified in the parameter, if it exists
     * @param cache - Specifies the name of the desired cache for delete
     */
    public void clear(String cache) {
        this.caches.remove(cache);
        Main.loggerInfo.info("Clear `" + cache + "` cache");
    }

    /**
     * Method delete cache using rest request
     * Needs to be overridden according to your request
     */
    abstract public void clearRest();

    /**
     * Method for return count cache
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
