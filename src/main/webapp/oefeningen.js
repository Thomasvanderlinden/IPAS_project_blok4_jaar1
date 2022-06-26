function vraagOefeningeOp() {
    return fetch('http://localhost:8080/restservices/oefeningen')
        .then(function (data) {
            return data.json()
        })
        .then(function (info) {
            return info
        })
}


let lijstje = document.getElementById('proeflijst')

vraagOefeningeOp().then(oefeningen => {
    lijstje.innerHTML = '';

    for (let o of oefeningen) {

        lijstje.innerHTML += `<div class="oefeningen">
                                <li>
                                   <h2>${o.naam}</h2>
                                   <p>${o.spiergroep}</p>
                                   <img src="${o.plaatje}" width="130px" height="110px"> 
                                </li>
                              </div>`

    }

})

//todo: wat kan ik allemaal opvragen nu: naam, tijd, verbrande_kcal, spiergroep.


// const nieuwElement = document.createElement("p")
// const informatie = document.createTextNode("informatie")
// nieuwElement.appendChild(informatie)
//
// const element = document.getElementById("oefening")
// element.appendChild(nieuwElement)
//
// function refresh() {
//     let ulletje = document.querySelector('#koffielijst');
//     koffieService.getKoffieSoorten().then(koffiesoorten => {
//         ulletje.innerHTML = '';
//         for (let kf of koffiesoorten) {
//             ulletje.innerHTML += `<li>${kf.naam}</li>`
//         }
//     })
// }



