let lijstje = document.getElementById('mijnLijst')
let heroku = "https://ipasproject.herokuapp.com/"
let localhost = 'http://localhost:8080/';
let url = localhost


function convert(array) {
    let list = document.createElement('div');
    for (let i of array) {
        let item = document.createElement('span');
        item.innerHTML = `<h2>${i.naam}</h2>  <h3>${i.onderwerp}</h3>  <p>${i.tekst}</p> <br><div id="witruimte" style="height: 5px"  ></div><br>`;
        list.appendChild(item)
    }
    return list;
}

function haalBlogOp() {
    return fetch(url + 'restservices/blog')
        .then(r => {
            return r.json()
        })
        .then(j => {
            return j
        })
}

function geefBlogInfoWeer() {
    haalBlogOp().then(lijst => {
        lijstje.innerHTML = ''
        for (let x of Object.keys(lijst)) {
            let naam = lijst[x]

            lijstje.innerHTML += `<div class="blogArtikelen">
                                   <div id="foo"><br></div>
                                    </div>`

            document.getElementById('foo').appendChild(convert(naam));
        }
    })
}

geefBlogInfoWeer()


