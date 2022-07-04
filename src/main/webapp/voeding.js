let heroku = "https://ipasproject.herokuapp.com/"
let localhost = 'http://localhost:8080/';
let url = localhost


function laatReceptenZien() {
    return fetch(url + 'restservices/voeding')
        .then(r => {
            return r.json()
        })
        .then(p => {
            return p
        })
}

laatReceptenZien()


let lijstje = document.getElementById('receptenLijst')


laatReceptenZien().then(recepten => {
    lijstje.innerHTML = '';
    for (let r of recepten) {
        lijstje.innerHTML += `

                              <div class="recepten">
                                   <h2>${r.naam}</h2>
                                   <p>${r.omschrijving}</p>
                                   <img src="${r.plaatje}" height="250px" width="250px">
                                   <button class="gerechtKnop" onclick="vraagGerechtInformatieOp(event, '${r.naam}')">gerecht bekijken</button>
                                  
                              </div>`
    }
})

//todo: dit nog weghalen hoor:
//http://jsfiddle.net/minitech/sTLbj/4/
//https://stackoverflow.com/questions/11128700/create-a-ul-and-fill-it-based-on-a-passed-array
function makeUL(array) {
    let list = document.createElement('div');
    for (let i of array) {
        let item = document.createElement('span');
        item.innerHTML = i.naam +': ' +  i.hoeveelheid + `<br>`;
        list.appendChild(item)
    }

    return list;
}



function geefGerechtInformatieWeer(gerecht) {
    lijstje.innerHTML = '';
    lijstje.innerHTML += `
                              <div class="gerecht">
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
                              </div>`
    document.getElementById('foo').appendChild(makeUL(gerecht.ingredienten));
}


function vraagGerechtInformatieOp(event, naam) {
    event.preventDefault()
    return fetch('http://localhost:8080/restservices/voeding/' + naam)
        .then(r => {
            return r.json()
        })
        .then(j => {
            return j
        })
        .then(f => geefGerechtInformatieWeer(f))


}


