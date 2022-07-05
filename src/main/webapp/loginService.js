let heroku = "https://ipasproject.herokuapp.com/"
let localhost = 'http://localhost:8080/';
let url = localhost
export default class LoginService {
    token = '...'

    isLoggedIn() {
        if (window.sessionStorage.getItem("myJWT")) return true;
        else return false;
    }

    login(username, password) {
        let bodyCredentials = {username, password}

        //zodat als er niks ingevuld wordt er geen onnodige post gedaan hoeft te worden:
        if (username === "" || password === "") {
            return alert("je hebt geen inloggegevens ingevuld")
        }

        return fetch(url + 'restservices/login', {
            method: 'POST',
            body: JSON.stringify(bodyCredentials),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(r => {
            return r.json()
        }).then(j => {
            window.sessionStorage.setItem("myJWT", j.token);
        }).catch(() => alert("geen juiste inloggegevens ingevuld"))
    }


    getUser() {
        return Promise.resolve(true);
    }

    logout() {
        return Promise.resolve(window.sessionStorage.clear())
    }
}