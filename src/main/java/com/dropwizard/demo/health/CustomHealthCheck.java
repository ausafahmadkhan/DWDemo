package com.dropwizard.demo.health;

import com.codahale.metrics.health.HealthCheck;

public class CustomHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
