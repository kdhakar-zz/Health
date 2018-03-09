package com.india.care.filter;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

/**
 * @author : komal.nagar
 */
@Slf4j
public class RequestFeature implements DynamicFeature {
    @Inject
    private RequestFilter requestFilter;

    @Inject
    private ResponseFilter responseFilter;

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {

        log.info("Registering request and response filters ...");
        context.register(requestFilter);
        context.register(responseFilter);
    }
}
