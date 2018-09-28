document.getElementById("headerbutton").onclick = function(){
    target1 = document.getElementById("headerreturnbutton_delete");
    target1.id = "headerreturnbutton";

    target2 = document.getElementById("header");
    target2.id = "header_delete";
}

document.getElementById("headerreturnbutton").onclick = function(){
    target1 = document.getElementById("headerreturnbutton");
    target1.id = "headerreturnbutton_delete";

    target2 = document.getElementById("header_delete");
    target2.id = "header";
}


