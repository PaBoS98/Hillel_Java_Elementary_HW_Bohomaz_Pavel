package com.service;

/**
 * @author Bohomaz Pavel
 * @version 0.0.1
 * <p>Interface for creating a cache</p>
 */
public interface CacheInterface {

    /**
     * Method keeps the object in the cache
     *
     * @param cache - Set name cache
     * @param key   - Set key cache
     * @param o     - Set object cache
     * @return - return boolean value
     */
    boolean put(String cache, String key, Object o);

    /**
     * Method get the object stored in the cache
     *
     * @param cache - Specifies the name of the desired cache
     * @param key   - Specifies the key of the desired cache
     * @return - Returns the object that was saved in the cache If there is no such object, it will return null
     */
    Object getFromCache (String cache, String key);

    /**
     * Method delete all cache
     */
    void clear();

    /**
     * Method delete cache which is specified in the parameter, if it exists
     *
     * @param cache - Specifies the name of the desired cache for delete
     */
    void clear(String cache);
}
