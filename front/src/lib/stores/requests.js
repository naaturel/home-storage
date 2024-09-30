import {User} from "$lib/models/User.js";
import {userStore} from "$lib/stores/UserStore.js";


/**
 *
 * @param {User} user
 * @returns {Promise<User>}
 */
export async function RegisterUser(user){
    return new User({})
}

/**
 *
 * @param {string} name
 * @param {string} password
 */
export async function authenticate(name, password){

    await fetch("http://localhost:8000/api/user/authenticate", {
        method:"POST",
    })
        .then(response => {

            if(!response.ok) throw new Error(`${response.status} : ${response.body}`)
            return response.body

        })
        .then(data => {
            console.log(data)
        })
        .catch(error => {
            console.log(error)
        });

    userStore.set(new User({name:name, password:password}));
}