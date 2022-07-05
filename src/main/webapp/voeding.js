let heroku = "https://ipasproject.herokuapp.com/"
let localhost = 'http://localhost:8080/';
let url = heroku

let lijstje = document.getElementById('receptenLijst')



function haalReceptenOp() {
    return fetch(url + 'restservices/voeding')
        .then(r => {
            return r.json()
        })
        .then(p => {
            return p
        })
}

function haalReceptInformatieOp(event, naam) {
    event.preventDefault()
    return fetch(url + 'restservices/voeding/' + naam)
        .then(r => {
            return r.json()
        })
        .then(j => {
            return j
        })
        .then(f => laatGerechtInfoZien(f))
}


haalReceptenOp().then(recepten => {
    lijstje.innerHTML = '';
    for (let r of recepten) {
        lijstje.innerHTML += `
                              <div class="recepten">
                                   <h2>${r.naam}</h2>
                                   <p>${r.omschrijving}</p>
                                   <img src="${r.plaatje}" height="250px" width="250px">
                                   <button class="gerechtKnop" onclick="haalReceptInformatieOp(event, '${r.naam}')">gerecht bekijken</button>
                                  
                              </div>`
    }
})


function verander(array) {
    let list = document.createElement('div');
    for (let i of array) {
        let item = document.createElement('span');
        item.innerHTML = i.naam + ': ' + i.hoeveelheid + `<br>`;
        list.appendChild(item)
    }

    return list;
}


function laatGerechtInfoZien(gerecht) {
    lijstje.innerHTML = '';
    lijstje.innerHTML += `
                              <div class="gerecht" id="gerecht">
                                   <h2>${gerecht.naam}</h2>
                                   <p>${gerecht.omschrijving}</p>
                                   <img src="${gerecht.plaatje}"  height="250px" width="250px">
                                   
                                   <p><strong>VoedingsWaarden:</strong><br>
                                   kilocalorieën: ${gerecht.energie} per portie<br>
                                    koolhydraten:  ${gerecht.koolhydraten} gram<br>
                                    eiwitten: ${gerecht.eiwitten} gram<br>
                                    vetten: ${gerecht.vetten} gram</p>
                                    
                                    <p><strong>BereidingsWijze:</strong><br>${gerecht.bereidingswijze}</p>
                                   <div id="foo"><strong>Ingredienten:</strong><br></div>
                                   <button onclick="printuit()">print</button>
                              </div>`

    document.getElementById('foo').appendChild(verander(gerecht.ingredienten));
}

function printuit() {
    window.print('gerecht')
}



