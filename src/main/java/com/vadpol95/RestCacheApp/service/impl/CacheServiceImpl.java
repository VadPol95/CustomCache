package com.vadpol95.RestCacheApp.service.impl;

import com.vadpol95.RestCacheApp.dao.CacheDAO;
import com.vadpol95.RestCacheApp.service.CacheService;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {
    private static CacheDAO cacheDAO;

    public CacheServiceImpl(CacheDAO cacheDAO) {
        CacheServiceImpl.cacheDAO = cacheDAO;
    }

    @Override
    public void createCache(String cache) {
        cacheDAO.createCache(cache);
    }

    @Override
    public boolean put(String cache, String key, String str) {
        cacheDAO.put(cache, key, str);
        return true;
    }

    @Override
    public String get(String cache, String key) {
        return cacheDAO.get(cache, key);
    }

    @Override
    public void clear() {
        cacheDAO.clear();

    }

    @Override
    public void clear(String cache) {
        cacheDAO.clear(cache);
    }

    @Override
    public void isCacheExist(String cache) {
        cacheDAO.isCacheExist(cache);
    }
}
