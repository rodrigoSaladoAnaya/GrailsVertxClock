package com.grailsvertx.clock

import groovy.transform.TypeChecked
import org.vertx.java.core.Handler
import org.vertx.java.core.Vertx
import org.vertx.java.core.http.HttpServer
import org.vertx.java.core.http.HttpServerRequest
import org.vertx.java.core.json.JsonArray
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.sockjs.SockJSServer

class JavaScriptBridgeService {

    @TypeChecked
    def start(Vertx vertx) {
        HttpServer httpServer = vertx.createHttpServer()

        def requestHandler = new Handler<HttpServerRequest>() {
            @Override
            void handle(HttpServerRequest request) {
                //something else ...
            }
        }

        httpServer.requestHandler(requestHandler)

        JsonArray permitted = new JsonArray();
        permitted.add(new JsonObject())

        SockJSServer sockJSServer = vertx.createSockJSServer(httpServer)
        sockJSServer.bridge(new JsonObject().putString('prefix', '/eventbus'), permitted, permitted)

        httpServer.listen(7564);
    }
}
