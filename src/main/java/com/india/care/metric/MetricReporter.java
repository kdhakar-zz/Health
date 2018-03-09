package com.india.care.metric;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.concurrent.TimeUnit;

/**
 * @author : komal.nagar
 */
public class MetricReporter {
    private static final MetricRegistry METRIC;

    static {
        METRIC = new MetricRegistry();
        JmxReporter.forRegistry(METRIC).convertRatesTo(TimeUnit.SECONDS).build().start();
    }

    public static void meter(String metricName) {
        METRIC.meter(metricName).mark();
    }

    public static Timer.Context timer(String metricName) {
        return METRIC.timer(metricName).time();
    }

    public static void counter(String metricName) {
        METRIC.counter(metricName).inc();
    }
}
