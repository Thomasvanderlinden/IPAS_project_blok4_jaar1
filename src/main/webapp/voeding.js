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
                                   <button onclick="vraagGerechtInformatieOp(event, '${r.naam}')">gerecht bekijken</button>
                                  
                              </div>`
    }
})

//todo: dit nog weghalen hoor:
//http://jsfiddle.net/minitech/sTLbj/4/
//https://stackoverflow.com/questions/11128700/create-a-ul-and-fill-it-based-on-a-passed-array
function makeUL(array) {
    let list = document.createElement('ul');

    for (let i = 0; i < array.length; i++) {
        let item = document.createElement('li');

        item.appendChild(document.createTextNode(array[i]));

        list.appendChild(item);
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
                                   <p>energie: ${gerecht.energie}<br>
                                    koolhydraten:  ${gerecht.koolhydraten}<br>
                                    eiwitten: ${gerecht.eiwitten}<br>
                                    vetten: ${gerecht.vetten}</p>
                                   <div id="foo"></div>
                              </div>`
    document.getElementById('foo').appendChild(makeUL(gerecht));

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


