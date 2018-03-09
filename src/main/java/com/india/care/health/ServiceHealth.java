package com.india.care.health;

import com.codahale.metrics.health.HealthCheck;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author : komal.nagar
 */
@Slf4j
@Path(value = "/rotation")
public class ServiceHealth extends HealthCheck {
    private static final String COMMAND_OOR = "oor";
    private static final String COMMAND_BIR = "bir";
    private static final String COMMAND_STATUS = "status";

    private static volatile boolean inRotation = false;

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }

    @GET
    @Path(value = "/{command}")
    public Response getRotationStatus(@PathParam("command") String command) {
        log.debug("Rotation request, command: {}", command);

        switch (command) {
            case COMMAND_OOR:
                inRotation = false;
                break;
            case COMMAND_BIR:
                inRotation = true;
                break;
            case COMMAND_STATUS:
                break;
            default:
                log.debug("Rotation command not supported");
                return Response.status(Response.Status.BAD_REQUEST).entity("Command not supported").build();
        }

        Response.Status responseStatus = inRotation ? Response.Status.OK : Response.Status.SERVICE_UNAVAILABLE;

        log.debug("Returning response: {}", responseStatus);
        return Response.status(responseStatus).build();
    }
}
