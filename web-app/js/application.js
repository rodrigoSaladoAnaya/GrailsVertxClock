$(document).ready(function(){
    var eventBus = null;
    if(!eventBus) {
        eventBus = new vertx.EventBus("http://localhost:7564/eventbus");
    }

    eventBus.onopen = function(){
        var address = 'clock-address'
        eventBus.registerHandler(address, function(message) {
            //console.log("message: " + message);
            $("#output-clock").html(message);
        });
    }
});