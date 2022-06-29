let lijstje = document.getElementById('oefeningenLijst')

let knopAlles = document.getElementById('alles')
let knopBorst = document.getElementById('borst')
let knopRug = document.getElementById('rug')
let knopBicep = document.getElementById('bicep')
let knopTricep = document.getElementById('tricep')


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

function doeIets(event){
    event.preventDefault()
    document.getElementById("popup-1").classList.toggle("active");

}


function vraagAllesOp() {
    vraagAlleOefeningeOp().then(oefeningen => {
        lijstje.innerHTML = '';
        for (let o of oefeningen) {
            lijstje.innerHTML += `
<div class="popup" id="popup-1">
  <div class="overlay"></div>
  <div class="content">
      <div class="close-btn" >&times;</div>

    <p>${o.omschrijving}</p>
  </div>
</div>


<button onclick="doeIets(event)"><div class="oefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px">
                              </div></button>`
        }
    })
}

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
            lijstje.innerHTML += `<button><div class="oefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px">
                              </div></button>`
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
            lijstje.innerHTML += `<button><div class="oefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px">
                              </div></button>`
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
            lijstje.innerHTML += `<button><div class="oefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px">
                              </div></button>`
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
            lijstje.innerHTML += `<div id="dezeDiv"><button id="knopId" class="knopVanDeOefening" ">
                                    <div class="oefeningen">
                                        <h2>${o.naam}</h2>
                                        <p>${o.spiergroep}</p>
                                        <img src="${o.plaatje}" width="130px" height="110px">
                                    </div>`
        }
    })
})











