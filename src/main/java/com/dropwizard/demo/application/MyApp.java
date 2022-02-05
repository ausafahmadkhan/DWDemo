package com.dropwizard.demo.application;


import com.dropwizard.demo.configuration.MyConfig;
import com.dropwizard.demo.health.CustomHealthCheck;
import com.dropwizard.demo.module.AppModule;
import com.google.inject.Stage;
import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class MyApp extends Application<MyConfig>
{
    private static final String PACKAGE_NAME = "com.dropwizard.demo";

    @Override
    public void initialize(Bootstrap<MyConfig> bootstrap) {

        GuiceBundle guiceBundle = GuiceBundle.builder()
                .enableAutoConfig(PACKAGE_NAME)
                .modules(new AppModule(bootstrap))
                .build(Stage.DEVELOPMENT);


        bootstrap.addBundle(guiceBundle);
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());

    }

    @Override
    public void run(MyConfig configuration, Environment environment) throws Exception
    {
        environment.healthChecks().register("DropWizard App", new CustomHealthCheck());
    }

    public static void main(String[] args) throws Exception {
        new MyApp().run("server", "config.yaml");
    }
}
