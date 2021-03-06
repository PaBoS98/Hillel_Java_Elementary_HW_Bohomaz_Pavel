package com.service;

import com.service.entity.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CacheTest {

    Cache testCache;
    Student s = new Student("Valera", 54);

    @Before
    public void createCache() {
        testCache = new CacheForStudent();
    }

    @Test
    public void putTest() {
        Assert.assertTrue(testCache.put("test cache", "new key", s));
    }

    @Test
    public void getTest() {
        String nameCache = "Cache_Name";
        String keyCache = "key";
        testCache.put(nameCache, keyCache, s);
        Assert.assertEquals(s, testCache.getFromCache(nameCache, keyCache));
    }

    @Test
    public void clearAllCachesTest() {
        testCache.put("1", "key", s);
        testCache.put("2", "key", s);
        testCache.put("3", "key", s);
        Assert.assertEquals(3, testCache.size());
        testCache.clear();
        Assert.assertEquals(0, testCache.size());
    }

    @Test
    public void clearSomeCacheTest() {
        testCache.put("1", "key", s);
        testCache.put("2", "key", s);
        testCache.put("3", "key", s);
        Assert.assertEquals(s, testCache.getFromCache("2","key"));
        testCache.clear("2");
        Assert.assertNull(testCache.getFromCache("2", "key"));
    }

    @Test
    public void testMortalCache() throws InterruptedException {
        String nameCache = "mortalCache";
        String keyCache = "someKey";
        int liveTime = 1000;

        testCache = new CacheForStudent(liveTime);
        testCache.put(nameCache, keyCache, s);

        Assert.assertEquals(s, testCache.getFromCache(nameCache, keyCache));
        Thread.sleep(liveTime + 500);
        Assert.assertNull(testCache.getFromCache(nameCache, keyCache));
    }
}
