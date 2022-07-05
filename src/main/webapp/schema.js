let modal = document.getElementById("myModalShredded");
let btn = document.getElementById("shredButton");
let span = document.getElementsByClassName("close")[0];

let modal1 = document.getElementById("myModalLoseWeight");
let btn1 = document.getElementById("loseWeightButton");
let span1 = document.getElementById("dichtdoen");

let modal2 = document.getElementById("myModalGainMuscleMass");
let btn2 = document.getElementById("gainMuscleMassButton");
let span2 = document.getElementById("dichtdoenGainMuscle");


function laatSchermZien(btn, span, window) {
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
}

laatSchermZien(btn, span, modal)
laatSchermZien(btn1, span1, modal1)
laatSchermZien(btn2, span2, modal2)


function printKnop() {
    window.print()
}













