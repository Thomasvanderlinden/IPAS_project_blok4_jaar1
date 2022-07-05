let modal = document.getElementById("myModalShredded");
let btn = document.getElementById("shredButton");
let span = document.getElementsByClassName("close")[0];
btn.onclick = function () {
    modal.style.display = "block";
}
span.onclick = function () {
    modal.style.display = "none";
}
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}




let modal1 = document.getElementById("myModalLoseWeight");
let btn1 = document.getElementById("loseWeightButton");
let span1 = document.getElementById("dichtdoen");
btn1.onclick = function () {
    modal1.style.display = "block";
}
span1.onclick = function () {
    modal1.style.display = "none";
}
window.onclick = function (event) {
    if (event.target == modal) {
        modal1.style.display = "none";
    }
}



let modal2 = document.getElementById("myModalGainMuscleMass");
let btn2 = document.getElementById("gainMuscleMassButton");
let span2 = document.getElementById("dichtdoenGainMuscle");
btn2.onclick = function () {
    modal2.style.display = "block";
}
span2.onclick = function () {
    modal2.style.display = "none";
}
window.onclick = function (event) {
    if (event.target == modal) {
        modal2.style.display = "none";
    }
}

function printKnop(){
    window.print()
}











