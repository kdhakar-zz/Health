package com.india.care.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import com.india.care.config.HealthConfig;
import com.india.care.dal.cache.GuavaCache;
import com.india.care.di.GuavaCacheProvider;

/**
 * @author : komal.nagar
 */
public class GuiceModule implements Module {
    private final HealthConfig healthConfig;

    public GuiceModule(HealthConfig healthConfig) {
        this.healthConfig = healthConfig;
    }

    @Override
    public void configure(Binder binder) {
        //all the bindings and configs will go here.
        binder.bind(HealthConfig.class).toInstance(healthConfig);
        binder.bind(GuavaCache.class).toProvider(GuavaCacheProvider.class).in(Singleton.class);
    }
}
