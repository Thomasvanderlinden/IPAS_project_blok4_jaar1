function vraagTipsTricksOp() {
    return fetch('http://localhost:8080/restservices/tipsTricks')
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}


let lijstje = document.getElementById('tipsTricksLijst')

vraagTipsTricksOp().then(tips => {
    lijstje.innerHTML = '';
    for (let t of tips) {
        lijstje.innerHTML += `<div class="oefeningen">
                                   <h2>${t.tipnaam}</h2>
                                   <h3>${t.onderwerp}</h3>
                                   <p>${t.tekstVanDeTip}</p>
                                   <h4>${t.auteur}</h4> 
                              </div>`
    }
})





let knop = document.getElementById('opsturenTip')
let formulier = document.querySelector('#tipFormulier')


function versturenMaar(tip) {
    return fetch('http://localhost:8080/restservices/tipsTricks', {
        method: 'POST',
        body : JSON.stringify(tip),
        headers: {
            'Content-Type' : 'application/json'
        }
    })

}


//todo: nog kijken of we de lijst kunnen laten 'refreshen' met een functie, --> koffiecrud:

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





