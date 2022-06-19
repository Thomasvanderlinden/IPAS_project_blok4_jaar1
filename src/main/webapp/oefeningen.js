function vraagOefeningeOp(){
    return fetch('http://localhost:8080/website/oefeningen')
        .then(function (data){return data.json()})
        .then(function (info){return info})
}

const iets = vraagOefeningeOp()
//
// const nieuwElement = document.createElement("p")
// const informatie = document.createTextNode("informatie")
// nieuwElement.appendChild(informatie)
//
// const element = document.getElementById("oefening")
// element.appendChild(nieuwElement)

console.log(iets)
