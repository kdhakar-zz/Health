package com.india.care.config;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author : komal.nagar
 */
@Setter
@Getter
@ToString
public class HealthConfig extends Configuration {
    //all the configuration needed in the project will go here.
    @NotNull
    @Valid
    @JsonProperty("guava")
    private GuavaConfig guavaConfig;

    @NotNull
    @Valid
    @JsonProperty("mysql")
    private MysqlConfig mysqlConfig;
}
