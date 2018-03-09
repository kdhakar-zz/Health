package com.india.care.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author : komal.nagar
 */
@Getter
@Setter
@ToString
public class C3p0Config {
    @NotNull
    @Valid
    private String minSize; // Min no of connections in the pool

    @NotNull
    @Valid
    private String maxSize; // Max no of connections in the pool

    @NotNull
    @Valid
    private String timeout; // idle connection timeout in seconds

    @NotNull
    @Valid
    private String maxStatements; // Max no of preparedStatements to be cached

    @NotNull
    @Valid
    private String idleTestPeriod; // idle connection testPeriod in seconds

    @NotNull
    @Valid
    private String acquireIncrement; // No of connections to acquire when the pool is exhausted
}
