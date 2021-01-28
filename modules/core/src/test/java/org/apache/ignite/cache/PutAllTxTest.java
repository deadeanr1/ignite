package org.apache.ignite.cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.testframework.junits.common.GridCommonAbstractTest;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class PutAllTxTest extends GridCommonAbstractTest {
    @Test
    public void testPutAll() throws Exception {
        Ignition.start(getConfiguration("server1"));
        Ignition.start(getConfiguration("server2"));
        Ignite ignite = Ignition.start(getConfiguration("client").setClientMode(true));

        IgniteCache<Integer, Integer> cache = ignite.createCache(
                new CacheConfiguration<Integer, Integer>("c")
                        .setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL));

        int count = 50000;

        Map<Integer, Integer> data = new TreeMap<>();
        for (int i = 0; i < count; i++)
            data.put(i, i);

        long begin = System.nanoTime();

        cache.putAll(data);

        long dur = System.nanoTime() - begin;
        System.out.println(">>>>> " + dur / 1000000);
    }
}
