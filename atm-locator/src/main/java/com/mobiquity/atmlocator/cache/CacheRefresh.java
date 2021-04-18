package com.mobiquity.atmlocator.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Utility class to refresh caches every 6 minutes.
 * @author tbabu
 *
 */
@Service
public class CacheRefresh {

	@Autowired
    CacheManager cacheManager;

    public void refreshAllCaches() {
        cacheManager.getCacheNames().stream()
          .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
       
    }

    /**
     * Spring managed cache will be refresed every 6 minutes to get latest atm's
     */
    @Scheduled(fixedRate = 600000)
    public void refreshAllcachesAtIntervals() {
        refreshAllCaches();
    }

}
