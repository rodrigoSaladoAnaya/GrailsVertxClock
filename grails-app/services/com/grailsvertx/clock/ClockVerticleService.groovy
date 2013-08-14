package com.grailsvertx.clock

import org.vertx.java.core.Handler
import org.vertx.java.core.Vertx
import org.vertx.java.core.eventbus.EventBus

class ClockVerticleService {

    def sendMessage(Vertx vertx, EventBus eventBus) {
        def address = 'clock-address'
        log.info "sending..."
        vertx.setPeriodic(1000, new Handler<Long>() {
            @Override
            void handle(Long e) {
                eventBus.publish(address, new Date().format("yyyy-MM-dd hh:ss"))
            }
        })
    }
}
