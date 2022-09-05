package com.vadpol95.RestCacheApp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * метод createCache - создает кеш
 * метод put - кладет кеш в эндпоинт
 * метод get - получает значения с эндпоинта
 * метод clear - очищает весь кеш и по одному значению
 * метод isCacheExist - проверяет есть ли кеш в памяти
 *
 */

@Service
public class CacheDAO {
    private static Logger LOGGER_INFO = LoggerFactory.getLogger("logger.info");
    private static Logger LOGGER_ERR = LoggerFactory.getLogger("logger.error");
    private static Map<String,Map<String, String>> mapCache;
    private static Map<String, String> tempCache = new HashMap<>();

    public CacheDAO() {
        mapCache = new HashMap<>();
    }

    public void createCache(String cache) {
        mapCache.put(cache,new HashMap<>());
        LOGGER_INFO.info(String.format("Create Cache with name '%s' ", cache));
    }
    public boolean put(String cache, String key, String str) {
        if (cache == null || key == null || str == null) {
            LOGGER_ERR.error("One of arguments in method 'put' is null");
            throw new IllegalArgumentException("One of arguments in method 'put' is null");
        }
        tempCache = mapCache.get(cache);


        if (tempCache != null) {
            tempCache.put(key,str);
            return true;
        }else {
            LOGGER_ERR.error(String.format("Cache with name '%s' not found", cache));
            throw new NullPointerException(String.format("Cache with name '%s' not found%n", cache));
        }


    }

    public String get(String cache, String key) {
        tempCache = mapCache.get(cache);
        LOGGER_INFO.info(String.format("Get value from inner Cache with name : '%s'", key));
        if (cache != null){
            return tempCache.get(key);
        }else {
            return null;
        }
    }

    public void clear() {
        mapCache.values().stream().forEach(map -> map.clear());
        LOGGER_INFO.info("Remove all");
    }

    public void clear(String cache) {
        tempCache = mapCache.get(cache);
        if (cache != null) tempCache.clear();
        LOGGER_INFO.info(String.format("Remove Cache with name : %s", cache));
    }

    public void isCacheExist(String cache) {
        if(mapCache.containsKey(cache)){
            System.out.println("Cache exist");
        }else {
            System.out.println("Cache is not exist");
        }

    }

}

