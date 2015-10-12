package com.jspcore;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class Pong extends AbstractVerticle {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void start() {
        getVertx().eventBus().consumer("ping-pong", message -> {
            log.info(String.format("ping-pong receive: %s", message));
            message.reply("pong");
        }).completionHandler(event -> {
            if (event.succeeded()) log.info("complete handler");
            else log.info("failed");
        });
        log.info("Pong started");
    }

}
