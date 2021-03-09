package com.service;

/**
 * @author Bohomaz Pavel
 * @version 0.0.1
 * <p>Interface for creating a cache using REST</p
 * <p>A class that implements this interface must also extend the Cache class and use its methods to manage changes in the cache.</p>
 */
public interface RestCacheInterface {

    /**
     * Method keeps the object in the cache using rest request
     */
    void put();

    /**
     * Method get the object stored in the cache using rest request
     */
    void getRest();

    /**
     * Method delete cache using rest request
     */
    void clearRest();
}
