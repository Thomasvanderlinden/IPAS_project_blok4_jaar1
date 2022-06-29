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
        lijstje.innerHTML += `<div class="blogArtikelen" <li> <h2> ${o.naam}</h2> <h3> ${o.onderwerp}</h3> <p>${o.tekst}</p></li></div>`

    }
})



let knop = document.getElementById('opsturenBlog')
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

//todo: alleen mogen toevoegen als je bent ingelogd, anders proberen het stuk te verbergen als dat kan:

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
