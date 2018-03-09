package com.india.care.metric;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author : komal.nagar
 */
@Aspect
public class MetricsAspect {
    private static final MetricRegistry REGISTRY;

    static {
        REGISTRY = new MetricRegistry();
        JmxReporter.forRegistry(REGISTRY).inDomain("Health").build().start();
    }

    @Around("execution(public * com.india.care.dal*.*.*(..))")
    public Object report(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();

        Timer.Context timerContext = REGISTRY.timer(MetricRegistry.name(className, methodName)).time();

        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            REGISTRY.counter(MetricRegistry.name("Exception", "Count")).inc();
            throw e;
        } finally {
            timerContext.stop();
        }
    }
}
