package org.ajac.modules;

import com.google.inject.AbstractModule;
import io.github.cdimascio.dotenv.Dotenv;

public class DotenvModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Dotenv.class).toInstance(create());
    }

    private Dotenv create() {
        return Dotenv.configure()
          .filename("env")
          .ignoreIfMalformed()
          .ignoreIfMissing()
          .load();
    }
}
