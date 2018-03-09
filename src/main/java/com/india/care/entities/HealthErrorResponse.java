package com.india.care.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.india.care.enums.HealthError;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : komal.nagar
 */
@Slf4j
@Getter
public class HealthErrorResponse {
    private final HealthError healthError;
    private final String message;

    @JsonCreator
    public HealthErrorResponse(@JsonProperty("healthError") HealthError healthError,
                               @JsonProperty("message") String message) {
        this.healthError = healthError;
        this.message = message;
    }
}
