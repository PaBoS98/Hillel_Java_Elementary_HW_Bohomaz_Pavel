package com.service.enums;

public enum LogMassage {
    IMMORTAL_CACHE("Create immortal cache"),
    MORTAL_CACHE("Create mortal cache, lifetime = %s"),
    ADD_CACHE("Add new cache: %s - %s"),
    ADD_CACHE_USING_REST("|-------------------> Add new cache using REST <-------------------|"),
    GET_CACHE("Get cache: %s - %s"),
    GET_CACHE_USING_REST("|-------------------> Get cache using REST status=%s %s <-------------------|"),
    CLEAR_CACHE("Clear %s cache"),
    CLEAR_CACHE_USING_REST("|-------------------> Clear %s cache using REST <-------------------|");

    String v;
    LogMassage(String v){
        this.v = v;
    }

    @Override
    public String toString() {
        return v;
    }
}
