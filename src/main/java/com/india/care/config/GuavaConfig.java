package com.india.care.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : komal.nagar
 */
@Getter
@Setter
@ToString
public class GuavaConfig {
    private long maxEntries;
    private long expiry;
}
