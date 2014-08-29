package com.billing.user.facade.shiro;

import com.google.common.cache.*;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoyouyi on 2014-8-29.
 */
public class WyfCache<K, V> implements Cache<K, V> {
    private LoadingCache<K, V> graphs;

    public <K,V>WyfCache( ){
        graphs = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener(new RemovalListener(){
                    @Override
                    public void onRemoval(RemovalNotification notification) {

                    }
                })
                .build(
                        new CacheLoader<K, V>() {
                            public V load(K key) throws Exception {
                                return null; //todo
                                //return createExpensiveGraph(key);
                            }
                        });

    }
    /**
     * Returns the Cached value stored under the specified {@code key} or
     * {@code null} if there is no Cache entry for that {@code key}.
     *
     * @param key the key that the value was previous added with
     * @return the cached object or {@code null} if there is no entry for the specified {@code key}
     * @throws org.apache.shiro.cache.CacheException if there is a problem accessing the underlying cache system
     */
    @Override
    public V get(K key) throws CacheException {
        return graphs.getIfPresent(key);
    }

    /**
     * Adds a Cache entry.
     *
     * @param key   the key used to identify the object being stored.
     * @param value the value to be stored in the cache.
     * @return the previous value associated with the given {@code key} or {@code null} if there was previous value
     * @throws org.apache.shiro.cache.CacheException if there is a problem accessing the underlying cache system
     */
    @Override
    public V put(K key, V value) throws CacheException {

        graphs.put(key,value);
        return value;
    }

    /**
     * Remove the cache entry corresponding to the specified key.
     *
     * @param key the key of the entry to be removed.
     * @return the previous value associated with the given {@code key} or {@code null} if there was previous value
     * @throws org.apache.shiro.cache.CacheException if there is a problem accessing the underlying cache system
     */
    @Override
    public V remove(K key) throws CacheException {
        V v=  graphs.getIfPresent(key);
        graphs.invalidate(key);
        return v;
    }

    /**
     * Clear all entries from the cache.
     *
     * @throws org.apache.shiro.cache.CacheException if there is a problem accessing the underlying cache system
     */
    @Override
    public void clear() throws CacheException {
        graphs.invalidateAll();
    }

    /**
     * Returns the number of entries in the cache.
     *
     * @return the number of entries in the cache.
     */
    @Override
    public int size() {
        return (int)graphs.size();
    }

    /**
     * Returns a view of all the keys for entries contained in this cache.
     *
     * @return a view of all the keys for entries contained in this cache.
     */
    @Override
    public Set<K> keys() {
        throw new NotImplementedException("不支持");
    }

    /**
     * Returns a view of all of the values contained in this cache.
     *
     * @return a view of all of the values contained in this cache.
     */
    @Override
    public Collection<V> values() {
        throw new NotImplementedException("不支持");
    }
}
