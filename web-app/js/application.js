var setClockBody = function (eventBus) {
    var address = 'clock-address'
    eventBus.registerHandler(address, function (message) {
        $("#clock").html(message);
    });
}

var setNews = function(eventBus) {
    var address = 'news-address'
    eventBus.registerHandler(address, function (message) {
        $("#news").html(message);
    });
}

$(document).ready(function () {
    if(!$("#news").html()) {
        $("#news").html("NotiGrails no tiene nada que decir... :'(");
    }

    var eventBus = null;
    if (!eventBus) {
        eventBus = new vertx.EventBus("http://localhost:7564/eventbus");
    }

    eventBus.onopen = function () {
        setClockBody(eventBus);
        setNews(eventBus)
    }
});