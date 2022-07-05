let lijstje = document.getElementById('mijnLijst')
let knop = document.getElementById('opsturenBlog')
let formulier = document.querySelector('#artikelForumuler')

let heroku = "https://ipasproject.herokuapp.com/"
let localhost = 'http://localhost:8080/';
let url = localhost


function convert(array) {
    let list = document.createElement('div');
    for (let i of array) {
        let item = document.createElement('span');
        item.innerHTML = `<h2>${i.naam}</h2>  <h3>${i.onderwerp}</h3>  <p>${i.tekst}</p> <button class="verijderKnop" onclick="verwijderArtikel(event, '${i.naam}')">verwijder</button><br><div id="witruimte" style="height: 5px"  ></div><br>`;
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

function geefBlogInfoWeer() {
    haalBlogOp().then(lijst => {
        lijstje.innerHTML = ''
        for (let x of Object.keys(lijst)) {
            let naam = lijst[x]

            lijstje.innerHTML += `<div class="blogArtikelen">
                                   <div id="foo"><br></div>
                                    </div>`

            document.getElementById('foo').appendChild(convert(naam));
        }
    })
}

geefBlogInfoWeer()


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//formulier gedeelte

function loginMetFormulier() {
    if (window.sessionStorage.getItem("myJWT")) {
        document.forms.artikelForumuler.style = "display:block";
    } else {
        document.forms.artikelForumuler.style = "display:none";
    }
}

loginMetFormulier()


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
    }).then(geefBlogInfoWeer)
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


//verwijdergedeelte:
function verwijderArtikel(event, artikel){
    event.preventDefault()
    let data = {naam: artikel}
    return fetch(url + "restservices/blog", {
        method: 'DELETE',
        body: JSON.stringify(data),
        headers: {
            'Content-Type' : 'application/json', "Authorization": "Bearer " + window.sessionStorage.getItem("myJWT")
        }
    }).then(resp => {return resp.json()})
        .catch(error => alert("je bent niet ingelogd, dus dit is niet toegestaan")).then(geefBlogInfoWeer)

}


