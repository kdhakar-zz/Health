package com.india.care.config;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class MysqlConfig {
    @NotNull
    @Valid
    private String url;

    @NotNull
    @Valid
    private String driver;

    @NotNull
    @Valid
    private String username;

    @NotNull
    @Valid
    private String password;

    @NotNull
    @Valid
    private String queryTimeout;        // milliseconds

    @NotNull
    @Valid
    private String connectionProvider;

    @NotNull
    @Valid
    @JsonProperty("c3p0")
    private C3p0Config c3P0Config;
}
