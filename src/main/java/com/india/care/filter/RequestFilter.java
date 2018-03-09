package com.india.care.filter;

import com.india.care.constant.HealthConstants;
import org.slf4j.MDC;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

/**
 * @author : komal.nagar
 */
public class RequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MDC.clear();

        String clientId = requestContext.getHeaderString(HealthConstants.Header.CLIENT_ID);
        String clientHost = requestContext.getHeaderString(HealthConstants.Header.CLIENT_HOST);
        String clientIp = requestContext.getHeaderString(HealthConstants.Header.CLIENT_IP);
        String requestId = requestContext.getHeaderString(HealthConstants.Header.REQUEST_ID);

        MDC.put(HealthConstants.Header.CLIENT_ID, clientId);
        MDC.put(HealthConstants.Header.CLIENT_HOST, clientHost);
        MDC.put(HealthConstants.Header.CLIENT_IP, clientIp);
        MDC.put(HealthConstants.Header.REQUEST_ID, requestId);

        //do validations and throw exceptions right from here to avoid request accessing resources.
    }
}
