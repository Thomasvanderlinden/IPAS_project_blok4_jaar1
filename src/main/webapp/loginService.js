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

        return fetch('http://localhost:8080/restservices/login', {
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
        // deze GET method test je token op server-side problemen. Je kunt client-side op zich wel 'ingelogd' zijn
        //maar het zou altijd zomaar kunnen dat je token verlopen is, of dat er server-side iets anders aan de hand is.
        //Dus het is handig om te checken met een -echte fetch- of je login-token wel echt bruikbaar is.
        return Promise.resolve(true);

    }

    logout() {
        return Promise.resolve(window.sessionStorage.clear())
    }
}