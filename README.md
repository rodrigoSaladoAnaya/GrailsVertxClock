GrailsVertxClock
================

It´s an example how to integrate Grails 2.2.X and vertx 2.0.X, making a simple clock using a eventBus bridge in web page.
and sending news using a external cluster vertx instance.

Steps to try:

0. Grails and Vertx need to be installed before follow the steps.

1. git clone https://github.com/rodrigoSaladoAnaya/GrailsVertxClock.git

2. cd GrailsVertxClock

3. grials run-app

4. uninstall InternetExplorer

5. open 2 diferents browsers like FireFox and Chrome, set the url http://localhost:8080/GrailsVertxClock

6. run server in a terminal:

    run NewsVerticle.groovy -cluster -cluster-port 5463 -cluster-host 127.0.0.1

7. run client in a terminal:

    telnet localhost 1234

8. write news in a client

9. take a look the browsers.

10 modifying enjoy it.


