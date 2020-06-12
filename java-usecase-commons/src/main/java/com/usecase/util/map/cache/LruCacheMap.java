package com.usecase.util.map.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class LruCacheMap<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;

    public LruCacheMap(int cacheSize) {

        //true表示按照访问顺序
        super(CacheMapConfig.calculateCapacity(cacheSize),
                CacheMapConfig.DEFAULT_LOAD_FACTORY,
                true);

        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > CACHE_SIZE;
    }

    @Override
    public synchronized V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public synchronized void putAll(Map<? extends K, ? extends V> m) {
        super.putAll(m);
    }

    @Override
    public synchronized V putIfAbsent(K key, V value) {
        return super.putIfAbsent(key, value);
    }

    @Override
    public synchronized V remove(Object key) {
        return super.remove(key);
    }

    @Override
    public synchronized boolean remove(Object key, Object value) {
        return super.remove(key, value);
    }

    @Override
    public synchronized void clear() {
        super.clear();
    }

    @Override
    public synchronized boolean replace(K key, V oldValue, V newValue) {
        return super.replace(key, oldValue, newValue);
    }

    @Override
    public synchronized V replace(K key, V value) {
        return super.replace(key, value);
    }

    @Override
    public synchronized void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        super.replaceAll(function);
    }

    @Override
    public synchronized V merge(K key, V value,
                                BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return super.merge(key, value, remappingFunction);
    }
}
