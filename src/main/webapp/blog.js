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
    let list = document.createElement('div');
    for (let i of array) {
        let item = document.createElement('span');
        item.innerHTML = `<h2>${i.naam}</h2>  <h2>${i.onderwerp}</h2>  <p>${i.tekst}</p> <br>`;
        list.appendChild(item)
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

}


function geefinfoWeer() {
    haalBlogOp().then(lijst => {
        lijstje.innerHTML = ''
        for (let x of Object.keys(lijst)) {
            let naam = lijst[x]

            lijstje.innerHTML += `<div class="blogArtikelen">
                                   <div id="foo"><strong>blogDingen:</strong><br></div>
</div>`

            document.getElementById('foo').appendChild(makeUL(naam));
        }
    })
}


geefinfoWeer()


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
    }).then(geefinfoWeer)
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
