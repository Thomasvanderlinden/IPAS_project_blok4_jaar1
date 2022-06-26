function haalBlogOp(){
    return fetch('http://localhost:8080/restservices/blog')
        .then(r => {return r.json()})
        .then(j => {return j})
}
haalBlogOp()



let lijstje = document.getElementById('mijnLijst')

haalBlogOp().then(x => {
    lijstje.innerHTML = '';
    for(let o of x){
        lijstje.innerHTML += `<div id="blogArtikelen" <li> <h2> ${o.naam}</h2> <h3> ${o.onderwerp}</h3> <p>${o.tekst}</p></li></div>`

    }
})



let knop = document.getElementById('opsturen')
let formulier = document.querySelector('#artikelForumuler')


function versturenMaar(mening) {
    return fetch('http://localhost:8080/restservices/blog', {
        method: 'POST',
        body : JSON.stringify(mening),
        headers: {
            'Content-Type' : 'application/json'
        }
    })

}


//todo: nog kijken of we de lijst kunnen laten 'refreshen' met een functie, --> koffiecrud:

knop.addEventListener('click', r => {
    r.preventDefault()

    let rauweData = new FormData(formulier)

    let mening = {
        naam: rauweData.get('naam'),
        onderwerp: rauweData.get('onderwerp'),
        tekst: rauweData.get('tekst')
    }
    versturenMaar(mening)

})
