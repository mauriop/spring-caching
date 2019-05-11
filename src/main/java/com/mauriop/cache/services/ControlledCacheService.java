package com.mauriop.cache.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ControlledCacheService {
    @Cacheable(cacheNames = "myControlledCache", key = "'myControlledPrefix_'.concat(#relevant)")
    public String getFromCache(String relevant) {
        return null;
    }

    @CacheEvict(cacheNames = "myControlledCache", key = "'myControlledPrefix_'.concat(#relevant)")
    public void removeFromCache(String relevant) {
    }

    @CachePut(cacheNames = "myControlledCache", key = "'myControlledPrefix_'.concat(#relevant)")
    public String populateCache(String relevant, String unrelevantTrackingId) {
        return "this is it again!";
    }
}
