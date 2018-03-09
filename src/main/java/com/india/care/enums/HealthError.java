package com.india.care.enums;

import lombok.Getter;
import org.eclipse.jetty.http.HttpStatus;

/**
 * @author : komal.nagar
 */
@Getter
public enum HealthError {
    INTERNAL_SERVER_ERROR("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR_500);

    private final String message;
    private final int httpStatusCode;

    HealthError(String message, int httpStatusCode) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
}
