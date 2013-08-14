/**
 * To test:
 * server: run NewsVerticle.groovy -cluster -cluster-port 5463 -cluster-host 127.0.0.1
 * client: telnet localhost 1234
 */

def eb = vertx.eventBus
def address = 'news-address'
def server = vertx.createNetServer()

server.connectHandler { sock ->
    sock.dataHandler { buffer ->
        eb.publish(address, "NotiGrails informa: $buffer".toString())
    }
}.listen(1234, "localhost")