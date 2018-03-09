package com.india.care.di;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.india.care.config.HealthConfig;
import com.india.care.dal.cache.GuavaCache;

/**
 * @author : komal.nagar
 */
public class GuavaCacheProvider implements Provider<GuavaCache> {
    private final GuavaCache guavaCache;

    @Inject
    public GuavaCacheProvider(HealthConfig healthConfig) {
        guavaCache = new GuavaCache(healthConfig.getGuavaConfig());
    }

    @Override
    public GuavaCache get() {
        return guavaCache;
    }
}
