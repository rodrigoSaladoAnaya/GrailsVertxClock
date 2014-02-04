package com.grailsvertx.clock

import groovy.transform.TypeChecked
import org.vertx.java.core.Handler
import org.vertx.java.core.Vertx
import org.vertx.java.core.eventbus.EventBus

class ClockVerticleService {

  def sendMessage(Vertx vertx, EventBus eventBus) {
    def address = 'clock-address'
    def handler = { Long e -> 
      eventBus.publish(address, new Date().format("yyyy-MM-dd hh:ss")) 
    } as Handler<Long>
    vertx.setPeriodic(1000, handler)
  }
}
