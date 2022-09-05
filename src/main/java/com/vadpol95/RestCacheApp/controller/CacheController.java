package com.vadpol95.RestCacheApp.controller;

import com.vadpol95.RestCacheApp.service.impl.CacheServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CacheController {
    private final CacheServiceImpl service;
    private static Logger LOGGER_INFO = LoggerFactory.getLogger("logger.info");

    @Autowired
    public CacheController(CacheServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public void createCache(@RequestParam("name") String cache) {
        LOGGER_INFO.info("Endpoint /create  Cache name: " + cache);
        service.createCache(cache);
    }

    @GetMapping("/get")
    public void get(@RequestParam String cache, @RequestParam String key) {
        LOGGER_INFO.info("Endpoint /get  Cache name: " + cache + " " + key);
        service.get(cache, key);
    }

    @PostMapping("/put")
    public void put(@RequestParam String cache, @RequestParam String key, @RequestParam String str) {
        LOGGER_INFO.info("Endpoint /put  Cache name: " + cache + " " + key + " " + str);
        service.put(cache, key, str);
    }

    @DeleteMapping("/clear")
    public void clear() {
        LOGGER_INFO.info("Endpoint /clearAll");
        service.clear();
    }

    @DeleteMapping("/clear/{cache}")
    public void clear(@PathVariable("cache") String cache) {
        LOGGER_INFO.info("Endpoint /clear  Cache name: " + cache);
        service.clear(cache);
    }

    @GetMapping("/exist")
    public void isExist(@RequestParam("name") String cache) {
        LOGGER_INFO.info("Endpoint /exist  Cache name: " + cache);
        service.isCacheExist(cache);
    }
}
