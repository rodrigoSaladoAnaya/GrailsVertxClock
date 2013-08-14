package com.grailsvertx.clock

import org.vertx.java.core.Vertx
import org.vertx.java.core.VertxFactory
import org.vertx.java.core.eventbus.EventBus

class VerticlesManagerService {

    def Vertx vertx
    def EventBus evetBus

    def grailsApplication

    /** Verticles */
    def javaScriptBridgeService
    def clockVerticleService

    private void createVertxInstance() {
        vertx = VertxFactory.newVertx(grailsApplication.config.vertx.host)
        evetBus = vertx.eventBus()
    }

    void loadVerticles() {
        this.createVertxInstance()

        javaScriptBridgeService.start(vertx)
        clockVerticleService.sendMessage(vertx, evetBus)
    }
}
