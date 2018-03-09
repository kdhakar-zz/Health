package com.india.care.resource;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author : komal.nagar
 */
@Slf4j
@Path("/care/v1/doctor/")
public class Doctor {

    /*
    method to provide doctor availability for a particular hospital and department on a date.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableDoctors(@QueryParam("hospital") String hospital,
                                        @QueryParam("department") String department,
                                        @QueryParam("date") String date) {

        return Response.ok().build();
    }
}
