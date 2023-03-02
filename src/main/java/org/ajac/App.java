package org.ajac;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.ajac.cronjobs.ExecutionJob;
import org.ajac.modules.DotenvModule;

public class App {

    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new DotenvModule());
        final ExecutionJob executionJob = injector.getInstance(ExecutionJob.class);
        executionJob.initialize();
    }
}