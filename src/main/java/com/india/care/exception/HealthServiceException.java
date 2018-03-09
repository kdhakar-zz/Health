package com.india.care.exception;

import com.india.care.enums.HealthError;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : komal.nagar
 */
@Getter
@Setter
@ToString
public class HealthServiceException extends Exception {
    private final String message;
    private final HealthError healthError;

    public HealthServiceException(HealthError healthError, Object... arguments) {
        super();
        this.healthError = healthError;
        this.message = String.format(healthError.getMessage(), arguments);
    }
}
