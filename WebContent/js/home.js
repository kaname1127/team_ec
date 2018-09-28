function moveX(targetId,yoko){
    var targettes = document.getElementById(targetId);
    var pointX = "opacity:1; transform: translateX("+yoko+"%);";
    targettes.style.cssText =pointX;
}

function moveY(targetId){
    var targettes = document.getElementById(targetId);
    var target = "opacity:1; transform: translateY(0%);";
    targettes.style.cssText =target;
}

function moveX2(targetId,yoko){
    var targettes = document.getElementById(targetId);
    var pointX = "opacity:1; transform: translateX("+yoko+"%);";
    targettes.style.cssText =pointX;
}

function reset(targetId){
    var targettes = document.getElementById(targetId);
    targettes.style.cssText ="";
}

function reset_anime(target){
    target.style.cssText = "animation-name: btn_move;";
}


function idou(goal,btn){

    document.getElementById(goal).scrollIntoView(true);
    btn.style.cssText = "animation-name: btn_size; animation-duration: 0.2s; animation-timing-function: ease-in;";
}

function load() {
    var target = document.body;
    target.style.cssText = "opacity:1;";
}

window.onload = load;



window.onscroll = function(){
    var scrollpoint = window.pageYOffset;
    var SH = window.innerHeight-1;

    if
    (SH*1 < scrollpoint && SH*2 > scrollpoint)
    {moveX2("aboutpic",0); moveY("textbox2")}
    if
    (SH*2 < scrollpoint && SH*3 > scrollpoint)
    {moveX("tes1",0); moveY("up1"); moveY("title1"); reset("aboutpic"); reset("textbox2")}
    if
    (SH*3 < scrollpoint && SH*4 > scrollpoint)
    {moveX("tes2",0); moveY("up2"); moveY("title2"); reset("tes1"); reset("up1"); reset("title1")}
    if
    (SH*4 < scrollpoint && SH*5 > scrollpoint)
    {moveX("tes3",0); moveY("up3"); moveY("title3"); reset("tes2"); reset("up2"); reset("title2")}
    if
    (SH*5 < scrollpoint && SH*6 > scrollpoint)
    {moveX("map_pic",0); moveY("infotext"); reset("tes3"); reset("up3"); reset("title3")}

}