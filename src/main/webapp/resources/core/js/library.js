/**
 * Created by Farkas on 2017.10.21..
 */

var sendDelete = function(id){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if(xmlhttp.readyState === XMLHttpRequest.DONE && xmlhttp.status === 200) {
            window.location.reload();
        }
    };
    xmlhttp.open("delete", "librarian");
    xmlhttp.setRequestHeader("Content-type",'application/json');
    xmlhttp.send(JSON.stringify({id:id}));
};

var bringBack = function(id){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if(xmlhttp.readyState === XMLHttpRequest.DONE && xmlhttp.status === 200) {
           window.location.reload();
        }
    };
    xmlhttp.open("DELETE", "librarian/lending");
    xmlhttp.setRequestHeader("Content-type",'application/json');
    xmlhttp.send(JSON.stringify({id:id}));
};

var lending = function(id, input){
    var lendedTo = document.getElementById("lendedTo" + input).value;
    if ("" === lendedTo){
        document.getElementById("lendedTo" + input).classList.add("error");
    }else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === XMLHttpRequest.DONE && xmlhttp.status === 200) {
                window.location.reload();
            }
        };
        xmlhttp.open("POST", "librarian/lending");
        xmlhttp.setRequestHeader("Content-type", 'application/json');
        xmlhttp.send(JSON.stringify({id: id, user: lendedTo}));
    }
};

var extend = function(id){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if(xmlhttp.readyState === XMLHttpRequest.DONE && xmlhttp.status === 200) {
            window.location.reload();
        }
    };
    xmlhttp.open("PUT", "user");
    xmlhttp.setRequestHeader("Content-type",'application/json');
    xmlhttp.send(JSON.stringify({id:id}));
};