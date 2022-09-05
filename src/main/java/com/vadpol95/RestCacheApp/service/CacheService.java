package com.vadpol95.RestCacheApp.service;

public interface CacheService {
    void createCache(String cache);
    boolean put(String cache, String key, String str);
    String get(String cache, String key);
    void clear();
    void clear(String cache);
    void isCacheExist(String cache);
}
