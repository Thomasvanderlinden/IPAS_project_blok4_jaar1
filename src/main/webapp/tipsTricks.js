let lijstje = document.getElementById('tipsTricksLijst')
let knop = document.getElementById('opsturenTip')
let formulier = document.querySelector('#tipFormulier')
let heroku = "https://ipasproject.herokuapp.com/"
let localhost = 'http://localhost:8080/';
let url = localhost

function loginMetFormulier() {
    if (window.sessionStorage.getItem("myJWT")) {
        document.forms.tipFormulier.style = "display:block";
    } else {
        document.forms.tipFormulier.style = "display:none";
    }
}

loginMetFormulier()


function vraagTipsTricksOp() {
    return fetch(url + 'restservices/tipsTricks')
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}

function geefTipsTricksInformatieWeer() {
    vraagTipsTricksOp().then(tips => {
        lijstje.innerHTML = '';
        for (let t of tips) {
            lijstje.innerHTML += `<div class="oefeningen">
                                   <h2>${t.tipnaam}</h2>
                                   <h3>${t.onderwerp}</h3>
                                   <p>${t.tekstVanDeTip}</p>
                                   <h4>${t.auteur}</h4> 
                                   <button id="verwijder" class="verwijderTip" onclick="verwijderTips(event, '${t.tipnaam}')">verwijder tip</button>
                              </div>`
        }
    })
}

geefTipsTricksInformatieWeer()



function verwijderTips(event, tip){
    event.preventDefault()
    let data = {tipnaam: tip}
    return fetch(url + "restservices/tipsTricks/", {
        method: 'DELETE',
        body: JSON.stringify(data),
        headers: {
            'Content-Type' : 'application/json', "Authorization": "Bearer " + window.sessionStorage.getItem("myJWT")
        }
    }).then(resp => {return resp.json()})
        .catch(error => alert("je bent niet ingelogd, dus dit is niet toegestaan")).then(geefTipsTricksInformatieWeer)

}



function versturenMaar(tip) {
    if (tip.tipnaam === "" || tip.auteur === "" || tip.onderwerp === "" || tip.tekstVanDeTip === "") {
        return alert("niet alle velden zijn ingevuld!")
    }

    return fetch(url + 'restservices/tipsTricks', {
        method: 'POST',
        body: JSON.stringify(tip),
        headers: {
            'Content-Type': 'application/json', "Authorization": "Bearer " + window.sessionStorage.getItem("myJWT")
        }
    }).then(geefTipsTricksInformatieWeer)
        .catch(error => alert(error))

}

knop.addEventListener('click', r => {
    r.preventDefault()
    let rauweData = new FormData(formulier)
    let tip = {
        tipnaam: rauweData.get('tipnaam'),
        onderwerp: rauweData.get('onderwerp'),
        tekstVanDeTip: rauweData.get('tekstVanDeTip'),
        auteur: rauweData.get('auteur'),
    }
    versturenMaar(tip)

})






