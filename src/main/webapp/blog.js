let lijstje = document.getElementById('mijnLijst')
let knop = document.getElementById('opsturenBlog')
let formulier = document.querySelector('#artikelForumuler')
let heroku = "https://ipasproject.herokuapp.com/"
let localhost = 'http://localhost:8080/';
let url = heroku


function loginMetFormulier() {
    if (window.sessionStorage.getItem("myJWT")) {
        document.forms.artikelForumuler.style = "display:block";
    } else {
        document.forms.artikelForumuler.style = "display:none";
    }
}
loginMetFormulier()


function haalBlogOp() {
    return fetch(url + 'restservices/blog')
        .then(r => {
            return r.json()
        })
        .then(j => {
            return j
        })
}

function geefBogInformatieWeer() {
    haalBlogOp().then(x => {
        lijstje.innerHTML = '';
        for (let o of x) {
            lijstje.innerHTML += `<div class="blogArtikelen" <li> <h2> ${o.naam}</h2> <h8> ${o.onderwerp}</h8> <p>${o.tekst}</p></li></div>`

        }
    })
}
geefBogInformatieWeer()
//todo: misschien tips doen voor gebruikers en artikelen voor de admin:
//todo: knop wit houden als je erop hebt gedrukt
//todo: hier misschien nog auth invoeren:
function versturenMeningNaarServer(mening) {
    if(mening.naam === "" || mening.tekst === "" || mening.onderwerp === ""){
        return alert("niet alle velden zijn ingevuld!")
    }
    return fetch(url + 'restservices/blog', {
        method: 'POST',
        body: JSON.stringify(mening),
        headers: {
            'Content-Type': 'application/json', "Authorization": "Bearer " +window.sessionStorage.getItem("myJWT")
        }
    }).then(geefBogInformatieWeer)
}


knop.addEventListener('click', r => {
    r.preventDefault()

    let rauweData = new FormData(formulier)

    let mening = {
        naam: rauweData.get('naam'),
        onderwerp: rauweData.get('onderwerp'),
        tekst: rauweData.get('tekst')
    }
    versturenMeningNaarServer(mening)

})
