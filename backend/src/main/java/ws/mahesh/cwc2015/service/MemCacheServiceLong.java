package ws.mahesh.cwc2015.service;

import com.google.appengine.api.memcache.jsr107cache.GCacheFactory;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheManager;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import ws.mahesh.cwc2015.models.SimpleScore;


public class MemCacheServiceLong {


    private static final Logger logger = Logger.getLogger(MemCacheServiceLong.class.getName());

    private static final String LIVEFEED = "LIVEFEED";
    private static final int TIMEOUT_SECONDS = 600;

    private Cache cache;


    @SuppressWarnings({"unchecked", "rawtypes"})
    public MemCacheServiceLong() {
        try {
            Map properties = new HashMap();
            properties.put(GCacheFactory.EXPIRATION_DELTA, TIMEOUT_SECONDS);
            cache = CacheManager.getInstance().getCacheFactory().createCache(properties);
        } catch (CacheException e) {
            logger.severe(e.getMessage());
        }

    }

    public String getNewsFeed() {
        return (String)cache.get(LIVEFEED);
    }

    public void putNewsFeed(String newsFeed) {
        if (newsFeed == null) {
            logger.warning("Newsfeed is null");
            return;
        }
        cache.put(LIVEFEED, newsFeed);
    }
}
