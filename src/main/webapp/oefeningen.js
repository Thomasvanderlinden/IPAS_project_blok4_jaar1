function vraagOefeningeOp() {
    return fetch('http://localhost:8080/restservices/oefeningen')
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}


let lijstje = document.getElementById('oefeningenLijst')

vraagOefeningeOp().then(oefeningen => {
    lijstje.innerHTML = '';
    for (let o of oefeningen) {
        lijstje.innerHTML += `<div class="oefeningen">
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px"> 
                              </div>`
    }
})




