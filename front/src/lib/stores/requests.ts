import {userStore} from "./UserStore";
import {User} from "../models/User";

export async function register(name: string, password : string){
    return await handleRequest(
        "http://localhost:8000/api/user/register",
        JSON.stringify({name:name, password:password}));
}


export async function authenticate(name: string, password : string){
    return await handleRequest(
        "http://localhost:8000/api/user/authenticate",
        JSON.stringify({name:name, password:password}));
}

async function handleRequest(url:string, data : string){
    return await fetch(url, {
        method:"POST",
        body : data,
        headers: new Headers({'content-type': 'application/json'})

    })
        .then(response => {
            if(response.status === 500) throw new Error(`${response.text()}`);
            if(!response.ok) throw new Error(`${response.status} : ${response.body}`);
            return response
        })
        .then(response => {
            return response.json();
        })
        .then(data => userStore.set(data))
        .catch(error => {
            return `Exception: ${error.message}`;
        });
}
