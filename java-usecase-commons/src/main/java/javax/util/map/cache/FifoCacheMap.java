package javax.util.map.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class FifoCacheMap<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;

    public FifoCacheMap(int cacheSize) {

        //为false或者是默认的时候，按插入顺序排序
        super(CacheMapConfig.calculateCapacity(cacheSize),
                CacheMapConfig.DEFAULT_LOAD_FACTORY,
                false);

        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > CACHE_SIZE;
    }
}
