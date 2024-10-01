import {userStore} from "./UserStore";
import {User} from "../models/User";

export async function registerUser(name: string, password : string){
    return await handleRequest(JSON.stringify({name:name, password:password}));
}


export async function authenticate(name: string, password : string){
    return await handleRequest(JSON.stringify({name:name, password:password}));
}

async function handleRequest(data : string){
    return await fetch("http://localhost:8000/api/user/authenticate", {
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
