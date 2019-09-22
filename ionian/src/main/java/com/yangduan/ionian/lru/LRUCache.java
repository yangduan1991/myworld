package com.yangduan.ionian.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yangduan
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    public final int CACHE_SIZE;

    public LRUCache(int size) {
        super((int) Math.ceil(size/0.75f + 1), 0.75f, true);
        this.CACHE_SIZE = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}
