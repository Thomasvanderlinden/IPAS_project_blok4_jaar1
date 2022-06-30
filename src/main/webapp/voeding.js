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

function gerechtInfo(e) {
    console.log(e)
    window.location.href="gerechtLatenZien.html";
}

laatReceptenZien().then(recepten => {
    lijstje.innerHTML = '';
    for (let r of recepten) {
        lijstje.innerHTML += `




                              <div class="recepten">
                                   <h2>${r.naam}</h2>
                                   <p>${r.omschrijving}</p>
                                   <img src="${r.plaatje}" height="250px" width="250px">
                                   <button onclick="gerechtInfo('e')">gerecht bekijken</button>
                                  
                              </div>`
    }
})

