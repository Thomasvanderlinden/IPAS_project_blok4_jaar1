var modal = document.getElementById("myModalShredded");
// Get the button that opens the modal
var btn = document.getElementById("shredButton");
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
// When the user clicks the button, open the modal
btn.onclick = function () {
    modal.style.display = "block";
}
// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

var modal1 = document.getElementById("myModalLoseWeight");
// Get the button that opens the modal
var btn1 = document.getElementById("loseWeightButton");
// Get the <span> element that closes the modal
var span1 = document.getElementById("dichtdoen");
// When the user clicks the button, open the modal
btn1.onclick = function () {
    modal1.style.display = "block";
}
// When the user clicks on <span> (x), close the modal
span1.onclick = function () {
    modal1.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal1.style.display = "none";
    }
}

var modal2 = document.getElementById("myModalGainMuscleMass");
// Get the button that opens the modal
var btn2 = document.getElementById("gainMuscleMassButton");
// Get the <span> element that closes the modal
var span2 = document.getElementById("dichtdoenGainMuscle");
// When the user clicks the button, open the modal
btn2.onclick = function () {
    modal2.style.display = "block";
}
// When the user clicks on <span> (x), close the modal
span2.onclick = function () {
    modal2.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal2.style.display = "none";
    }
}














