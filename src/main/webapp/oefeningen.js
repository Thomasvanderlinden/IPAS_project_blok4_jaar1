let lijstje = document.getElementById('oefeningenLijst')

let knopAlles = document.getElementById('alles')
let knopBorst = document.getElementById('borst')
let knopRug = document.getElementById('rug')
let knopBicep = document.getElementById('bicep')
let knopTricep = document.getElementById('tricep')
let knopFavorieten = document.getElementById('favorieten')

//todo: misschien ook de knoppen in de filters, maar daar moet je nog ff over nadenken:

function vraagOefeningenOp(oefening) {
    return fetch('http://localhost:8080/restservices/oefeningen/' + oefening)
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}

function zetOefeningenOpPagina(oefeningen) {
    lijstje.innerHTML = '';
    for (let o of oefeningen) {
        lijstje.innerHTML += `<div  id="divoefeningen" class="oefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px">
                              </div>`
    }
}


knopAlles.addEventListener('click', vraagAllesOp)



function verstuurKnopDingen(event, x) {
    event.preventDefault()
    let data = {naam: x}
    return fetch('http://localhost:8080/restservices/oefeningen/favoriet', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
}

function vraagAllesOp() {
    vraagOefeningenOp("").then(oefeningen => {
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
vraagAllesOp()


//todo: popup dingen:
//
// function togglePopup(eve) {
//     eve.preventDefault()
//     document.getElementById("popup-1").classList.toggle("active");
// }
// function doeIets(event) {
//     event.preventDefault()
//     document.getElementById("popup-1").classList.toggle("active");
// }




knopBorst.addEventListener('click', e => {
    e.preventDefault()
    vraagOefeningenOp("borst").then(r => {
        return zetOefeningenOpPagina(r)
    })
})

knopRug.addEventListener('click', e => {
    e.preventDefault()
    vraagOefeningenOp("rug").then(r => {
        return zetOefeningenOpPagina(r)
    })
})

knopBicep.addEventListener('click', e => {
    e.preventDefault()
    vraagOefeningenOp("bicep").then(r => {
        return zetOefeningenOpPagina(r)
    })
})

knopTricep.addEventListener('click', e => {
    e.preventDefault()
    vraagOefeningenOp("tricep").then(r => {
        return zetOefeningenOpPagina(r)
    })
})

knopFavorieten.addEventListener('click', e => {
    e.preventDefault()
    vraagOefeningenOp("favoriet").then(oefeningen => {
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

function verwijderOefening(event, x) {
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

function verversPagina() {
    vraagOefeningenOp("favoriet").then(oefeningen => {
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
}






