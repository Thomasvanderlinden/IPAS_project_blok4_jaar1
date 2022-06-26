function vraagSupplementenOp(){
    return fetch('http://localhost:8080/restservices/supplementen')
        .then(r =>{return r.json()})
        .then(s =>{return s})
}
vraagSupplementenOp()


let lijstje = document.getElementById('supplementenLijst')

vraagSupplementenOp().then(supplementen => {
    lijstje.innerHTML = '';
    for (let s of supplementen) {
        lijstje.innerHTML += `<div class="supplementen">
                                   <h2>${s.naam}</h2>
                                   <p>ff kijken wat hier komt</p> 
                              </div>`
    }
})