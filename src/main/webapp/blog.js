let lijstje = document.getElementById('mijnLijst')
let knop = document.getElementById('opsturenBlog')
let formulier = document.querySelector('#artikelForumuler')
let heroku = "https://ipasproject.herokuapp.com/"
let localhost = 'http://localhost:8080/';
let url = localhost


function loginMetFormulier() {
    if (window.sessionStorage.getItem("myJWT")) {
        document.forms.artikelForumuler.style = "display:block";
    } else {
        document.forms.artikelForumuler.style = "display:none";
    }
}

loginMetFormulier()



function makeUL(array) {
    let list = document.createElement('ul');

    for (let i = 0; i < array.length; i++) {
        let item = document.createElement('li');

        item.appendChild(document.createTextNode(array[i]));

        list.appendChild(item);
    }
    return list;
}

function haalBlogOp() {
    return fetch(url + 'restservices/blog')
        .then(r => {
            return r.json()
        })
        .then(j => {
            return j
        })
        .then(r => {
            geefBogInformatieWeer(r)
        })
}
haalBlogOp()

function geefBogInformatieWeer(artikel) {
    lijstje.innerHTML = '';
    lijstje.innerHTML += `
<div class="blogArtikelen" 
    <div id="fooo"> </div>
</div>`
    document.getElementById('fooo').appendChild(makeUL(artikel));



}

geefBogInformatieWeer()
//todo: misschien tips doen voor gebruikers en artikelen voor de admin:
//todo: knop wit houden als je erop hebt gedrukt
//todo: hier misschien nog auth invoeren:
function versturenMeningNaarServer(mening) {
    if (mening.naam === "" || mening.tekst === "" || mening.onderwerp === "") {
        return alert("niet alle velden zijn ingevuld!")
    }
    return fetch(url + 'restservices/blog', {
        method: 'POST',
        body: JSON.stringify(mening),
        headers: {
            'Content-Type': 'application/json', "Authorization": "Bearer " + window.sessionStorage.getItem("myJWT")
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
