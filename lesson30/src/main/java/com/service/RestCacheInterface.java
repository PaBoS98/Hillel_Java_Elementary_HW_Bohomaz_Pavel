package com.service;

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
