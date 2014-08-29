package com.billing.user.facade.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by xiaoyouyi on 2014-8-29.
 */
@Service
public class WyfCacheManager implements CacheManager {
    private static HashMap<String,Object> caches= new HashMap<>();
    /**
     * Acquires the cache with the specified <code>name</code>.  If a cache does not yet exist with that name, a new one
     * will be created with that name and returned.
     *
     * @param name the name of the cache to acquire.
     * @return the Cache with the given name
     * @throws org.apache.shiro.cache.CacheException if there is an error acquiring the Cache instance.
     */
    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        Object cache = caches.get(name);
        if(cache==null) {
            synchronized (caches) {
                cache = caches.get(name);
                if(cache==null) {
                    cache = new WyfCache<K, V>();
                    caches.put(name, cache);
                }
            }
        }
        return ( Cache<K, V>)cache;
    }
}
