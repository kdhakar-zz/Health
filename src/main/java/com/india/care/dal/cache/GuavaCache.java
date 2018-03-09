package com.india.care.dal.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.india.care.config.GuavaConfig;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author : komal.nagar
 */
@Slf4j
@Setter
public class GuavaCache<K, V> {
    private final long maxEntries;
    private final long expiry;
    private Cache<String, Object> cache;

    public GuavaCache(GuavaConfig config) {
        this.maxEntries = config.getMaxEntries();
        this.expiry = config.getExpiry();
    }

    public void init() {
        cache = CacheBuilder.newBuilder()
                .maximumSize(maxEntries)
                .expireAfterWrite(expiry, TimeUnit.SECONDS)
                .build();

        log.info("Created guava cache with maxEntries : {} and expire after write in : {}min", maxEntries, expiry / 60);
    }

    public void put(String key, byte[] data) {
        cache.put(key, data);
    }

    public void put(Map<? extends K, ? extends V> map) {
        if (MapUtils.isNotEmpty(map)) {
            cache.putAll((Map<? extends String, ?>) map);
        }
    }

    public Map<String, Object> get(Set<String> keys) {
        return cache.getAllPresent(keys);
    }

    public void delete(List<String> keys) {
        cache.invalidateAll(keys);
    }

    /**
     * Shuts down and cleans guava cache content.
     */
    public void shutdown() {
        log.info("Shutting Down and flushing guava cache content");
        //clean guava cache data. if it was created.
        if (cache != null) {
            cache.invalidateAll();
            cache = null;
        }
    }
}
