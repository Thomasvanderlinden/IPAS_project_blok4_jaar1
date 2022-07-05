let lijstje = document.getElementById('oefeningenLijst')

let knopAlles = document.getElementById('alles')
let knopBorst = document.getElementById('borst')
let knopRug = document.getElementById('rug')
let knopBicep = document.getElementById('bicep')
let knopTricep = document.getElementById('tricep')
let knopFavorieten = document.getElementById('favorieten')


let heroku = "https://ipasproject.herokuapp.com/"
let localhost = 'http://localhost:8080/';
let url = localhost

//todo: misschien ook de knoppen in de filters, maar daar moet je nog ff over nadenken:

function vraagOefeningenOp(oefening) {
    return fetch(url + 'restservices/oefeningen/' + oefening)
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}

function fietsHetErin(oefening) {
    lijstje.innerHTML = '';
    lijstje.innerHTML += `
                              <div id="divoefeningen1" ">
                                   <h2>${oefening.naam}</h2>
                                   <p>${oefening.omschrijving}</p>
                                   <img src="${oefening.plaatje}"  height="250px" width="250px">
                                   <p>tijdsduur oefening: ${oefening.tijd} <br>
                                      verbrande kcal: ${oefening.verbrande_kcal} <br>
                                      spiergroep: ${oefening.spiergroep} <br>  
                                   </p>
                              </div>`
}


function vraagOefeningInformatieOp(event, oefening) {
    event.preventDefault()
    return fetch(url + 'restservices/oefeningen/' + oefening)
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        }).then(r => fietsHetErin(r))
}


function zetOefeningenOpPagina(oefeningen) {
    lijstje.innerHTML = '';
    for (let o of oefeningen) {
        lijstje.innerHTML += `<div  id="divoefeningen" class="oefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px">
                                   <button class="bekijkoefeningknop" onclick="vraagOefeningInformatieOp(event, '${o.naam}')"> bekijk oefening</button>
                              </div>`
    }
}


knopAlles.addEventListener('click', vraagAllesOp)


function verstuurKnopDingen(event, x) {
    event.preventDefault()
    let data = {naam: x}
    return fetch(url + 'restservices/oefeningen/favoriet', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => response.json())
        .catch(error => alert("oefening staat al in je favorieten"))
}


function vraagAllesOp() {
    vraagOefeningenOp("").then(oefeningen => {
        lijstje.innerHTML = '';
        for (let o of oefeningen) {
            lijstje.innerHTML += `
                                <div id="divoefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px">
                                   <button class="knop" onclick="verstuurKnopDingen(event, '${o.naam}')" ><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGzILTx5kgB2r7C2WkE0jFBndDjacCJeR0lg&usqp=CAU" width="20px he
                                   20px"></button>
                              </div>`
        }
    })
}

vraagAllesOp()


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
                                        <img src="${o.plaatje}" width="130px" height="110px">
                                        <button class="verwijder" onclick="verwijderOefening(event, '${o.naam}')"><img src="https://icon-library.com/images/remove-icon/remove-icon-9.jpg" width="20px" height="20px"></button>
                                    </div>`
        }
    })
})

function verwijderOefening(event, oefening) {
    event.preventDefault()
    let data = {naam: oefening}
    return fetch(url + 'restservices/oefeningen/favoriet', {
        method: 'DELETE',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).catch(error => alert("er is iets fout gegaan"))
        .then(verversPagina)


}

function verversPagina() {
    vraagOefeningenOp("favoriet").then(oefeningen => {
        lijstje.innerHTML = '';
        for (let o of oefeningen) {
            lijstje.innerHTML += `<div id="divoefeningen">
                                    <div class="oefeningen">
                                    
                                        <h2>${o.naam}</h2>
                                        <p>${o.spiergroep}</p>
                                        <img src="${o.plaatje}" width="130px" height="110px">
                                        <button onclick="verwijderOefening(event, '${o.naam}' )"><img src="https://icon-library.com/images/remove-icon/remove-icon-9.jpg" width="20px" height="20px"></button>
                                    </div>`
        }
    })
}






