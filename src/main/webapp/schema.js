

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









let bankdrukken = document.getElementById('bankdrukken')

bankdrukken.options[1].disabled = true


document.getElementById('knopShredded').addEventListener('click', e => {
        e.preventDefault()
        bankdrukken.options[1].disabled = false
    }
)


