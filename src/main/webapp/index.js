let inlogKnop = document.getElementById('inloggen')

inlogKnop.addEventListener('click', e =>{
    e.preventDefault()
    let inlogForm = document.forms['inlogFormulier']

    let data = {
        username: inlogForm.username.value,
        password: inlogForm.password.value,
    }
    login(data)

})


function login(credentials){
    
}
