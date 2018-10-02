"use strict";

function hide() {
    $("#fail").fadeOut();
    $("#success").fadeOut();
}

function createThreads(count) {
    var url = window.location.href;
    url += "/createThreads" + "?threadCount=" + count;
    makeGetRequest(url);
}

function gc() {
    var url = window.location.href;
    url += "/gc";
    makeGetRequest(url);
}

function ramLoad(MiB) {
    var url = window.location.href;
    url += "/loadRam?mem=" + MiB;
    makeGetRequest(url);
}

function cpuLoad() {
    var url = window.location.href;
    url += "/loadCpu";
    makeGetRequest(url);
}

function makeGetRequest(url) {
    hide();
    $.ajax({
        url: url,
        method: "GET"
    })
        .done(function() {
            $("#success").fadeIn();
        })
        .fail(function() {
            $("#fail").fadeIn();
        });
}

function init() {
    $.get('../commit.sha1', function (data) {
       $("footer").append(data); 
    });
    $.ajax({
        url: "http://pseudorandom.name",
        method: "GET"
    })
        .done(function(data) {
            var tmp = document.createElement('html');
            tmp.innerHTML = data;
            $(".random-name").html($('h1', tmp).html());
        });
}
