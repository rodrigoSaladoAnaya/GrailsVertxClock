modules = {
    vertx {

    }

    application {
        dependsOn 'jquery'
        resource url: 'js/sockjs-0.3.4.min.js'
        resource url: 'js/vertxbus.min.js'
        resource url: 'js/application.js'
    }

}