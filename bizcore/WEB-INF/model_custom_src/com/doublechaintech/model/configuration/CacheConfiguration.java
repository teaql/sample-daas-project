package com.doublechaintech.model.configuration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

public class CacheConfiguration {
  public CacheManager devCacheManager() {
    return new ConcurrentMapCacheManager();
  }
}


