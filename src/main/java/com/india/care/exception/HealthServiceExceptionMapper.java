package com.india.care.exception;

import com.india.care.entities.HealthErrorResponse;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author : komal.nagar
 */
@Slf4j
@Singleton
public class HealthServiceExceptionMapper implements ExceptionMapper<HealthServiceException> {

    @Override
    public Response toResponse(HealthServiceException exception) {
        HealthErrorResponse response = new HealthErrorResponse(exception.getHealthError(), exception.getMessage());
        return Response.status(response.getHealthError().getHttpStatusCode())
                .type(MediaType.APPLICATION_JSON)
                .entity(response)
                .build();
    }
}
