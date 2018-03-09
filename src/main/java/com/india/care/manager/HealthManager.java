package com.india.care.manager;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.india.care.dal.cache.GuavaCache;
import io.dropwizard.lifecycle.Managed;

/**
 * @author : komal.nagar
 */
@Singleton
public class HealthManager implements Managed {
    @Inject
    private GuavaCache guavaCache;
    //put databases or connection managers which needs to be started and stopped.

    @Override
    public void start() throws Exception {
        guavaCache.init();
    }

    @Override
    public void stop() throws Exception {
        guavaCache.shutdown();
    }
}
