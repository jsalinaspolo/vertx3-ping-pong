package com.jspcore;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class Ping extends AbstractVerticle {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void start() {
        getVertx().setPeriodic(1000L, id -> {
            log.info("sending message ping...");
            getVertx().eventBus().send("ping-pong", "ping", response -> {
                if (response.succeeded()) log.info("success");
                else log.info("error?");
            });
        });

        log.info("Ping started");
    }

}
