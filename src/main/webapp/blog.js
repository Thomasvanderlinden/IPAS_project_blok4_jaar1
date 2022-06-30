let lijstje = document.getElementById('mijnLijst')
let knop = document.getElementById('opsturenBlog')
let formulier = document.querySelector('#artikelForumuler')

function loginMetFormulier() {
    if (window.sessionStorage.getItem("myJWT")) {
        document.forms.artikelForumuler.style = "display:block";
    } else {
        document.forms.artikelForumuler.style = "display:none";
    }
}
loginMetFormulier()


function haalBlogOp() {
    return fetch('http://localhost:8080/restservices/blog')
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
            lijstje.innerHTML += `<div class="blogArtikelen" <li> <h2> ${o.naam}</h2> <h3> ${o.onderwerp}</h3> <p>${o.tekst}</p></li></div>`

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
    return fetch('http://localhost:8080/restservices/blog', {
        method: 'POST',
        body: JSON.stringify(mening),
        headers: {
            'Content-Type': 'application/json', "Authorization": "Bearer " +window.sessionStorage.getItem("myJWT")
        }
    }).then(geefBogInformatieWeer)
}


//todo: foutmeldingen als een veld leeg is bij blog op tips
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
