package com.india.care;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.india.care.config.HealthConfig;
import com.india.care.exception.HealthServiceExceptionMapper;
import com.india.care.exception.HealthWarnExceptionMapper;
import com.india.care.filter.RequestFeature;
import com.india.care.health.ServiceHealth;
import com.india.care.manager.HealthManager;
import com.india.care.module.GuiceModule;
import com.india.care.resource.Doctor;
import com.india.care.resource.Hospital;
import com.india.care.resource.Infra;
import com.india.care.resource.Patient;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

/**
 * @author : komal.nagar
 */
@Slf4j
public class HealthApplication extends Application<HealthConfig> {

    public static void main(String[] args) throws Exception {
        new HealthApplication().run(args);
    }

    @Override
    public void run(HealthConfig configuration, Environment environment) throws Exception {
        log.info("Setting guice module ...");
        GuiceModule guiceModule = new GuiceModule(configuration);
        Injector injector = Guice.createInjector(guiceModule);

        //register resources
        registerResources(injector, environment);

        environment.lifecycle().manage(injector.getInstance(HealthManager.class));
        environment.healthChecks().register("Service health check", new ServiceHealth());

        registerLogger();
        log.info("Health application started ....");
    }

    private void registerResources(Injector injector, Environment environment) {
        log.info("Registering resources, filters and exception managers ...");
        //register resources
        environment.jersey().register(injector.getInstance(Doctor.class));
        environment.jersey().register(injector.getInstance(Hospital.class));
        environment.jersey().register(injector.getInstance(Patient.class));
        environment.jersey().register(injector.getInstance(Infra.class));

        //register request feature
        environment.jersey().register(injector.getInstance(RequestFeature.class));

        //register exceptions
        environment.jersey().register(injector.getInstance(HealthWarnExceptionMapper.class));
        environment.jersey().register(injector.getInstance(HealthServiceExceptionMapper.class));
        //similarly can register servlets.
    }

    private void registerLogger() throws JoranException {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.reset();

        ContextInitializer initializer = new ContextInitializer(context);
        initializer.autoConfig();
    }
}
