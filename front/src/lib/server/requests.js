import {User} from "$lib/models/User.js";


/**
 *
 * @param {User} user
 * @returns {Promise<User>}
 * @constructor
 */
export async function RegisterUser(user){
    return new User({id : "", name : "", password : ""})
}

/**
 *
 * @param {User} user
 * @returns {Promise<User>}
 * @constructor
 */
export async function Authenticate(user){
    return new User({id : crypto.randomUUID(), name : "Test", password : "Test"})
}