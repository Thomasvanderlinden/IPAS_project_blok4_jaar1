let lijstje = document.getElementById('oefeningenLijst')

let knopAlles = document.getElementById('alles')
let knopBorst = document.getElementById('borst')
let knopRug = document.getElementById('rug')
let knopBicep = document.getElementById('bicep')
let knopTricep = document.getElementById('tricep')
let knopFavorieten = document.getElementById('favorieten')

//  vraag alle oefeningen op:
function vraagAlleOefeningeOp() {
    return fetch('http://localhost:8080/restservices/oefeningen')
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}

knopAlles.addEventListener('click', vraagAllesOp)

function doeIets(event) {
    event.preventDefault()
    document.getElementById("popup-1").classList.toggle("active");

}

function verstuurKnopDingen(event, x) {
    event.preventDefault()


    let data = {naam: x}
    console.log(x)

    return fetch('http://localhost:8080/restservices/oefeningen/favoriet', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
}


function togglePopup(eve) {
    eve.preventDefault()
    document.getElementById("popup-1").classList.toggle("active");
}

function vraagAllesOp() {
    vraagAlleOefeningeOp().then(oefeningen => {
        lijstje.innerHTML = '';
        for (let o of oefeningen) {
            lijstje.innerHTML += `



<span id="divoefeningen">

                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   
                                   <button id="knop" onclick="verstuurKnopDingen(event, '${o.naam}')" ><img src="${o.plaatje}" width="130px" height="110px"></button>
<!--                                   <button onclick="togglePopup(event)">beschrijving</button>-->
                              </span>`
        }
    })
}

//todo: kan evt het plaatje een knop maken

vraagAllesOp()


//vraag borst oefeningen op:
function vraagOefeningeOpBorst() {
    return fetch('http://localhost:8080/restservices/oefeningen/borst')
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}

knopBorst.addEventListener('click', e => {
    e.preventDefault()
    let lijstje = document.getElementById('oefeningenLijst')

    vraagOefeningeOpBorst().then(oefeningen => {
        lijstje.innerHTML = '';
        for (let o of oefeningen) {
            lijstje.innerHTML += `<div id="divoefeningen" class="oefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px">
                              </div>`
        }
    })

})


//vraag rug oefeningen op:
function vraagOefeningeOpRug() {
    return fetch('http://localhost:8080/restservices/oefeningen/rug')
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}

knopRug.addEventListener('click', e => {
    e.preventDefault()
    let lijstje = document.getElementById('oefeningenLijst')

    vraagOefeningeOpRug().then(oefeningen => {
        lijstje.innerHTML = '';
        for (let o of oefeningen) {
            lijstje.innerHTML += `<div id="divoefeningen" class="oefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px">
                              </div>`
        }
    })

})


//vraag bicep oefeningen op:
function vraagOefeningeOpBicep() {
    return fetch('http://localhost:8080/restservices/oefeningen/bicep')
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}

knopBicep.addEventListener('click', e => {
    e.preventDefault()
    let lijstje = document.getElementById('oefeningenLijst')

    vraagOefeningeOpBicep().then(oefeningen => {
        lijstje.innerHTML = '';
        for (let o of oefeningen) {
            lijstje.innerHTML += `<div  id="divoefeningen" class="oefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px">
                              </div>`
        }
    })

})


//vraag tricep oefeningen op:
function vraagOefeningeOpTricep() {
    return fetch('http://localhost:8080/restservices/oefeningen/tricep')
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}

knopTricep.addEventListener('click', e => {
    e.preventDefault()
    let lijstje = document.getElementById('oefeningenLijst')

    vraagOefeningeOpTricep().then(oefeningen => {
        lijstje.innerHTML = '';
        for (let o of oefeningen) {
            lijstje.innerHTML += `<div  id="divoefeningen">
                                    <div class="oefeningen">
                                        <h2>${o.naam}</h2>
                                        <p>${o.spiergroep}</p>
                                        <img src="${o.plaatje}" width="130px" height="110px">
                                    </div>`
        }
    })
})


//vraag favorieten oefeningen op:
function vraagOefeningeOpFavorieten() {
    return fetch('http://localhost:8080/restservices/oefeningen/favoriet')
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}

function verwijderOefening(event, x) {
    console.log(x)
    event.preventDefault()

    let data = {naam: x}
    return fetch('http://localhost:8080/restservices/oefeningen/favoriet', {
        method: 'DELETE',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(verversPagina)


}

knopFavorieten.addEventListener('click', e => {
    e.preventDefault()
    let lijstje = document.getElementById('oefeningenLijst')

    vraagOefeningeOpFavorieten().then(oefeningen => {
        lijstje.innerHTML = '';
        for (let o of oefeningen) {
            lijstje.innerHTML += `<div id="divoefeningen">
                                    <div class="oefeningen">
                                        <h2>${o.naam}</h2>
                                        <p>${o.spiergroep}</p>
                                        
                                        <button onclick="verwijderOefening(event, '${o.naam}' )"><img src="${o.plaatje}" width="130px" height="110px"></button>
                                    </div>`
        }
    })

})

function verversPagina() {
    let lijstje = document.getElementById('oefeningenLijst')

    vraagOefeningeOpFavorieten().then(oefeningen => {
        lijstje.innerHTML = '';
        for (let o of oefeningen) {
            lijstje.innerHTML += `<div id="divoefeningen">
                                    <div class="oefeningen">
                                    
                                        <h2>${o.naam}</h2>
                                        <p>${o.spiergroep}</p>
                                        
                                        <button type="button" onclick="verwijderOefening(event, '${o.naam}' )"><img src="${o.plaatje}" width="130px" height="110px"></button>
                                    </div>`
        }
    })

}






